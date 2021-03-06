/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 *
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 *
 * File Created @ [20/03/2016, 19:58:13 (GMT)]
 */
package vazkii.quark.building.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IStringSerializable;
import vazkii.arl.block.BlockMetaVariants;
import vazkii.quark.base.block.IQuarkBlock;
import vazkii.quark.base.module.Feature;
import vazkii.quark.base.module.ModuleLoader;
import vazkii.quark.building.feature.WorldStoneBricks;
import vazkii.quark.world.feature.Basalt;
import vazkii.quark.world.feature.RevampStoneGen;

import java.util.Locale;
import java.util.function.Supplier;

public class BlockWorldStoneBricks extends BlockMetaVariants<BlockWorldStoneBricks.Variants> implements IQuarkBlock {

	public BlockWorldStoneBricks() {
		super("world_stone_bricks", Material.ROCK, Variants.class);
		setHardness(1.5F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@Override
	public boolean shouldDisplayVariant(int variant) {
		return Variants.class.getEnumConstants()[variant].isEnabled();
	}

	public enum Variants implements IStringSerializable {
		
		STONE_GRANITE_BRICKS(WorldStoneBricks.class),
		STONE_DIORITE_BRICKS(WorldStoneBricks.class),
		STONE_ANDESITE_BRICKS(WorldStoneBricks.class),
		STONE_BASALT_BRICKS(Basalt.class),
		STONE_MARBLE_BRICKS(RevampStoneGen.class, () -> RevampStoneGen.enableMarble),
		STONE_LIMESTONE_BRICKS(RevampStoneGen.class, () -> RevampStoneGen.enableLimestone);
		
		Variants(Class<? extends Feature> clazz) {
			this(clazz, () -> true);
		}
		
		Variants(Class<? extends Feature> clazz, Supplier<Boolean> enabledCond) {
			featureLink = clazz;
			this.enabledCond = enabledCond;
		}
		
		public final Class<? extends Feature> featureLink;
		private final Supplier<Boolean> enabledCond;
		
		public boolean isEnabled() {
			return ModuleLoader.isFeatureEnabled(featureLink) && enabledCond.get();
		}

		@Override
		public String getName() {
			return name().toLowerCase(Locale.ROOT);
		}
		
	}

}
