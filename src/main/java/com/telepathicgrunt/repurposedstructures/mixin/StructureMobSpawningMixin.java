package com.telepathicgrunt.repurposedstructures.mixin;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.telepathicgrunt.repurposedstructures.modinit.RSStructureTagMap;
import com.telepathicgrunt.repurposedstructures.modinit.RSStructures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(NoiseChunkGenerator.class)
public class StructureMobSpawningMixin {

    @Inject(
            method = "getEntitySpawnList(Lnet/minecraft/world/biome/Biome;Lnet/minecraft/world/gen/feature/structure/StructureManager;Lnet/minecraft/entity/EntityClassification;Lnet/minecraft/util/math/BlockPos;)Ljava/util/List;",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void structureMobs(Biome biome, StructureManager accessor, EntityClassification group, BlockPos pos, CallbackInfoReturnable<List<MobSpawnInfo.Spawners>> cir) {
        List<MobSpawnInfo.Spawners> list = getStructureSpawns(biome, accessor, group, pos);
        if(list != null) cir.setReturnValue(list);
    }


    private static List<MobSpawnInfo.Spawners>  getStructureSpawns(Biome biome, StructureManager accessor, EntityClassification group, BlockPos pos){
        if (group == EntityClassification.MONSTER) {

            for(Structure<?> outpost : RSStructureTagMap.REVERSED_TAGGED_STRUCTURES.get(RSStructureTagMap.STRUCTURE_TAGS.NETHER_OUTPOST)){
                if (accessor.getStructureAt(pos, true, outpost).isValid()) {
                    return outpost.getSpawnList();
                }
            }

            for(Structure<?> shipwreck : RSStructureTagMap.REVERSED_TAGGED_STRUCTURES.get(RSStructureTagMap.STRUCTURE_TAGS.NETHER_SHIPWRECK)){
                if (accessor.getStructureAt(pos, true, shipwreck).isValid()) {
                    return Lists.newArrayList(Iterators.concat(biome.getSpawnSettings().getSpawnEntry(EntityClassification.MONSTER).iterator(), shipwreck.getSpawnList().iterator()));
                }
            }

            if (accessor.getStructureAt(pos, true, RSStructures.NETHER_STRONGHOLD.get()).isValid()) {
                return RSStructures.NETHER_STRONGHOLD.get().getSpawnList();
            }

            if (accessor.getStructureAt(pos, true, RSStructures.JUNGLE_FORTRESS.get()).isValid()) {
                return Lists.newArrayList(Iterators.concat(biome.getSpawnSettings().getSpawnEntry(EntityClassification.MONSTER).iterator(), RSStructures.JUNGLE_FORTRESS.get().getSpawnList().iterator()));
            }

            if (accessor.getStructureAt(pos, true, RSStructures.END_MINESHAFT.get()).isValid()) {
                return Lists.newArrayList(Iterators.concat(biome.getSpawnSettings().getSpawnEntry(EntityClassification.MONSTER).iterator(), RSStructures.END_MINESHAFT.get().getSpawnList().iterator()));
            }

            for(Structure<?> outpost : RSStructureTagMap.REVERSED_TAGGED_STRUCTURES.get(RSStructureTagMap.STRUCTURE_TAGS.OVERWORLD_OUTPOST)){
                if (accessor.getStructureAt(pos, true, outpost).isValid()) {
                    // Use vanilla outpost for max mod compat. I think. Might redo this if I receive complaints
                    return Structure.PILLAGER_OUTPOST.getDefaultSpawnList();
                }
            }
        }

        return null;
    }
}