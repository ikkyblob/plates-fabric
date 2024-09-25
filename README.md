Plates 1.0.1 for fabric 0.104.0+1.21.1

Adds the plates density function; a cellular noise function which roughly
simulates the motion and distortion of tectonic plates.

The raw function outputs values ranging from -2.5 to 2, where oceanic plates
have a default range of -1 to 0 and continental plates range from 0 to 1.
Values in excess of -1 or 1 are caused by mountain building and subduction
around convergent plate boundaries.

NOTE: This function is a tool, and does not perfectly output for any base
noise, such as peaks and valleys or continentalness. For ideal results, use
splines, addition, and other density functions to alter the raw output.

Parameters (recommended default):
    "seed" (any): The desired minecraft seed. Due to technical limitations,
      this must be entered manually in current versions.
    "xz_scale" (2048): The size of the grid from which cells are generated, as
      measured in blocks.
    "jitter" (0.4): The maximum distance between the center of a grid square
      and the center of its corresponding cell. Measured as a multiple of the
      grid's scale factor; a jitter of 0.25 can be up to a quarter of the
      grid's full distance away from its center. At 0, cells align with the
      center of the grid. At 0.5, they can be anywhere in the grid square.
      Ranges from 0 to 0.5.
    "unFlatness" (1): A multiplier which scales the intensity of convergent
      features, such as the depth of subduction zones and the height of
      mountains. Values above 1 or below 0 may react unpredictably or exceed
      the function's normal range, and are not tested.
    "spread" (0.25): The distance over which a plate boundary will affect the
      surrounding terrain. Measured as a multiple of the grid's scale factor.
      Ranges from 0 to 0.5.
    "metric" (2): The metric used to measure distances. Accepts values of 0,
      1, and 2. 0 uses the "taxicab" metric, 1 is normal euclidean distance,
      and 2 is the chebyschev distance. Euclidean distance may lead to very
      straight edges when used without additional noise layers.
    "contBias" (0): A value which skews which plates are considered continetal
      or oceanic. Plates with a base output value above the contBias are
      continental, and below are oceanic. Ranges from -1 to 1. 0 is a 50/50
      split of continent vs. ocean, -1 is all continental, 1 is all oceanic.
      For an earthlike split, with 70% water and 30% land, use 0.4.

example continents.json config:
{
  "type": "minecraft:flat_cache",
  "argument": {
    "type": "minecraft:add",
    "argument1": {
      "seed": 0,
	    "type": "ikbplates:plates",
  	  "xz_scale": 4096,
	    "jitter": 0.4,
	    "unFlatness": 1,
	    "spread": 0.25,
	    "metric": 2,
	    "contBias": 0
     },
    "argument2": -0.19
  }
}
