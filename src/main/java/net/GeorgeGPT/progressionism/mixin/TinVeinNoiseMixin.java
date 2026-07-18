package net.GeorgeGPT.progressionism.mixin;

import net.GeorgeGPT.progressionism.worldgen.TinVeinStorage;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.core.HolderGetter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseRouterData.class)
public class TinVeinNoiseMixin {

    @Inject(method = "overworld", at = @At("RETURN"))
    private static void captureTinVeinNoise(
            HolderGetter<DensityFunction> functions,
            HolderGetter<NormalNoise.NoiseParameters> noises,
            boolean largeBiomes,
            boolean amplified,
            CallbackInfoReturnable<NoiseRouter> cir
    ) {
        NoiseRouter router = cir.getReturnValue();

        TinVeinStorage.toggle = router.veinToggle();
        TinVeinStorage.ridged = router.veinRidged();
        TinVeinStorage.gap = router.veinGap();
    }
}


