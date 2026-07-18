package net.GeorgeGPT.progressionism.mixin;

import net.GeorgeGPT.progressionism.block.ModBlocks;
import net.GeorgeGPT.progressionism.worldgen.TinVeinStorage;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseBasedChunkGenerator.class)
public class TinVeinBlockMixin {

    @Inject(method = "fillFromNoise", at = @At("TAIL"))
    private void generateTinVeins(
            Blender blender,
            RandomState randomState,
            StructureManager structureManager,
            ChunkAccess centerChunk,
            CallbackInfoReturnable<ChunkAccess> cir
    ) {
        DensityFunction toggle = TinVeinStorage.toggle;
        DensityFunction ridged = TinVeinStorage.ridged;
        DensityFunction gap = TinVeinStorage.gap;

        if (toggle == null || ridged == null || gap == null) {
            return;
        }

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        int minY = centerChunk.getMinY();
        int maxY = centerChunk.getMaxY();

        for (int x = 0; x < 16; x++) {
            for (int y = minY; y < maxY; y++) {
                for (int z = 0; z < 16; z++) {

                    pos.set(
                            centerChunk.getPos().getMinBlockX() + x,
                            y,
                            centerChunk.getPos().getMinBlockZ() + z
                    );

                    DensityFunction.FunctionContext ctx = new DensityFunction.FunctionContext() {
                        @Override public int blockX() { return pos.getX(); }
                        @Override public int blockY() { return pos.getY(); }
                        @Override public int blockZ() { return pos.getZ(); }
                    };

                    double t = toggle.compute(ctx);
                    double r = ridged.compute(ctx);
                    double g = gap.compute(ctx);

                    boolean inVein = t > 0.0 && g < 0.0;
                    if (!inVein) continue;

                    BlockState current = centerChunk.getBlockState(pos);
                    if (!current.isSolid()) continue;

                    boolean raw = r > 0.0;

                    centerChunk.setBlockState(
                            pos,
                            raw ? ModBlocks.RAW_TIN_BLOCK.defaultBlockState()
                                    : ModBlocks.TIN_ORE.defaultBlockState(),
                            0 // correct update flag for your version
                    );
                }
            }
        }
    }
}
