
package net.mcreator.atherthedragonsurge.block;

import net.minecraft.block.material.Material;

@AtherTheDragonSurgeModElements.ModElement.Tag
public class DragonniteOreBlockBlock extends AtherTheDragonSurgeModElements.ModElement {

	@ObjectHolder("ather_the_dragon_surge:dragonnite_ore_block")
	public static final Block block = null;

	public DragonniteOreBlockBlock(AtherTheDragonSurgeModElements instance) {
		super(instance, 12);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.IRON).sound(SoundType.GLASS).hardnessAndResistance(5f, 10f).lightValue(0).harvestLevel(6)
							.harvestTool(ToolType.PICKAXE).notSolid());

			setRegistryName("dragonnite_ore_block");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public boolean isReplaceable(BlockState state, BlockItemUseContext context) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(DragonniteIngotItem.block, (int) (1)));
		}

	}

}
