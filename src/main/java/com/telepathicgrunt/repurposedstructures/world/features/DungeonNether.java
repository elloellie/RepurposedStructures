package com.telepathicgrunt.repurposedstructures.world.features;

import com.mojang.serialization.Codec;
import com.telepathicgrunt.repurposedstructures.RepurposedStructures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;


public class DungeonNether extends Feature<NoFeatureConfig> {
    public DungeonNether(Codec<NoFeatureConfig> configFactory) {
        super(configFactory);
    }

    private static final Logger LOGGER = LogManager.getLogger();
    private static final BlockState CAVE_AIR = Blocks.CAVE_AIR.getDefaultState();
    private static final ResourceLocation CHEST_LOOT = new ResourceLocation(RepurposedStructures.MODID + ":chests/dungeon/nether");
    private static final ResourceLocation HIGH_SPAWNER_ID = new ResourceLocation(RepurposedStructures.MODID + ":dungeon_nether_high");
    private static final ResourceLocation LOW_SPAWNER_ID = new ResourceLocation(RepurposedStructures.MODID + ":dungeon_nether_low");


    // only the mob spawner chance and what blocks the wall cannot replace was changed. Everything else is just the normal dungeon code.

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos position, NoFeatureConfig config) {
        int randXRange = random.nextInt(2) + 2;
        int xMin = -randXRange - 1;
        int xMax = randXRange + 1;
        int randZRange = random.nextInt(2) + 2;
        int zMin = -randZRange - 1;
        int zMax = randZRange + 1;
        int validOpenings = 0;
        int ceilingOpenings = 0;
        BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable().setPos(position);
        BlockState blockstate;

        for (int x = xMin; x <= xMax; ++x) {
            for (int y = -1; y <= 4; ++y) {
                for (int z = zMin; z <= zMax; ++z) {
                    blockpos$Mutable.setPos(position).move(x, y, z);
                    Material material = world.getBlockState(blockpos$Mutable).getMaterial();
                    boolean flag = material.isSolid();

                    if (y == -1 && !flag) {
                        return false;
                    }

                    if (y == 4 && !flag) {
                        ceilingOpenings++;
                    }

                    if ((x == xMin || x == xMax || z == zMin || z == zMax) && y == 0) {

                        blockstate = world.getBlockState(blockpos$Mutable);
                        if ((world.isAirBlock(blockpos$Mutable) || blockstate.getMaterial() == Material.LAVA) && (world.isAirBlock(blockpos$Mutable.up()) || world.getBlockState(blockpos$Mutable.up()).getMaterial() == Material.LAVA)) {
                            ++validOpenings;
                        }
                    }
                }
            }
        }

        if (validOpenings >= 1 && validOpenings <= 14 && ceilingOpenings < 14) {
            for (int x = xMin; x <= xMax; ++x) {
                for (int y = 3; y >= -1; --y) {
                    for (int z = zMin; z <= zMax; ++z) {
                        blockpos$Mutable.setPos(position).move(x, y, z);

                        if (x != xMin && y != -1 && z != zMin && x != xMax && y != 4 && z != zMax) {
                            if (world.getBlockState(blockpos$Mutable).getBlock() != Blocks.CHEST && world.getBlockState(blockpos$Mutable).getBlock() != Blocks.SPAWNER) {
                                world.setBlockState(blockpos$Mutable, CAVE_AIR, 2);
                            }
                        } else if (blockpos$Mutable.getY() >= 0 && !world.getBlockState(blockpos$Mutable.down()).getMaterial().isSolid()) {
                            world.setBlockState(blockpos$Mutable, CAVE_AIR, 2);
                        }

                        // made sure the dungeon wall cannot replace other dungeon's mob spawner now.
                        else if (x != xMin && z != zMin && x != xMax && y != 4 && world.getBlockState(blockpos$Mutable).getMaterial().isSolid() && world.getBlockState(blockpos$Mutable).getBlock() != Blocks.CHEST && world.getBlockState(blockpos$Mutable).getBlock() != Blocks.SPAWNER) {
                            if (y == -1 && random.nextInt(4) != 0) {
                                world.setBlockState(blockpos$Mutable, Blocks.NETHER_BRICK_SLAB.getDefaultState(), 2);
                            } else {
                                world.setBlockState(blockpos$Mutable, Blocks.NETHER_BRICKS.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }

            for (int l3 = random.nextInt(3); l3 < 3; ++l3) {
                for (int j4 = 0; j4 < 3; ++j4) {
                    int x = position.getX() + random.nextInt(randXRange * 2 + 1) - randXRange;
                    int y = position.getY();
                    int z = position.getZ() + random.nextInt(randZRange * 2 + 1) - randZRange;
                    blockpos$Mutable.setPos(x, y, z);

                    if (world.isAirBlock(blockpos$Mutable)) {
                        int j3 = 0;

                        for (Direction Direction : Direction.Plane.HORIZONTAL) {
                            if (world.getBlockState(blockpos$Mutable.offset(Direction)).getMaterial().isSolid()) {
                                ++j3;
                            }
                        }

                        if (j3 == 1) {
                            world.setBlockState(blockpos$Mutable, StructurePiece.func_197528_a(world, blockpos$Mutable, Blocks.CHEST.getDefaultState()), 2);
                            LockableLootTileEntity.setLootTable(world, random, blockpos$Mutable, CHEST_LOOT);
                            world.setBlockState(blockpos$Mutable.down(), Blocks.NETHER_BRICKS.getDefaultState(), 2);

                            break;
                        }
                    }
                }
            }

            world.setBlockState(position, Blocks.AIR.getDefaultState(), 2);
            world.setBlockState(position, Blocks.SPAWNER.getDefaultState(), 2);
            world.setBlockState(position.down(), Blocks.NETHER_BRICKS.getDefaultState(), 2);
            TileEntity tileentity = world.getTileEntity(position);

            if (tileentity instanceof MobSpawnerTileEntity) {
                if(position.getY() < 30)
                    ((MobSpawnerTileEntity) tileentity).getSpawnerBaseLogic()
                            .setEntityType(RepurposedStructures.mobSpawnerManager.getSpawnerMob(LOW_SPAWNER_ID, random));
                else
                    ((MobSpawnerTileEntity) tileentity).getSpawnerBaseLogic()
                            .setEntityType(RepurposedStructures.mobSpawnerManager.getSpawnerMob(HIGH_SPAWNER_ID, random));
            } else {
                LOGGER.error("Failed to fetch mob spawner entity at ({}, {}, {})", new Object[]{position.getX(), position.getY(), position.getZ()});
            }


            // make any fluid tick so they dont float forever
            for (int x = xMin - 1; x <= xMax + 1; ++x) {
                for (int y = 0; y <= 4; ++y) {
                    for (int z = zMin - 1; z <= zMax + 1; ++z) {
                        if (x <= xMin || x >= xMax || z <= zMin || z >= zMax || y == 0 || y == 4) {
                            blockpos$Mutable.setPos(position).move(x, y, z);

                            blockstate = world.getBlockState(blockpos$Mutable);
                            if (!blockstate.getFluidState().isEmpty()) {
                                world.getPendingFluidTicks().scheduleTick(blockpos$Mutable, blockstate.getFluidState().getFluid(), 0);
                            }
                        }
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
