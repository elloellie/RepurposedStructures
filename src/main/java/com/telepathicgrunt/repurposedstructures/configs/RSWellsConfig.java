package com.telepathicgrunt.repurposedstructures.configs;

import com.telepathicgrunt.repurposedstructures.utils.ConfigHelper;
import com.telepathicgrunt.repurposedstructures.utils.ConfigHelper.ConfigValueListener;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class RSWellsConfig
{

	public static class RSWellsConfigValues
	{
		public ConfigValueListener<Boolean> addWellsToModdedBiomes;
		public ConfigValueListener<Boolean> canHaveBells;
		public ConfigValueListener<Integer> badlandsWellRarityPerChunk;
		public ConfigValueListener<Integer> netherWellRarityPerChunk;
		public ConfigValueListener<Integer> snowWellRarityPerChunk;
		public ConfigValueListener<Integer> mossyStoneWellRarityPerChunk;
		public ConfigValueListener<Integer> forestWellRarityPerChunk;
		public ConfigValueListener<String> blacklistedWellBiomes;

		public RSWellsConfigValues(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber)
		{

			builder.push("Small Wells");
				
				addWellsToModdedBiomes = subscriber.subscribe(builder
						.comment("\r\n Add the custom wells to modded biomes of the same categories/type.")
					.translation("repurposedstructures.config.smallwells.addwellstomoddedbiomes")
					.define("addWellsToModdedBiomes", true));
		
				canHaveBells = subscriber.subscribe(builder
						.comment("\r\n Determines if Wells can have a chance of spawning a Bell.")
					.translation("repurposedstructures.config.smallwells.canhavebells")
					.define("canHaveBells", true));

				blacklistedWellBiomes = subscriber.subscribe(builder
					.comment("\r\n Add the ID/resource location of the biome you don't want"
							+"\r\n RS's wells to spawn in. Separate each ID with a comma ,"
							+"\r\n"
							+"\r\nExample: \"minecraft:ice_spikes,awesome_mod:awesome_biome\"")
					.translation("repurposedstructures.config.smallwells.blacklistedwellbiomes")
					.define("blacklistedWellBiomes", ""));
					
				builder.push("RarityPerChunk");
	
					badlandsWellRarityPerChunk  = subscriber.subscribe(builder
							.comment("\r\n Adds Badlands themed wells to Badlands biomes."
								+ "\r\n This effects how often wells will attempt to spawn per chunk." 
								+ "\r\n The chance of a well generating at a chunk is 1/rarityPerChunk."
								+ "\r\n 1 for wells spawning in every chunk and 10000 for no wells.")
						.translation("repurposedstructures.config.smallwells.badlandswellrarityperchunk")
						.defineInRange("badlandsWellRarityPerChunk", 250, 1, 10000));
					
					netherWellRarityPerChunk = subscriber.subscribe(builder
							.comment("\r\n Adds Nether themed wells to Nether biomes."
								+ "\r\n This effects how often wells will attempt to spawn per chunk." 
								+ "\r\n The chance of a well generating at a chunk is 1/rarityPerChunk."
								+ "\r\n 1 for wells spawning in every chunk and 10000 for no wells.")
						.translation("repurposedstructures.config.smallwells.netherwellrarityperchunk")
						.defineInRange("netherWellRarityPerChunk", 200, 1, 10000));
					
					snowWellRarityPerChunk = subscriber.subscribe(builder
							.comment("\r\n Adds Snow themed wells to snowy and icy biomes."
								+ "\r\n This effects how often wells will attempt to spawn per chunk." 
								+ "\r\n The chance of a well generating at a chunk is 1/rarityPerChunk."
								+ "\r\n 1 for wells spawning in every chunk and 10000 for no wells.")
						.translation("repurposedstructures.config.smallwells.snowwellrarityperchunk")
						.defineInRange("snowWellRarityPerChunk", 350, 1, 10000));
					
					mossyStoneWellRarityPerChunk = subscriber.subscribe(builder
							.comment("\r\n Adds mossy stone themed wells to Jungles, Dark Oak, and Swamp biomes."
								+ "\r\n This effects how often wells will attempt to spawn per chunk." 
								+ "\r\n The chance of a well generating at a chunk is 1/rarityPerChunk."
								+ "\r\n 1 for wells spawning in every chunk and 10000 for no wells.")
						.translation("repurposedstructures.config.smallwells.mossystonewellrarityperchunk")
						.defineInRange("mossyStoneWellRarityPerChunk", 350, 1, 10000));
			
					forestWellRarityPerChunk = subscriber.subscribe(builder
							.comment("\r\n Adds a wood themed wells to Forest and Birch Forest biomes."
								+ "\r\n This effects how often wells will attempt to spawn per chunk." 
								+ "\r\n The chance of a well generating at a chunk is 1/rarityPerChunk."
								+ "\r\n 1 for wells spawning in every chunk and 10000 for no wells.")
						.translation("repurposedstructures.config.smallwells.forestwellrarityperchunk")
						.defineInRange("forestWellRarityPerChunk", 350, 1, 10000));

				builder.pop();
						
			builder.pop();
		}
	}
}
