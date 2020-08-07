
package net.mcreator.atherthedragonsurge.block;

import net.minecraft.block.material.Material;

@AtherTheDragonSurgeModElements.ModElement.Tag
public class DragonniteOreBlock extends AtherTheDragonSurgeModElements.ModElement {

	@ObjectHolder("ather_the_dragon_surge:dragonnite_ore")
	public static final Block block = null;

	public DragonniteOreBlock(AtherTheDragonSurgeModElements instance) {
		super(instance, 11);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(AtherTheDragonSurgeItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(9f, 12.041123426403463f).lightValue(0)
							.harvestLevel(6).harvestTool(ToolType.PICKAXE));

			setRegistryName("dragonnite_ore");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(DragonniteIngotItem.block, (int) (1)));
		}

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {

			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, new OreFeature(OreFeatureConfig::deserialize) {
				@Override
				public boolean place(IWorld world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
					DimensionType dimensionType = world.getDimension().getType();
					boolean dimensionCriteria = false;

					if (dimensionType == DimensionType.OVERWORLD)
						dimensionCriteria = true;

					if (!dimensionCriteria)
						return false;

					return super.place(world, generator, rand, pos, config);
				}
			}.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("dragonnite_ore", "dragonnite_ore", blockAt -> {
				boolean blockCriteria = false;
				if (blockAt.getBlock() == Blocks.STONE.getDefaultState().getBlock())
					blockCriteria = true;
				return blockCriteria;
			}), block.getDefaultState(), 2)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 1, 1, 23))));
		}
	}

}
