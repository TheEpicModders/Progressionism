package net.GeorgeGPT.progressionism;

import net.GeorgeGPT.progressionism.block.ModBlocks;
import net.GeorgeGPT.progressionism.creativemodetab.ModCreativeModeTabs;
import net.GeorgeGPT.progressionism.item.ModItems;
import net.GeorgeGPT.progressionism.worldgen.ModPlacedFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Progressionism implements ModInitializer {
    public static final String MOD_ID = "progressionism";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModCreativeModeTabs.registerModCreativeModeTabs();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                ModPlacedFeatures.CUSTOM_ORE_PLACED_KEY
        );
    }
}
