package net.GeorgeGPT.progressionism.creativemodetab;

import net.GeorgeGPT.progressionism.Progressionism;
import net.GeorgeGPT.progressionism.block.ModBlocks;
import net.GeorgeGPT.progressionism.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {

    public static final CreativeModeTab PROGRESSIONISM_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Progressionism.MOD_ID, "progressionism"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TIN_BLOCK))
                    .title(Component.translatable("creativemodetab.progressionism.progressionism"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.TIN_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TIN_ORE);
                        output.accept(ModBlocks.TIN_BLOCK);
                        output.accept(ModBlocks.RAW_TIN_BLOCK);
                        output.accept(ModItems.RAW_TIN);
                        output.accept(ModItems.TIN_INGOT);
                        output.accept(ModItems.TIN_NUGGET);
                        output.accept(ModBlocks.BRONZE_BLOCK);
                        output.accept(ModItems.BRONZE_INGOT);
                        output.accept(ModItems.BRONZE_NUGGET);
                    })
                    .build());

    public static void registerModCreativeModeTabs() {
        Progressionism.LOGGER.info("Registering Creative Mode Tabs for " + Progressionism.MOD_ID);
    }
}
