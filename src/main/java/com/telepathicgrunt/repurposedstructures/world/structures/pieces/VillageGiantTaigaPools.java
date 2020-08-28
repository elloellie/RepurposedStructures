package com.telepathicgrunt.repurposedstructures.world.structures.pieces;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mojang.datafixers.util.Pair;
import com.telepathicgrunt.repurposedstructures.RepurposedStructures;
import com.telepathicgrunt.repurposedstructures.mixin.StructureProcessorListAccessor;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.template.*;


public class VillageGiantTaigaPools
{
    public static void init() {
		StructureProcessorList mossify = StructureProcessorListAccessor.invokeRegister(RepurposedStructures.MODID+":village/giant_taiga/mossify",
			ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.4F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.STONE.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.05F), AlwaysTrueRuleTest.INSTANCE, Blocks.COAL_ORE.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.02F), AlwaysTrueRuleTest.INSTANCE, Blocks.IRON_ORE.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STONE, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBBLESTONE.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STONE, 0.05F), AlwaysTrueRuleTest.INSTANCE, Blocks.COAL_ORE.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STONE, 0.02F), AlwaysTrueRuleTest.INSTANCE, Blocks.IRON_ORE.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STONE_BRICKS, 0.4F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STONE_BRICKS, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.CRACKED_STONE_BRICKS.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STONE_PRESSURE_PLATE, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.STONE_BUTTON.getDefaultState().with(StoneButtonBlock.FACE, AttachFace.FLOOR)),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STONE_PRESSURE_PLATE, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBBLESTONE_SLAB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STONE_PRESSURE_PLATE, 0.75F), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState())))));

		StructureProcessorList path_randomizer = StructureProcessorListAccessor.invokeRegister(RepurposedStructures.MODID+":village/giant_taiga/path_randomizer",
			ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(
            		new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_PATH, 0.1F), new BlockMatchRuleTest(Blocks.WATER), Blocks.MOSSY_COBBLESTONE.getDefaultState()),
            		new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_PATH), new BlockMatchRuleTest(Blocks.WATER), Blocks.STONE_BRICKS.getDefaultState()),
            		new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_PATH, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.STONE.getDefaultState()),
            		new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_PATH, 0.4f), AlwaysTrueRuleTest.INSTANCE, Blocks.COBBLESTONE.getDefaultState()),
            		new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_PATH, 0.8f), AlwaysTrueRuleTest.INSTANCE, Blocks.PODZOL.getDefaultState()),
            		new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_PATH), AlwaysTrueRuleTest.INSTANCE, Blocks.GRASS_BLOCK.getDefaultState()),
            		new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_BLOCK), new BlockMatchRuleTest(Blocks.WATER), Blocks.WATER.getDefaultState()),
            		new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_BLOCK, 0.5f), AlwaysTrueRuleTest.INSTANCE, Blocks.PODZOL.getDefaultState()),
            		new RuleEntry(new RandomBlockMatchRuleTest(Blocks.DIRT, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBBLESTONE.getDefaultState()),
            		new RuleEntry(new RandomBlockMatchRuleTest(Blocks.DIRT, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.STONE.getDefaultState()),
            		new RuleEntry(new BlockMatchRuleTest(Blocks.DIRT), new BlockMatchRuleTest(Blocks.WATER), Blocks.WATER.getDefaultState()),
            		new RuleEntry(new BlockMatchRuleTest(Blocks.DIRT), AlwaysTrueRuleTest.INSTANCE, Blocks.PODZOL.getDefaultState()),
				new RuleEntry(new BlockMatchRuleTest(Blocks.DIRT), AlwaysTrueRuleTest.INSTANCE, Blocks.GRASS_BLOCK.getDefaultState())))));

		StructureProcessorList zombiefy = StructureProcessorListAccessor.invokeRegister(RepurposedStructures.MODID+":village/giant_taiga/zombiefy",
			ImmutableList.copyOf(Iterables.concat(mossify.getList(), ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.8F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()),
			new RuleEntry(new TagMatchRuleTest(BlockTags.DOORS), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()),
			new RuleEntry(new BlockMatchRuleTest(Blocks.TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()),
			new RuleEntry(new BlockMatchRuleTest(Blocks.WALL_TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.MOSSY_COBBLESTONE, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STONE_BRICKS, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.MOSSY_STONE_BRICKS, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.CRACKED_STONE_BRICKS, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHITE_TERRACOTTA, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.SPRUCE_LOG, 0.05F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.SPRUCE_PLANKS, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.SPRUCE_STAIRS, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STRIPPED_SPRUCE_LOG, 0.02F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GLASS_PANE, 0.5F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()),
			new RuleEntry(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.NORTH, true).with(PaneBlock.SOUTH, true)), AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.NORTH, true).with(PaneBlock.SOUTH, true)),
			new RuleEntry(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.EAST, true).with(PaneBlock.WEST, true)), AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.EAST, true).with(PaneBlock.WEST, true)),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.3F), AlwaysTrueRuleTest.INSTANCE, Blocks.CARROTS.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.POTATOES.getDefaultState()),
			new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.BEETROOTS.getDefaultState())))))));


		StructureProcessorList path_randomizer_and_mossify = StructureProcessorListAccessor.invokeRegister(RepurposedStructures.MODID+":village/giant_taiga/path_randomizer_and_mossify",
				ImmutableList.copyOf(Iterables.concat(mossify.getList(), path_randomizer.getList())));

		StructureProcessorList crop_randomizer = StructureProcessorListAccessor.invokeRegister(RepurposedStructures.MODID+":village/giant_taiga/crop_randomizer",
				ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(
            		new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.CARROTS.getDefaultState()),
            		new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.6F), AlwaysTrueRuleTest.INSTANCE, Blocks.SWEET_BERRY_BUSH.getDefaultState())))));

	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/town_centers"), new ResourceLocation("empty"),
		       ImmutableList.of(new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/town_centers/meeting_point_1", path_randomizer_and_mossify), 50),
	        		       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/town_centers/meeting_point_2", path_randomizer_and_mossify), 50),
	        		       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/town_centers/meeting_point_3", path_randomizer_and_mossify), 50),
	        		       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/town_centers/meeting_point_1", path_randomizer_and_mossify), 1),
	        		       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/town_centers/meeting_point_2", path_randomizer_and_mossify), 1),
	        		       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/town_centers/meeting_point_3", path_randomizer_and_mossify), 1)),
		       JigsawPattern.PlacementBehaviour.RIGID));
	       
	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/streets"), new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/terminators"),
		       ImmutableList.of(
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/corner_01", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/corner_02", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/corner_03", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/straight_01", path_randomizer), 4),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/straight_02", path_randomizer), 4),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/straight_03", path_randomizer), 7),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/straight_04", path_randomizer), 7),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/straight_06", path_randomizer), 3),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/straight_08", path_randomizer), 4),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/crossroad_01", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/crossroad_02", path_randomizer), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/crossroad_03", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/crossroad_04", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/crossroad_05", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/crossroad_06", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/square_01", path_randomizer), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/turn_01", path_randomizer), 3)),
		       JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
	       
	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets"), new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/terminators"),
		       ImmutableList.of(
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/corner_01", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/corner_02", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/corner_03", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/straight_01", path_randomizer), 4),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/straight_02", path_randomizer), 4),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/straight_03", path_randomizer), 7),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/straight_04", path_randomizer), 7),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/straight_06", path_randomizer), 3),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/straight_08", path_randomizer), 4),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/crossroad_01", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/crossroad_02", path_randomizer), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/crossroad_03", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/crossroad_04", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/crossroad_05", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/crossroad_06", path_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/streets/square_01", path_randomizer), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/streets/turn_01", path_randomizer), 3)),
		       JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
	       
	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/houses"), new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/terminators"),
		       ImmutableList.of(
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/animal_pen_1", mossify), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/animal_pen_2", mossify), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/armorer_house_1", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/armorer_house_2", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/butcher_shop_1", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/butcher_shop_2", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/cartographer_house_1", mossify), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/farm_1", crop_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/farm_2", crop_randomizer), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/fisher_cottage", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/fletcher_house_1", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/library_1", mossify), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/masons_house_1", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/masons_house_2", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/medium_house_1", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/medium_house_2", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/medium_house_3", mossify), 2),
			       new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/houses/shepherds_house_1"), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/small_house_1", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/small_house_2", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/small_house_3", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/small_house_4", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/small_house_5", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/small_house_6", mossify), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/small_house_7", mossify), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/small_house_8", mossify), 3),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/tannery_1", mossify), 4),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/temple_1", mossify), 5),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/tool_smith_1", mossify), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/weapon_smith_1", mossify), 1),
			       Pair.of(JigsawPiece.method_30438(), 10)),
		       JigsawPattern.PlacementBehaviour.RIGID));
	       
	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses"), new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/terminators"),
		       ImmutableList.of(
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/small_house_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/small_house_2", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/small_house_3", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/small_house_4", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/small_house_5", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/small_house_6", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/small_house_7", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/small_house_8", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/medium_house_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/medium_house_2", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/zombie/houses/medium_house_3", zombiefy), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/butchers_shop_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/butchers_shop_2", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/tool_smith_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/fletcher_house_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/shepherds_house_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/armorer_house_1", zombiefy), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/armorer_house_2", zombiefy), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/fisher_cottage", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/tannery_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/cartographer_house_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/library_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/masons_house_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/masons_house_2", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/weapon_smith_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/temple_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/farm_1", zombiefy), 3),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/farm_2", zombiefy), 3),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/animal_pen_1", zombiefy), 2),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/houses/animal_pen_2", zombiefy), 2),
			       Pair.of(JigsawPiece.method_30438(), 6)), JigsawPattern.PlacementBehaviour.RIGID));
	       
	      
	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/terminators"), new ResourceLocation("empty"),
		       ImmutableList.of(
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/plains/terminators/terminator_01", path_randomizer), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/plains/terminators/terminator_02", path_randomizer), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/plains/terminators/terminator_03", path_randomizer), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/plains/terminators/terminator_04", path_randomizer), 1)),
		       JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));

	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/zombie/terminators"), new ResourceLocation("empty"),
		       ImmutableList.of(
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/plains/zombie/terminators/terminator_01", path_randomizer), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/plains/zombie/terminators/terminator_02", path_randomizer), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/plains/zombie/terminators/terminator_03", path_randomizer), 1),
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/plains/zombie/terminators/terminator_04", path_randomizer), 1)),
		       JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
	       
	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/trees"), new ResourceLocation("empty"),
		       ImmutableList.of(
			       new Pair<>(JigsawPiece.method_30421(Features.MEGA_PINE), 1)),
		       JigsawPattern.PlacementBehaviour.RIGID));

			BlockStateProvidingFeatureConfig COBBLESTONE_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(Blocks.COBBLESTONE.getDefaultState()));

			JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/decor"), new ResourceLocation("empty"),
		       ImmutableList.of(new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/decor/lamp_post_01"), 1),
			       new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/decor/lamp_post_02"), 1),
			       new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/decor/lamp_post_03"), 1),
			       new Pair<>(JigsawPiece.method_30421(Features.MEGA_PINE), 1),
			       new Pair<>(JigsawPiece.method_30421(Features.PATCH_LARGE_FERN), 1),
			       new Pair<>(JigsawPiece.method_30421(Features.PATCH_GRASS_TAIGA), 1),
			       new Pair<>(JigsawPiece.method_30421(Feature.BLOCK_PILE.configure(COBBLESTONE_PILE_CONFIG)), 1),
			       Pair.of(JigsawPiece.method_30438(), 2)),
		       JigsawPattern.PlacementBehaviour.RIGID));
	      
	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/zombie/decor"), new ResourceLocation("empty"),
		       ImmutableList.of(
			       new Pair<>(JigsawPiece.method_30426(RepurposedStructures.MODID+":village/giant_taiga/decor/lamp_post_01", zombiefy), 1),
			       new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/decor/lamp_post_02"), 1),
			       new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/decor/lamp_post_03"), 1),
					   new Pair<>(JigsawPiece.method_30421(Features.MEGA_PINE), 2),
					   new Pair<>(JigsawPiece.method_30421(Features.PATCH_LARGE_FERN), 1),
					   new Pair<>(JigsawPiece.method_30421(Features.PATCH_GRASS_TAIGA), 1),
			       new Pair<>(JigsawPiece.method_30421(Feature.BLOCK_PILE.configure(COBBLESTONE_PILE_CONFIG)), 2),
			       Pair.of(JigsawPiece.method_30438(), 2)),
		       JigsawPattern.PlacementBehaviour.RIGID));
	      
	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/villagers"), new ResourceLocation("empty"),
		       ImmutableList.of(
			       new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/villagers/nitwit"), 1),
			       new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/villagers/baby"), 1),
			       new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/villagers/unemployed"), 10)),
		       JigsawPattern.PlacementBehaviour.RIGID));
	      
	       JigsawPatternRegistry.register(new JigsawPattern(new ResourceLocation(RepurposedStructures.MODID+":village/giant_taiga/zombie/villagers"), new ResourceLocation("empty"),
		       ImmutableList.of(
			       new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/zombie/villagers/nitwit"), 1),
			       new Pair<>(JigsawPiece.method_30425(RepurposedStructures.MODID+":village/giant_taiga/zombie/villagers/unemployed"), 10)),
		       JigsawPattern.PlacementBehaviour.RIGID));
    }
}