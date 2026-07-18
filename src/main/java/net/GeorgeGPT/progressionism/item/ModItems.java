package net.GeorgeGPT.progressionism.item;

import net.GeorgeGPT.progressionism.Progressionism;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import java.util.function.Function;

public class ModItems {

    public static final Item RAW_TIN = registerItem("raw_tin", Item::new);
    public static final Item TIN_INGOT = registerItem("tin_ingot", Item::new);
    public static final Item TIN_NUGGET = registerItem("tin_nugget", Item::new);
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", Item::new);
    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget", Item::new);

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Progressionism.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Progressionism.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Progressionism.LOGGER.info("Registering Mod Items for" + Progressionism.MOD_ID);
    }
}
