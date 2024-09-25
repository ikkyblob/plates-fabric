package net.ikb.plates;

import net.fabricmc.api.ModInitializer;

import net.ikb.plates.densityfunction.PlatesDensityFunction;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IkbPlates implements ModInitializer {
	public static final String MOD_ID = "ikbplates";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		IkbPlates.LOGGER.info("Registering Plates Density Function for " + IkbPlates.MOD_ID);
		Registry.register(Registries.DENSITY_FUNCTION_TYPE, Identifier.of(IkbPlates.MOD_ID, "plates"), PlatesDensityFunction.CODEC.codec());
	}
}