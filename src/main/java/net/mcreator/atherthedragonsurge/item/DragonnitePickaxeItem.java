
package net.mcreator.atherthedragonsurge.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.atherthedragonsurge.AtherTheDragonSurgeModElements;

@AtherTheDragonSurgeModElements.ModElement.Tag
public class DragonnitePickaxeItem extends AtherTheDragonSurgeModElements.ModElement {
	@ObjectHolder("ather_the_dragon_surge:dragonnite_pickaxe")
	public static final Item block = null;
	public DragonnitePickaxeItem(AtherTheDragonSurgeModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1164;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 42;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("dragonnite_pickaxe"));
	}
}
