
package net.mcreator.atherthedragonsurge.item;

@AtherTheDragonSurgeModElements.ModElement.Tag
public class DragonniteIngotItem extends AtherTheDragonSurgeModElements.ModElement {

	@ObjectHolder("ather_the_dragon_surge:dragonnite_ingot")
	public static final Item block = null;

	public DragonniteIngotItem(AtherTheDragonSurgeModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MATERIALS).maxStackSize(64));
			setRegistryName("dragonnite_ingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Used to make NetherNite Tools!"));
		}

	}

}
