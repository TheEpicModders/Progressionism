package net.GeorgeGPT.progressionism.block;

import net.GeorgeGPT.progressionism.Progressionism;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import java.util.function.Function;

public class ModBlocks {

    public static final Block TIN_ORE = registerBlock("tin_ore",
            properties -> new Block(properties.strength(3f, 3f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            properties -> new Block(properties.strength(4.5f, 3f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            properties -> new Block(properties.strength(3f, 6f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            properties -> new Block(properties.strength(3f, 6f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            properties -> new Block(properties.strength(3f, 6f)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Progressionism.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Progressionism.MOD_ID, name), toRegister);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Progressionism.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Progressionism.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        Progressionism.LOGGER.info("Registering Mod Blocks for " + Progressionism.MOD_ID);
    }
}
