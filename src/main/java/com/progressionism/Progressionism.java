package com.progressionism;

import com.progressionism.registry.ProgressionismBlocks;
import net.fabricmc.api.ModInitializer;

public class Progressionism implements ModInitializer {
    public static final String MODID = "better_progression";

    @Override
    public void onInitialize() {
        ProgressionismBlocks.registerItems();
    }

}
