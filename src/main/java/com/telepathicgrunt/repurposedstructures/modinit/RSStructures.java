package com.telepathicgrunt.repurposedstructures.modinit;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.telepathicgrunt.repurposedstructures.RepurposedStructures;
import com.telepathicgrunt.repurposedstructures.world.structures.*;
import com.telepathicgrunt.repurposedstructures.world.structures.pieces.RSMineshaftPieces;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RSStructures {
    /**
     * --------------------------------------------------------------------------
     * |															        	|
     * |			HELLO READERS! IF YOU'RE HERE, YOU'RE PROBABLY		    	|
     * |			LOOKING FOR A TUTORIAL ON HOW TO DO STRUCTURES	    		|
     * |																        |
     * --------------------------------------------------------------------------
     *
     * Don't worry, I actually have a structure tutorial
     * mod already setup for you to check out! It's full
     * of comments on what does what and how to make structures.
     *
     * Here's the link! https://github.com/TelepathicGrunt/StructureTutorialMod
     *
     * Good luck and have fun modding!
     */

	public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, RepurposedStructures.MODID);
    public static final Map<Structure<?>, StructureSeparationSettings> RS_STRUCTURES = new HashMap<>();
    public static final Set<ResourceLocation> RS_STRUCTURE_START_PIECES = new HashSet<>();

    //Mineshafts
    public static final RegistryObject<Structure<NoFeatureConfig>> BIRCH_MINESHAFT = registerStructure("mineshaft_birch", () -> (new RSMineshaftStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.BIRCH, RepurposedStructures.RSMineshaftsConfig.birchMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.birchMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.birchMineshaftMinHeight.get())));
    public static final RegistryObject<Structure<NoFeatureConfig>> DESERT_MINESHAFT = registerStructure("mineshaft_desert", () -> (new RSMineshaftStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.DESERT, RepurposedStructures.RSMineshaftsConfig.desertMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.desertMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.desertMineshaftMinHeight.get())));
    public static final RegistryObject<Structure<NoFeatureConfig>> END_MINESHAFT = registerStructure("mineshaft_end", () -> (new RSMineshaftEndStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.END, RepurposedStructures.RSMineshaftsConfig.endMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.endMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.endMineshaftMinHeight.get())));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_MINESHAFT = registerStructure("mineshaft_nether", () -> (new RSMineshaftStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.NETHER, RepurposedStructures.RSMineshaftsConfig.netherMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.netherMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.netherMineshaftMinHeight.get())));
    public static final RegistryObject<Structure<NoFeatureConfig>> ICY_MINESHAFT = registerStructure("mineshaft_icy", () -> (new RSMineshaftStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.ICY, RepurposedStructures.RSMineshaftsConfig.icyMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.icyMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.icyMineshaftMinHeight.get())));
    public static final RegistryObject<Structure<NoFeatureConfig>> JUNGLE_MINESHAFT = registerStructure("mineshaft_jungle", () -> (new RSMineshaftStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.JUNGLE, RepurposedStructures.RSMineshaftsConfig.jungleMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.jungleMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.jungleMineshaftMinHeight.get())));
    public static final RegistryObject<Structure<NoFeatureConfig>> OCEAN_MINESHAFT = registerStructure("mineshaft_ocean", () -> (new RSMineshaftStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.OCEAN, RepurposedStructures.RSMineshaftsConfig.oceanMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.oceanMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.oceanMineshaftMinHeight.get())));
    public static final RegistryObject<Structure<NoFeatureConfig>> SAVANNA_MINESHAFT = registerStructure("mineshaft_savanna", () -> (new RSMineshaftStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.SAVANNA, RepurposedStructures.RSMineshaftsConfig.savannaMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.savannaMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.savannaMineshaftMinHeight.get())));
    public static final RegistryObject<Structure<NoFeatureConfig>> STONE_MINESHAFT = registerStructure("mineshaft_stone", () -> (new RSMineshaftStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.STONE, RepurposedStructures.RSMineshaftsConfig.stoneMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.stoneMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.stoneMineshaftMinHeight.get())));
    public static final RegistryObject<Structure<NoFeatureConfig>> SWAMP_OR_DARK_FOREST_MINESHAFT = registerStructure("mineshaft_swamp_or_dark_forest", () -> (new RSMineshaftStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.SWAMPORDARKFOREST, RepurposedStructures.RSMineshaftsConfig.swampAndDarkForestMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.swampAndDarkForestMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.swampAndDarkForestMineshaftMinHeight.get())));
    public static final RegistryObject<Structure<NoFeatureConfig>> TAIGA_MINESHAFT = registerStructure("mineshaft_taiga", () -> (new RSMineshaftStructure(NoFeatureConfig.CODEC, RSMineshaftPieces.Type.TAIGA, RepurposedStructures.RSMineshaftsConfig.taigaMineshaftSpawnrate.get(),RepurposedStructures.RSMineshaftsConfig.taigaMineshaftMaxHeight.get(),RepurposedStructures.RSMineshaftsConfig.taigaMineshaftMinHeight.get())));

    //Strongholds
    public static final RegistryObject<Structure<NoFeatureConfig>> STONEBRICK_STRONGHOLD = registerStructure("stronghold_stonebrick", () -> (new RSStonebrickStrongholdStructure(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_STRONGHOLD = registerStructure("stronghold_nether", () -> (new RSNetherStrongholdStructure(NoFeatureConfig.CODEC)));
    
    //Igloos and Fortress
    public static final RegistryObject<Structure<NoFeatureConfig>> JUNGLE_FORTRESS = registerStructure("fortress_jungle", () -> (new FortressJungleStructure(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> GRASSY_IGLOO = registerStructure("igloo_grassy", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "igloos/grassy_top"), 20, 0, 0, 0, new HashSet<>())));
    public static final RegistryObject<Structure<NoFeatureConfig>> STONE_IGLOO = registerStructure("igloo_stone", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "igloos/stone_top"), 20, 0, 0, 0, new HashSet<>())));

    //Temples
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_WASTELAND_TEMPLE = registerStructure("temple_nether_wasteland", () -> (new TempleNetherStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID,"temples/temple_nether_wasteland"))));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_BASALT_TEMPLE = registerStructure("temple_nether_basalt", () -> (new TempleNetherStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID,"temples/temple_nether_basalt"))));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_WARPED_TEMPLE = registerStructure("temple_nether_warped", () -> (new TempleNetherStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID,"temples/temple_nether_warped"))));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_CRIMSON_TEMPLE = registerStructure("temple_nether_crimson", () -> (new TempleNetherStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID,"temples/temple_nether_crimson"))));
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_SOUL_TEMPLE = registerStructure("temple_nether_soul", () -> (new TempleNetherStructure(NoFeatureConfig.CODEC,new ResourceLocation(RepurposedStructures.MODID,"temples/temple_nether_soul"))));

    //Outposts
    public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_BRICK_OUTPOST = registerStructure("outpost_nether_brick", () -> (new OutpostNetherStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID,"outposts/nether_brick/base_plates"))));
	public static final RegistryObject<Structure<NoFeatureConfig>> WARPED_OUTPOST = registerStructure("outpost_warped", () -> (new OutpostNetherStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID,"outposts/warped/base_plates"))));
	public static final RegistryObject<Structure<NoFeatureConfig>> CRIMSON_OUTPOST = registerStructure("outpost_crimson", () -> (new OutpostNetherStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID,"outposts/crimson/base_plates"))));
    public static final RegistryObject<Structure<NoFeatureConfig>> OUTPOST_BIRCH = registerStructure("outpost_birch", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "outposts/birch/base_plates"), 11, 0, 0, 5, Stream.of(RSStructureTagMap.STRUCTURE_TAGS.OVERWORLD_VILLAGE).collect(Collectors.toSet()))));
    public static final RegistryObject<Structure<NoFeatureConfig>> OUTPOST_JUNGLE = registerStructure("outpost_jungle", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "outposts/jungle/base_plates"), 11, 0, 1, 5, Stream.of(RSStructureTagMap.STRUCTURE_TAGS.OVERWORLD_VILLAGE).collect(Collectors.toSet()))));
    public static final RegistryObject<Structure<NoFeatureConfig>> OUTPOST_GIANT_TREE_TAIGA = registerStructure("outpost_giant_tree_taiga", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "outposts/giant_tree_taiga/base_plates"), 11, 0, 0, 5, Stream.of(RSStructureTagMap.STRUCTURE_TAGS.OVERWORLD_VILLAGE).collect(Collectors.toSet()))));
    public static final RegistryObject<Structure<NoFeatureConfig>> OUTPOST_DESERT = registerStructure("outpost_desert", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "outposts/desert/base_plates"), 11, 0, 1, 5, Stream.of(RSStructureTagMap.STRUCTURE_TAGS.OVERWORLD_VILLAGE).collect(Collectors.toSet()))));
    public static final RegistryObject<Structure<NoFeatureConfig>> OUTPOST_BADLANDS = registerStructure("outpost_badlands", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "outposts/badlands/base_plates"), 11, 0, 0, 5, Stream.of(RSStructureTagMap.STRUCTURE_TAGS.OVERWORLD_VILLAGE).collect(Collectors.toSet()))));
    public static final RegistryObject<Structure<NoFeatureConfig>> OUTPOST_SNOWY = registerStructure("outpost_snowy", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "outposts/snowy/base_plates"), 11, 0, 1, 5, Stream.of(RSStructureTagMap.STRUCTURE_TAGS.OVERWORLD_VILLAGE).collect(Collectors.toSet()))));
    public static final RegistryObject<Structure<NoFeatureConfig>> OUTPOST_ICY = registerStructure("outpost_icy", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "outposts/icy/base_plates"), 11, 0, 0, 5, Stream.of(RSStructureTagMap.STRUCTURE_TAGS.OVERWORLD_VILLAGE).collect(Collectors.toSet()))));

	//Pyramids
	public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_PYRAMID = registerStructure("pyramid_nether", () -> (new PyramidNetherStructure(NoFeatureConfig.CODEC)));
	public static final RegistryObject<Structure<NoFeatureConfig>> BADLANDS_PYRAMID = registerStructure("pyramid_badlands", () -> (new PyramidBadlandsStructure(NoFeatureConfig.CODEC)));
    
	//Shipwrecks
	public static final RegistryObject<Structure<NoFeatureConfig>> END_SHIPWRECK = registerStructure("shipwreck_end", () -> (new ShipwreckEndStructure(NoFeatureConfig.CODEC)));
	public static final RegistryObject<Structure<NoFeatureConfig>> NETHER_BRICKS_SHIPWRECK = registerStructure("shipwreck_nether_bricks", () -> (new ShipwreckNetherStructure(new ResourceLocation(RepurposedStructures.MODID, "shipwrecks/nether_bricks"), false)));
	public static final RegistryObject<Structure<NoFeatureConfig>> CRIMSON_SHIPWRECK = registerStructure("shipwreck_crimson", () -> (new ShipwreckNetherStructure(new ResourceLocation(RepurposedStructures.MODID, "shipwrecks/crimson"), true)));
	public static final RegistryObject<Structure<NoFeatureConfig>> WARPED_SHIPWRECK = registerStructure("shipwreck_warped", () -> (new ShipwreckNetherStructure(new ResourceLocation(RepurposedStructures.MODID, "shipwrecks/warped"), true)));
	
	//Villages
	public static final RegistryObject<Structure<NoFeatureConfig>> BADLANDS_VILLAGE = registerStructure("village_badlands", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "village/badlands/town_centers"), 10, 0, 1, 0, new HashSet<>())));
	public static final RegistryObject<Structure<NoFeatureConfig>> BIRCH_VILLAGE = registerStructure("village_birch", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "village/birch/town_centers"), 6, 0, 1, 0, new HashSet<>())));
	public static final RegistryObject<Structure<NoFeatureConfig>> DARK_FOREST_VILLAGE = registerStructure("village_dark_oak", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "village/dark_forest/town_centers"), 6, 0, 1, 0, new HashSet<>())));
	public static final RegistryObject<Structure<NoFeatureConfig>> JUNGLE_VILLAGE = registerStructure("village_jungle", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "village/jungle/town_centers"), 8, 0, 1, 0, new HashSet<>())));
	public static final RegistryObject<Structure<NoFeatureConfig>> SWAMP_VILLAGE = registerStructure("village_swamp", () -> (new RuinedPortalEndStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "village/swamp/town_centers"), 6, -1, 1, 0, new HashSet<>())));
	public static final RegistryObject<Structure<NoFeatureConfig>> MOUNTAINS_VILLAGE = registerStructure("village_mountains", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "village/mountains/town_centers"), 6, 0, 1, 0, new HashSet<>())));
	public static final RegistryObject<Structure<NoFeatureConfig>> GIANT_TAIGA_VILLAGE = registerStructure("village_giant_taiga", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "village/giant_taiga/town_centers"), 6, 1, 0, 0, new HashSet<>())));
  	public static final RegistryObject<Structure<NoFeatureConfig>> CRIMSON_VILLAGE = registerStructure("village_crimson", () -> (new VillageNetherStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "village/crimson/town_centers"), 6, 0, 1, 0, new HashSet<>())));
  	public static final RegistryObject<Structure<NoFeatureConfig>> WARPED_VILLAGE = registerStructure("village_warped", () -> (new VillageNetherStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "village/warped/town_centers"), 6, 0, 1, 0, new HashSet<>())));
    public static final RegistryObject<Structure<NoFeatureConfig>> VILLAGE_OAK = registerStructure("village_oak", () -> (new GenericJigsawStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "village/oak/town_centers"), 6, 0, 1, 0, new HashSet<>())));

  	//Ruined Portals
    public static final RegistryObject<Structure<NoFeatureConfig>> RUINED_PORTAL_END = registerStructure("ruined_portal_end", () -> (new RuinedPortalEndStructure(NoFeatureConfig.CODEC, new ResourceLocation(RepurposedStructures.MODID, "ruined_portal/end"), 20, -6, 0, 0, new HashSet<>())));

    private static <T extends Structure<?>> RegistryObject<T> registerStructure(String name, Supplier<T> structure)
    {   
        return STRUCTURE_FEATURES.register(name, structure);
    }
    
	public static void registerStructures()
	{
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_birch"), BIRCH_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 399117345));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_desert"), DESERT_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 1990612785));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_end"), END_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 2057488602));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_nether"), NETHER_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 1220811654));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_icy"), ICY_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 1451015246));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_jungle"), JUNGLE_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 1434412876));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_ocean"), OCEAN_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 1774808662));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_savanna"), SAVANNA_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 1960212212));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_stone"), STONE_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 1436736620));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_swamp_or_dark_forest"), SWAMP_OR_DARK_FOREST_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 2037177700));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "mineshaft_taiga"), TAIGA_MINESHAFT.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(1, 0, 1383003172));

        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "stronghold_stonebrick"), STONEBRICK_STRONGHOLD.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSStrongholdsConfig.stonebrickStrongholdMaxChunkDistance.get(), (int) (RepurposedStructures.RSStrongholdsConfig.stonebrickStrongholdMaxChunkDistance.get() * 0.5f), 1098192663));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "stronghold_nether"), NETHER_STRONGHOLD.get(), GenerationStage.Decoration.UNDERGROUND_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSStrongholdsConfig.netherStrongholdMaxChunkDistance.get(), (int) (RepurposedStructures.RSStrongholdsConfig.netherStrongholdMaxChunkDistance.get() * 0.5f), 1731422513));

        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "fortress_jungle"), JUNGLE_FORTRESS.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSMainConfig.jungleFortressMaxChunkDistance.get(), (int) (RepurposedStructures.RSMainConfig.jungleFortressMaxChunkDistance.get() * 0.5f), 1464189157));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "igloo_grassy"), GRASSY_IGLOO.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSMainConfig.grassyIglooMaxChunkDistance.get(), (int) (RepurposedStructures.RSMainConfig.grassyIglooMaxChunkDistance.get() * 0.5f), 1460835582));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "igloo_stone"), STONE_IGLOO.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSMainConfig.stoneIglooMaxChunkDistance.get(), (int) (RepurposedStructures.RSMainConfig.stoneIglooMaxChunkDistance.get() * 0.5f), 1327429039));

        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "temple_nether_wasteland"), NETHER_WASTELAND_TEMPLE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSTemplesConfig.netherWastelandTempleMaxChunkDistance.get(), (int) (RepurposedStructures.RSTemplesConfig.netherWastelandTempleMaxChunkDistance.get() * 0.5f), 1435489909));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "temple_nether_soul"), NETHER_SOUL_TEMPLE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSTemplesConfig.netherSoulTempleMaxChunkDistance.get(), (int) (RepurposedStructures.RSTemplesConfig.netherSoulTempleMaxChunkDistance.get() * 0.5f), 1799485937));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "temple_nether_basalt"), NETHER_BASALT_TEMPLE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSTemplesConfig.netherBasaltTempleMaxChunkDistance.get(), (int) (RepurposedStructures.RSTemplesConfig.netherBasaltTempleMaxChunkDistance.get() * 0.5f), 1063117750));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "temple_nether_crimson"), NETHER_CRIMSON_TEMPLE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSTemplesConfig.netherCrimsonTempleMaxChunkDistance.get(), (int) (RepurposedStructures.RSTemplesConfig.netherCrimsonTempleMaxChunkDistance.get() * 0.5f), 1898896156));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "temple_nether_warped"), NETHER_WARPED_TEMPLE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSTemplesConfig.netherWarpedTempleMaxChunkDistance.get(), (int) (RepurposedStructures.RSTemplesConfig.netherWarpedTempleMaxChunkDistance.get() * 0.5f), 1635542708));

        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "outpost_nether_brick"), NETHER_BRICK_OUTPOST.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSOutpostsConfig.netherBrickOutpostMaxChunkDistance.get(), (int) (RepurposedStructures.RSOutpostsConfig.netherBrickOutpostMaxChunkDistance.get() * 0.5f), 1305971394));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "outpost_warped"), WARPED_OUTPOST.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSOutpostsConfig.warpedOutpostMaxChunkDistance.get(), (int) (RepurposedStructures.RSOutpostsConfig.warpedOutpostMaxChunkDistance.get() * 0.5f), 1928816918));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "outpost_crimson"), CRIMSON_OUTPOST.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSOutpostsConfig.crimsonOutpostMaxChunkDistance.get(), (int) (RepurposedStructures.RSOutpostsConfig.crimsonOutpostMaxChunkDistance.get() * 0.5f), 1951425662));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "outpost_birch"), OUTPOST_BIRCH.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSOutpostsConfig.outpostBirchMaxChunkDistance.get(), (int) (RepurposedStructures.RSOutpostsConfig.outpostBirchMaxChunkDistance.get() * 0.5f), 1676743168));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "outpost_jungle"), OUTPOST_JUNGLE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSOutpostsConfig.outpostJungleMaxChunkDistance.get(), (int) (RepurposedStructures.RSOutpostsConfig.outpostJungleMaxChunkDistance.get() * 0.5f), 548433028));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "outpost_giant_tree_taiga"), OUTPOST_GIANT_TREE_TAIGA.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSOutpostsConfig.outpostGiantTreeTaigaMaxChunkDistance.get(), (int) (RepurposedStructures.RSOutpostsConfig.outpostGiantTreeTaigaMaxChunkDistance.get() * 0.5f), 993252541));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "outpost_desert"), OUTPOST_DESERT.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSOutpostsConfig.outpostDesertMaxChunkDistance.get(), (int) (RepurposedStructures.RSOutpostsConfig.outpostDesertMaxChunkDistance.get() * 0.5f), 593099376));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "outpost_badlands"), OUTPOST_BADLANDS.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSOutpostsConfig.outpostBadlandsMaxChunkDistance.get(), (int) (RepurposedStructures.RSOutpostsConfig.outpostBadlandsMaxChunkDistance.get() * 0.5f), 1702026868));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "outpost_snowy"), OUTPOST_SNOWY.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSOutpostsConfig.outpostSnowyMaxChunkDistance.get(), (int) (RepurposedStructures.RSOutpostsConfig.outpostSnowyMaxChunkDistance.get() * 0.5f), 849388460));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "outpost_icy"), OUTPOST_ICY.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSOutpostsConfig.outpostIcyMaxChunkDistance.get(), (int) (RepurposedStructures.RSOutpostsConfig.outpostIcyMaxChunkDistance.get() * 0.5f), 935294633));

        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "pyramid_badlands"), BADLANDS_PYRAMID.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSTemplesConfig.badlandsPyramidMaxChunkDistance.get(), (int) (RepurposedStructures.RSTemplesConfig.badlandsPyramidMaxChunkDistance.get() * 0.5f), 1718729448));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "pyramid_nether"), NETHER_PYRAMID.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSTemplesConfig.netherPyramidMaxChunkDistance.get(), (int) (RepurposedStructures.RSTemplesConfig.netherPyramidMaxChunkDistance.get() * 0.5f), 2054372964));

        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "shipwreck_end"), END_SHIPWRECK.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSShipwrecksConfig.endShipwreckMaxChunkDistance.get(), (int) (RepurposedStructures.RSShipwrecksConfig.endShipwreckMaxChunkDistance.get() * 0.5f), 1605500075));
        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "shipwreck_nether_bricks"), NETHER_BRICKS_SHIPWRECK.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSShipwrecksConfig.netherBricksShipwreckMaxChunkDistance.get(), (int) (RepurposedStructures.RSShipwrecksConfig.netherBricksShipwreckMaxChunkDistance.get() * 0.5f), 2073308006));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "shipwreck_crimson"), CRIMSON_SHIPWRECK.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSShipwrecksConfig.crimsonShipwreckMaxChunkDistance.get(), (int) (RepurposedStructures.RSShipwrecksConfig.crimsonShipwreckMaxChunkDistance.get() * 0.5f), 1019716871));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "shipwreck_warped"), WARPED_SHIPWRECK.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSShipwrecksConfig.warpedShipwreckMaxChunkDistance.get(), (int) (RepurposedStructures.RSShipwrecksConfig.warpedShipwreckMaxChunkDistance.get() * 0.5f), 2072979641));

        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "village_badlands"), BADLANDS_VILLAGE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSVillagesConfig.badlandsVillageMaxChunkDistance.get(), (int) (RepurposedStructures.RSVillagesConfig.badlandsVillageMaxChunkDistance.get() * 0.5f), 1319707555));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "village_birch"), BIRCH_VILLAGE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSVillagesConfig.birchVillageMaxChunkDistance.get(), (int) (RepurposedStructures.RSVillagesConfig.birchVillageMaxChunkDistance.get() * 0.5f), 1102567365));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "village_dark_oak"), DARK_FOREST_VILLAGE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSVillagesConfig.darkForestVillageMaxChunkDistance.get(), (int) (RepurposedStructures.RSVillagesConfig.darkForestVillageMaxChunkDistance.get() * 0.5f), 1921339358));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "village_jungle"), JUNGLE_VILLAGE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSVillagesConfig.jungleVillageMaxChunkDistance.get(), (int) (RepurposedStructures.RSVillagesConfig.jungleVillageMaxChunkDistance.get() * 0.5f), 1229975218));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "village_swamp"), SWAMP_VILLAGE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSVillagesConfig.swampVillageMaxChunkDistance.get(), (int) (RepurposedStructures.RSVillagesConfig.swampVillageMaxChunkDistance.get() * 0.5f), 1559650945));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "village_mountains"), MOUNTAINS_VILLAGE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSVillagesConfig.mountainsVillageMaxChunkDistance.get(), (int) (RepurposedStructures.RSVillagesConfig.mountainsVillageMaxChunkDistance.get() * 0.5f), 2010875989));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "village_giant_taiga"), GIANT_TAIGA_VILLAGE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSVillagesConfig.giantTaigaVillageMaxChunkDistance.get(), (int) (RepurposedStructures.RSVillagesConfig.giantTaigaVillageMaxChunkDistance.get() * 0.5f), 1559528842));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "village_crimson"), CRIMSON_VILLAGE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSVillagesConfig.crimsonVillageMaxChunkDistance.get(), (int) (RepurposedStructures.RSVillagesConfig.crimsonVillageMaxChunkDistance.get() * 0.5f), 1854750198));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "village_warped"), WARPED_VILLAGE.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSVillagesConfig.warpedVillageMaxChunkDistance.get(), (int) (RepurposedStructures.RSVillagesConfig.warpedVillageMaxChunkDistance.get() * 0.5f), 1298332136));
        registerLandscapeTransformingStructure(new ResourceLocation(RepurposedStructures.MODID, "village_oak"), VILLAGE_OAK.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSVillagesConfig.villageOakMaxChunkDistance.get(), (int) (RepurposedStructures.RSVillagesConfig.villageOakMaxChunkDistance.get() * 0.5f), 2112891039));

        registerStructure(new ResourceLocation(RepurposedStructures.MODID, "ruined_portal_end"), RUINED_PORTAL_END.get(), GenerationStage.Decoration.SURFACE_STRUCTURES, new StructureSeparationSettings(RepurposedStructures.RSMainConfig.ruinedPortalEndMaxChunkDistance.get(), (int) (RepurposedStructures.RSMainConfig.ruinedPortalEndMaxChunkDistance.get() * 0.5f), 532404086));

        //Next available seed: https://www.google.com/search?q=random+number

        //registers the structure pieces.
        RSStructurePieces.registerStructurePieces();
    }
    
	public static <F extends Structure<NoFeatureConfig>> void registerLandscapeTransformingStructure(ResourceLocation resourceLocation, F structure, GenerationStage.Decoration stage, StructureSeparationSettings StructureSeparationSettings)
    {
        Structure.JIGSAW_STRUCTURES = ImmutableList.<Structure<?>>builder().addAll(Structure.JIGSAW_STRUCTURES).add(structure).build();
        registerStructure(resourceLocation, structure, stage, StructureSeparationSettings);
    }

	public static <F extends Structure<NoFeatureConfig>> void registerStructure(ResourceLocation resourceLocation, F structure, GenerationStage.Decoration stage, StructureSeparationSettings structureSeparationSettings)
	{
		Structure.STRUCTURES.put(resourceLocation.toString().toLowerCase(Locale.ROOT), structure);

		// This is only for myself. Others should override func_236396_f_() in
        // their structure's class to return their generation stage instead.
		Structure.STRUCTURE_TO_GENERATION_STEP.put(structure, stage);

		DimensionStructuresSettings.DEFAULT_STRUCTURES = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder().putAll(DimensionStructuresSettings.DEFAULT_STRUCTURES).put(structure, structureSeparationSettings).build();
		FlatGenerationSettings.STRUCTURES.put(structure, structure.configure(IFeatureConfig.NO_FEATURE_CONFIG));
		RS_STRUCTURES.put(structure, structureSeparationSettings);
	}
}
