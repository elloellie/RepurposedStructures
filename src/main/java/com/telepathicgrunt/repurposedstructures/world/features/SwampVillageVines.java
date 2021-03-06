package com.telepathicgrunt.repurposedstructures.world.features;

import com.mojang.serialization.Codec;
import com.telepathicgrunt.repurposedstructures.modinit.RSFeatures;
import com.telepathicgrunt.repurposedstructures.modinit.RSStructures;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;


public class SwampVillageVines extends Feature<NoFeatureConfig> {

    public SwampVillageVines(Codec<NoFeatureConfig> configFactory) {
        super(configFactory);
    }


    @Override
    public boolean generate(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos position, NoFeatureConfig config) {
        if (world.isAirBlock(position) && world.getStructures(SectionPos.from(position), RSStructures.SWAMP_VILLAGE.get()).findAny().isPresent()) {
            RSFeatures.SHORT_VINES.get().generate(world, chunkGenerator, random, position, NoFeatureConfig.NO_FEATURE_CONFIG);
            return true;
        }
        return false;
    }
}