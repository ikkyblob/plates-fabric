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
