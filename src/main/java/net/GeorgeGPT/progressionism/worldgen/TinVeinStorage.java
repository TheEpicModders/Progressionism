package net.GeorgeGPT.progressionism.worldgen;

import net.minecraft.world.level.levelgen.DensityFunction;

public class TinVeinStorage {

    // These will be filled by your NoiseRouter mixin
    public static DensityFunction toggle;
    public static DensityFunction ridged;
    public static DensityFunction gap;

    private TinVeinStorage() {
        // no instances
    }
}
