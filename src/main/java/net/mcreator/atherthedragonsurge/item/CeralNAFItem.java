
package net.mcreator.atherthedragonsurge.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.atherthedragonsurge.itemgroup.AtherTheDragonSurgeItemGroup;
import net.mcreator.atherthedragonsurge.AtherTheDragonSurgeModElements;

import java.util.List;

@AtherTheDragonSurgeModElements.ModElement.Tag
public class CeralNAFItem extends AtherTheDragonSurgeModElements.ModElement {
	@ObjectHolder("ather_the_dragon_surge:ceral_naf")
	public static final Item block = null;
	public CeralNAFItem(AtherTheDragonSurgeModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AtherTheDragonSurgeItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(-186).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("ceral_naf");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 1;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("(not Asbestos)"));
		}
	}
}
