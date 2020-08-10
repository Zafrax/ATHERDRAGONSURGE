
package net.mcreator.atherthedragonsurge.block;

import net.minecraft.block.material.Material;

@AtherTheDragonSurgeModElements.ModElement.Tag
public class DragonNiteStoneBlock extends AtherTheDragonSurgeModElements.ModElement {

	@ObjectHolder("ather_the_dragon_surge:dragon_nite_stone")
	public static final Block block = null;

	public DragonNiteStoneBlock(AtherTheDragonSurgeModElements instance) {
		super(instance, 31);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(2)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("dragon_nite_stone");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(DragonNiteCobblestoneBlock.block, (int) (1)));
		}

	}

}
