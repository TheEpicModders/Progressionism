package com.progressionism.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ProgressionismBlocks {

    public static final String MODID = "progressionism";

    public static final Identifier TIN_ORE_ID = Identifier.of(MODID, "tin_ore");
    public static final Identifier DEEPSLATE_TIN_ORE_ID = Identifier.of(MODID, "deepslate_tin_ore");
    public static final Identifier TIN_BLOCK_ID = Identifier.of(MODID, "tin_block");
    public static final Identifier RAW_TIN_BLOCK_ID = Identifier.of(MODID, "raw_tin_block");

    public static final RegistryKey<Block> TIN_ORE_KEY = RegistryKey.of(RegistryKeys.BLOCK, TIN_ORE_ID);
    public static final RegistryKey<Block> DEEPSLATE_TIN_ORE_KEY = RegistryKey.of(RegistryKeys.BLOCK, DEEPSLATE_TIN_ORE_ID);
    public static final RegistryKey<Block> TIN_BLOCK_KEY = RegistryKey.of(RegistryKeys.BLOCK, TIN_BLOCK_ID);
    public static final RegistryKey<Block> RAW_TIN_BLOCK_KEY = RegistryKey.of(RegistryKeys.BLOCK, RAW_TIN_BLOCK_ID);

    public static final RegistryKey<Item> TIN_ORE_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, TIN_ORE_ID);
    public static final RegistryKey<Item> DEEPSLATE_TIN_ORE_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, DEEPSLATE_TIN_ORE_ID);
    public static final RegistryKey<Item> TIN_BLOCK_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, TIN_BLOCK_ID);
    public static final RegistryKey<Item> RAW_TIN_BLOCK_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, RAW_TIN_BLOCK_ID);

    public static final Block TIN_ORE = new Block(
            AbstractBlock.Settings.create()
                    .strength(2.5F, 3.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
                    .registryKey(TIN_ORE_KEY)
    );
    public static final Block DEEPSLATE_TIN_ORE = new Block(
            AbstractBlock.Settings.create()
                    .strength(3.5F, 3.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .registryKey(DEEPSLATE_TIN_ORE_KEY)
    );
    public static final Block TIN_BLOCK = new Block(
            AbstractBlock.Settings.create()
                    .strength(4.0F, 6.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.IRON)
                    .registryKey(TIN_BLOCK_KEY)
    );
    public static final Block RAW_TIN_BLOCK = new Block(
            AbstractBlock.Settings.create()
                    .strength(3.0F, 6.0F)
                    .sounds(BlockSoundGroup.IRON)
                    .registryKey(RAW_TIN_BLOCK_KEY)

    );

    public static void registerItems() {

        Registry.register(Registries.BLOCK, TIN_ORE_KEY, TIN_ORE);
        Registry.register(Registries.BLOCK, DEEPSLATE_TIN_ORE_KEY, DEEPSLATE_TIN_ORE);
        Registry.register(Registries.BLOCK, TIN_BLOCK_KEY, TIN_BLOCK);
        Registry.register(Registries.BLOCK, RAW_TIN_BLOCK_KEY, RAW_TIN_BLOCK);

        Item.Settings itemSettings = new Item.Settings()
                .registryKey(TIN_ORE_ITEM_KEY)
                .useBlockPrefixedTranslationKey();
        Item.Settings itemSettings_1 = new Item.Settings()
                .registryKey(DEEPSLATE_TIN_ORE_ITEM_KEY)
                .useBlockPrefixedTranslationKey();
        Item.Settings itemSettings_2 = new Item.Settings()
                .registryKey(TIN_BLOCK_ITEM_KEY)
                .useBlockPrefixedTranslationKey();
        Item.Settings itemSettings_3 = new Item.Settings()
                .registryKey(RAW_TIN_BLOCK_ITEM_KEY)
                .useBlockPrefixedTranslationKey();

        BlockItem blockItem = new BlockItem(TIN_ORE, itemSettings);
        BlockItem blockItem2 = new BlockItem(DEEPSLATE_TIN_ORE, itemSettings_1);
        BlockItem blockItem3 = new BlockItem(TIN_BLOCK, itemSettings_2);
        BlockItem blockItem4 = new BlockItem(RAW_TIN_BLOCK, itemSettings_3);

        Registry.register(Registries.ITEM, TIN_ORE_ITEM_KEY, blockItem);
        Registry.register(Registries.ITEM, DEEPSLATE_TIN_ORE_ITEM_KEY, blockItem2);
        Registry.register(Registries.ITEM, TIN_BLOCK_ITEM_KEY, blockItem3);
        Registry.register(Registries.ITEM, RAW_TIN_BLOCK_ITEM_KEY, blockItem4);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries -> {
                    entries.addAfter(Items.DEEPSLATE_DIAMOND_ORE, blockItem);
                    entries.addAfter(ProgressionismBlocks.TIN_ORE, blockItem2);
                    entries.addAfter(Items.RAW_GOLD_BLOCK, blockItem4);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(entries -> {
                    entries.add(blockItem3);
                });
    }
}