
package net.mcreator.atherthedragonsurge.block;

import net.minecraft.block.material.Material;

@AtherTheDragonSurgeModElements.ModElement.Tag
public class Block1Block extends AtherTheDragonSurgeModElements.ModElement {

	@ObjectHolder("ather_the_dragon_surge:block_1")
	public static final Block block = null;

	public Block1Block(AtherTheDragonSurgeModElements instance) {
		super(instance, 10);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).lightValue(0));

			setRegistryName("block_1");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
