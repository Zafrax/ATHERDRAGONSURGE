
package net.mcreator.atherthedragonsurge.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.atherthedragonsurge.block.TestBlock1Block;
import net.mcreator.atherthedragonsurge.AtherTheDragonSurgeModElements;

@AtherTheDragonSurgeModElements.ModElement.Tag
public class AtherTheDragonSurgeItemGroup extends AtherTheDragonSurgeModElements.ModElement {
	public AtherTheDragonSurgeItemGroup(AtherTheDragonSurgeModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabather_the_dragon_surge") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TestBlock1Block.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
