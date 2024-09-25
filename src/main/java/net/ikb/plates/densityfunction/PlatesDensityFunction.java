
package net.ikb.plates.densityfunction;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

//use very small values of xzScale to get very large cells?
public record PlatesDensityFunction(long seed, float xzScale, float jitter, float unFlatness, float spread, int metric, float contBias) implements DensityFunction {
    private static final PlatesNoise sampler = new PlatesNoise();

    private static final MapCodec<PlatesDensityFunction> MAP_CODEC = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(
                    Codec.LONG.fieldOf("seed").forGetter(PlatesDensityFunction::seed),
                    Codec.FLOAT.fieldOf("xz_scale").forGetter(PlatesDensityFunction::xzScale),
                    Codec.floatRange(0.0f,0.5f).fieldOf("jitter").forGetter(PlatesDensityFunction::jitter),
                    Codec.FLOAT.fieldOf("unFlatness").forGetter(PlatesDensityFunction::unFlatness), //screwing with this can get REALLY weird, and might screw with min and max values
                    Codec.floatRange(0.0f,0.5f).fieldOf("spread").forGetter(PlatesDensityFunction::spread),
                    Codec.intRange(0,2).fieldOf("metric").forGetter(PlatesDensityFunction::metric),
                    Codec.floatRange(-1.0f,1.0f).fieldOf("contBias").forGetter(PlatesDensityFunction::contBias)
            ).apply(instance, (PlatesDensityFunction::new)));
    public static final CodecHolder<PlatesDensityFunction> CODEC = CodecHolder.of(MAP_CODEC);

    @Override
    public double sample(NoisePos pos) {
        return sampler.platesNoise(seed, (float) pos.blockX() / xzScale, (float) pos.blockZ() / xzScale, jitter, unFlatness, spread, metric, contBias);
    }

    @Override
    public void fill(double[] densities, EachApplier applier) {
        applier.fill(densities, this);
    }

    @Override
    public DensityFunction apply(DensityFunction.DensityFunctionVisitor visitor) {
        return visitor.apply(new PlatesDensityFunction(this.seed, this.xzScale, this.jitter, this.unFlatness, this.spread, this.metric, this.contBias));
    }

    @Override
    public double minValue() {
        return -2.5;
    }

    @Override
    public double maxValue() {
        return 2;
    }

    @Override
    public CodecHolder<? extends DensityFunction> getCodecHolder() {
        return null;
    }

}
