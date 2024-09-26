// MIT License
//
// FastNoise Copyright(c) 2023 Jordan Peck (jordan.me2@gmail.com)
// FastNoiseLite Copyright(c) 2023 Contributors
// Plates Copyright(c) 2024 ikkyblob@gmail.com
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files(the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and / or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions :
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package net.ikb.plates.densityfunction;


public class PlatesNoise {
    private static final float[] RandVecs = { //
            -0.2700222198f, -0.9628540911f, 0.3863092627f, -0.9223693152f, 0.04444859006f, -0.999011673f, -0.5992523158f, -0.8005602176f, -0.7819280288f, 0.6233687174f, 0.9464672271f, 0.3227999196f, -0.6514146797f, -0.7587218957f, 0.9378472289f, 0.347048376f,
            -0.8497875957f, -0.5271252623f, -0.879042592f, 0.4767432447f, -0.892300288f, -0.4514423508f, -0.379844434f, -0.9250503802f, -0.9951650832f, 0.0982163789f, 0.7724397808f, -0.6350880136f, 0.7573283322f, -0.6530343002f, -0.9928004525f, -0.119780055f,
            -0.0532665713f, 0.9985803285f, 0.9754253726f, -0.2203300762f, -0.7665018163f, 0.6422421394f, 0.991636706f, 0.1290606184f, -0.994696838f, 0.1028503788f, -0.5379205513f, -0.84299554f, 0.5022815471f, -0.8647041387f, 0.4559821461f, -0.8899889226f,
            -0.8659131224f, -0.5001944266f, 0.0879458407f, -0.9961252577f, -0.5051684983f, 0.8630207346f, 0.7753185226f, -0.6315704146f, -0.6921944612f, 0.7217110418f, -0.5191659449f, -0.8546734591f, 0.8978622882f, -0.4402764035f, -0.1706774107f, 0.9853269617f,
            -0.9353430106f, -0.3537420705f, -0.9992404798f, 0.03896746794f, -0.2882064021f, -0.9575683108f, -0.9663811329f, 0.2571137995f, -0.8759714238f, -0.4823630009f, -0.8303123018f, -0.5572983775f, 0.05110133755f, -0.9986934731f, -0.8558373281f, -0.5172450752f,
            0.09887025282f, 0.9951003332f, 0.9189016087f, 0.3944867976f, -0.2439375892f, -0.9697909324f, -0.8121409387f, -0.5834613061f, -0.9910431363f, 0.1335421355f, 0.8492423985f, -0.5280031709f, -0.9717838994f, -0.2358729591f, 0.9949457207f, 0.1004142068f,
            0.6241065508f, -0.7813392434f, 0.662910307f, 0.7486988212f, -0.7197418176f, 0.6942418282f, -0.8143370775f, -0.5803922158f, 0.104521054f, -0.9945226741f, -0.1065926113f, -0.9943027784f, 0.445799684f, -0.8951327509f, 0.105547406f, 0.9944142724f,
            -0.992790267f, 0.1198644477f, -0.8334366408f, 0.552615025f, 0.9115561563f, -0.4111755999f, 0.8285544909f, -0.5599084351f, 0.7217097654f, -0.6921957921f, 0.4940492677f, -0.8694339084f, -0.3652321272f, -0.9309164803f, -0.9696606758f, 0.2444548501f,
            0.08925509731f, -0.996008799f, 0.5354071276f, -0.8445941083f, -0.1053576186f, 0.9944343981f, -0.9890284586f, 0.1477251101f, 0.004856104961f, 0.9999882091f, 0.9885598478f, 0.1508291331f, 0.9286129562f, -0.3710498316f, -0.5832393863f, -0.8123003252f,
            0.3015207509f, 0.9534596146f, -0.9575110528f, 0.2883965738f, 0.9715802154f, -0.2367105511f, 0.229981792f, 0.9731949318f, 0.955763816f, -0.2941352207f, 0.740956116f, 0.6715534485f, -0.9971513787f, -0.07542630764f, 0.6905710663f, -0.7232645452f,
            -0.290713703f, -0.9568100872f, 0.5912777791f, -0.8064679708f, -0.9454592212f, -0.325740481f, 0.6664455681f, 0.74555369f, 0.6236134912f, 0.7817328275f, 0.9126993851f, -0.4086316587f, -0.8191762011f, 0.5735419353f, -0.8812745759f, -0.4726046147f,
            0.9953313627f, 0.09651672651f, 0.9855650846f, -0.1692969699f, -0.8495980887f, 0.5274306472f, 0.6174853946f, -0.7865823463f, 0.8508156371f, 0.52546432f, 0.9985032451f, -0.05469249926f, 0.1971371563f, -0.9803759185f, 0.6607855748f, -0.7505747292f,
            -0.03097494063f, 0.9995201614f, -0.6731660801f, 0.739491331f, -0.7195018362f, -0.6944905383f, 0.9727511689f, 0.2318515979f, 0.9997059088f, -0.0242506907f, 0.4421787429f, -0.8969269532f, 0.9981350961f, -0.061043673f, -0.9173660799f, -0.3980445648f,
            -0.8150056635f, -0.5794529907f, -0.8789331304f, 0.4769450202f, 0.0158605829f, 0.999874213f, -0.8095464474f, 0.5870558317f, -0.9165898907f, -0.3998286786f, -0.8023542565f, 0.5968480938f, -0.5176737917f, 0.8555780767f, -0.8154407307f, -0.5788405779f,
            0.4022010347f, -0.9155513791f, -0.9052556868f, -0.4248672045f, 0.7317445619f, 0.6815789728f, -0.5647632201f, -0.8252529947f, -0.8403276335f, -0.5420788397f, -0.9314281527f, 0.363925262f, 0.5238198472f, 0.8518290719f, 0.7432803869f, -0.6689800195f,
            -0.985371561f, -0.1704197369f, 0.4601468731f, 0.88784281f, 0.825855404f, 0.5638819483f, 0.6182366099f, 0.7859920446f, 0.8331502863f, -0.553046653f, 0.1500307506f, 0.9886813308f, -0.662330369f, -0.7492119075f, -0.668598664f, 0.743623444f,
            0.7025606278f, 0.7116238924f, -0.5419389763f, -0.8404178401f, -0.3388616456f, 0.9408362159f, 0.8331530315f, 0.5530425174f, -0.2989720662f, -0.9542618632f, 0.2638522993f, 0.9645630949f, 0.124108739f, -0.9922686234f, -0.7282649308f, -0.6852956957f,
            0.6962500149f, 0.7177993569f, -0.9183535368f, 0.3957610156f, -0.6326102274f, -0.7744703352f, -0.9331891859f, -0.359385508f, -0.1153779357f, -0.9933216659f, 0.9514974788f, -0.3076565421f, -0.08987977445f, -0.9959526224f, 0.6678496916f, 0.7442961705f,
            0.7952400393f, -0.6062947138f, -0.6462007402f, -0.7631674805f, -0.2733598753f, 0.9619118351f, 0.9669590226f, -0.254931851f, -0.9792894595f, 0.2024651934f, -0.5369502995f, -0.8436138784f, -0.270036471f, -0.9628500944f, -0.6400277131f, 0.7683518247f,
            -0.7854537493f, -0.6189203566f, 0.06005905383f, -0.9981948257f, -0.02455770378f, 0.9996984141f, -0.65983623f, 0.751409442f, -0.6253894466f, -0.7803127835f, -0.6210408851f, -0.7837781695f, 0.8348888491f, 0.5504185768f, -0.1592275245f, 0.9872419133f,
            0.8367622488f, 0.5475663786f, -0.8675753916f, -0.4973056806f, -0.2022662628f, -0.9793305667f, 0.9399189937f, 0.3413975472f, 0.9877404807f, -0.1561049093f, -0.9034455656f, 0.4287028224f, 0.1269804218f, -0.9919052235f, -0.3819600854f, 0.924178821f,
            0.9754625894f, 0.2201652486f, -0.3204015856f, -0.9472818081f, -0.9874760884f, 0.1577687387f, 0.02535348474f, -0.9996785487f, 0.4835130794f, -0.8753371362f, -0.2850799925f, -0.9585037287f, -0.06805516006f, -0.99768156f, -0.7885244045f, -0.6150034663f,
            0.3185392127f, -0.9479096845f, 0.8880043089f, 0.4598351306f, 0.6476921488f, -0.7619021462f, 0.9820241299f, 0.1887554194f, 0.9357275128f, -0.3527237187f, -0.8894895414f, 0.4569555293f, 0.7922791302f, 0.6101588153f, 0.7483818261f, 0.6632681526f,
            -0.7288929755f, -0.6846276581f, 0.8729032783f, -0.4878932944f, 0.8288345784f, 0.5594937369f, 0.08074567077f, 0.9967347374f, 0.9799148216f, -0.1994165048f, -0.580730673f, -0.8140957471f, -0.4700049791f, -0.8826637636f, 0.2409492979f, 0.9705377045f,
            0.9437816757f, -0.3305694308f, -0.8927998638f, -0.4504535528f, -0.8069622304f, 0.5906030467f, 0.06258973166f, 0.9980393407f, -0.9312597469f, 0.3643559849f, 0.5777449785f, 0.8162173362f, -0.3360095855f, -0.941858566f, 0.697932075f, -0.7161639607f,
            -0.002008157227f, -0.9999979837f, -0.1827294312f, -0.9831632392f, -0.6523911722f, 0.7578824173f, -0.4302626911f, -0.9027037258f, -0.9985126289f, -0.05452091251f, -0.01028102172f, -0.9999471489f, -0.4946071129f, 0.8691166802f, -0.2999350194f, 0.9539596344f,
            0.8165471961f, 0.5772786819f, 0.2697460475f, 0.962931498f, -0.7306287391f, -0.6827749597f, -0.7590952064f, -0.6509796216f, -0.907053853f, 0.4210146171f, -0.5104861064f, -0.8598860013f, 0.8613350597f, 0.5080373165f, 0.5007881595f, -0.8655698812f,
            -0.654158152f, 0.7563577938f, -0.8382755311f, -0.545246856f, 0.6940070834f, 0.7199681717f, 0.06950936031f, 0.9975812994f, 0.1702942185f, -0.9853932612f, 0.2695973274f, 0.9629731466f, 0.5519612192f, -0.8338697815f, 0.225657487f, -0.9742067022f,
            0.4215262855f, -0.9068161835f, 0.4881873305f, -0.8727388672f, -0.3683854996f, -0.9296731273f, -0.9825390578f, 0.1860564427f, 0.81256471f, 0.5828709909f, 0.3196460933f, -0.9475370046f, 0.9570913859f, 0.2897862643f, -0.6876655497f, -0.7260276109f,
            -0.9988770922f, -0.047376731f, -0.1250179027f, 0.992154486f, -0.8280133617f, 0.560708367f, 0.9324863769f, -0.3612051451f, 0.6394653183f, 0.7688199442f, -0.01623847064f, -0.9998681473f, -0.9955014666f, -0.09474613458f, -0.81453315f, 0.580117012f,
            0.4037327978f, -0.9148769469f, 0.9944263371f, 0.1054336766f, -0.1624711654f, 0.9867132919f, -0.9949487814f, -0.100383875f, -0.6995302564f, 0.7146029809f, 0.5263414922f, -0.85027327f, -0.5395221479f, 0.841971408f, 0.6579370318f, 0.7530729462f,
            0.01426758847f, -0.9998982128f, -0.6734383991f, 0.7392433447f, 0.639412098f, -0.7688642071f, 0.9211571421f, 0.3891908523f, -0.146637214f, -0.9891903394f, -0.782318098f, 0.6228791163f, -0.5039610839f, -0.8637263605f, -0.7743120191f, -0.6328039957f,
    };
    private static final int[][] iVecX = {
            {0,0,0,1,1,1,1,1,1},
            {0,0,0,1,1,1,1,1,1},
            {0,0,0,1,1,1,1,1,1},
            {-1,-1,-1,0,0,0,1,1,1},
            {-1,-1,-1,0,0,0,1,1,1},
            {-1,-1,-1,0,0,0,1,1,1},
            {-1,-1,-1,-1,-1,-1,0,0,0},
            {-1,-1,-1,-1,-1,-1,0,0,0},
            {-1,-1,-1,-1,-1,-1,0,0,0}
    };
    private static final int[][] iVecZ = {
            {0,1,1,0,1,1,0,1,1},
            {-1,0,1,-1,0,1,-1,0,1},
            {-1,-1,0,-1,-1,0,-1,-1,0},
            {0,1,1,0,1,1,0,1,1},
            {-1,0,1,-1,0,1,-1,0,1},
            {-1,-1,0,-1,-1,0,-1,-1,0},
            {0,1,1,0,1,1,0,1,1},
            {-1,0,1,-1,0,1,-1,0,1},
            {-1,-1,0,-1,-1,0,-1,-1,0}
    };
    private float getDist (float dx, float dz, int metric){
        return switch (metric) {
            case 0 -> dx + dz;
            default -> (float) Math.sqrt(dx * dx + dz * dz);
            case 2 -> Math.max(Math.abs(dx), Math.abs(dz));
        };
    }
    private static final int PrimeX = 501125321;
    private static final int PrimeZ = 1720413743;
    private static int hash (long seed, int xPrimed, int zPrimed){
        return (int) ((seed ^ xPrimed ^ zPrimed) * 0x27d4eb2d);
    }
    private int roundInt(float f) {
        return f >=0 ? (int) (f + 0.5) : (int) (f - 0.5);
    }
    private float plateBaseValue(int hash){
      return 1 + (hash * (1 / 2147483648.0f));
    }
    public float platesNoise(long seed, float x, float z, float jitter, float unFlatness, float spread, int metric, float contBias){
        int xr = roundInt(x);
        int zr = roundInt(z);

        float distNear = Float.MAX_VALUE;
        float distNearest = Float.MAX_VALUE;
        int closeHash = 0;
        int closestHash = 0;
        int closeIndex = 0;
        int closestIndex = 0;
        int i = -1;

        int xPrimed = (xr - 1) * PrimeX;
        int zPrimed0 = (zr - 1) * PrimeZ;

        //check all plates for the nearest and second-nearest (near)
        for (int xi = xr - 1; xi <= xr + 1; xi++) {
            int zPrimed = zPrimed0;
            for (int zi = zr -1; zi <= zr + 1; zi++) {
                i++;
                int hash = hash(seed, xPrimed, zPrimed);
                int idx = hash & 0x1FE;
                float dx = (xi - x) + RandVecs[idx] * jitter;
                float dz = (zi - z) + RandVecs[idx | 1] * jitter;
                float newDist = getDist (dx, dz, metric);

                if (newDist < distNear) {
                    if (newDist < distNearest) {
                        distNear = distNearest;
                        closeHash = closestHash;
                        closeIndex = closestIndex;
                        distNearest = newDist;
                        closestHash = hash;
                        closestIndex = i;
                    }
                    else {
                        distNear = newDist;
                        closeHash = hash;
                        closeIndex = i;
                    }
                }
                zPrimed += PrimeZ;
            }
            xPrimed += PrimeX;
        }

        // non-FastNoise contribution begins here
        if (distNear - distNearest <= spread) {

            //reserve relative distance
            float distRel = distNear - distNearest;

            //initialize the relative position of the two closest plates
            int closestToCloseX = iVecX[closestIndex][closeIndex];
            int closestToCloseZ = iVecZ[closestIndex][closeIndex];

            //initialize the velocity and value of the two closest plates
            int dirClosestX = closestHash % 3 - 2;
            int dirClosestZ = ((closestHash % 9) - (closestHash % 3)) / 3 - 2;
            float closestValue = plateBaseValue(closestHash);
            int dirCloseX = closeHash % 3 - 2;
            int dirCloseZ = ((closeHash % 9) - (closestHash % 3)) / 3 - 2;
            float closeValue = plateBaseValue(closeHash);

            //check direction of motion between the two plates
            int dirRel = (closestToCloseX * (dirClosestX - dirCloseX)) - (closestToCloseZ * (dirClosestZ - dirCloseZ));
            float bonus = 0f;
            if (dirRel > 0) { //colliding plates
                float mountBonus = ((1.5f * unFlatness * Math.max(closestValue, closeValue)) - closestValue);
                if (closestValue > 1 + contBias || closestValue > closeValue) //closest is an overriding or continental plate
                    bonus = mountBonus * (1 - (distRel / spread));
                else //closest plate is being subducted
                    bonus = mountBonus * (Math.abs(1 - ((2 * distRel) / spread)) - (distRel / spread));
            } else if (dirRel < 0 && closestValue <= 1 + contBias && closeValue <= 1 + contBias) { //mid-ocean ridge; rifting and both are oceanic
                bonus = ((1 + contBias - Math.max(closestValue, closeValue)) * 0.5f * (1 - Math.abs((2 * (distRel / spread)) - 1))) + (((Math.min(closestValue, closeValue) * 0.5f) - closestValue) * (1 - distRel /spread));
            }
            else if (closestValue > closeValue && (dirRel < 0 || (dirClosestX == dirCloseX && dirClosestZ == dirCloseZ))) //as long as this is the taller plate and they're either rifting or co-moving
                bonus = -((closestValue - closeValue) * (1 - distRel / spread));
            else if (distRel * 4 <= spread && closestValue > closeValue) //defaults to transform, which has a more abrupt change
                bonus = -((closestValue - closeValue) * (1 - (distRel * 4) / spread));
            return closestValue + bonus - 1;
        }
        return plateBaseValue(closestHash) - 1;
    }
}
