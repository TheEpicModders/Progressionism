package net.GeorgeGPT.progressionism.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> CUSTOM_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath("progressionism", "tin_ore"));

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(CUSTOM_ORE_PLACED_KEY, new PlacedFeature(
                configuredFeatures.getOrThrow(ModConfiguredFeatures.CUSTOM_ORE_KEY),
                List.of(
                        CountPlacement.of(16),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.of(
                                TrapezoidHeight.of(
                                        VerticalAnchor.absolute(-16),
                                        VerticalAnchor.absolute(112)
                                )
                        ),
                        BiomeFilter.biome()
                )
        ));
    }
}
