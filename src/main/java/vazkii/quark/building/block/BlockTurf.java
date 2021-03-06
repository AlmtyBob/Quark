package vazkii.quark.building.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import vazkii.arl.block.BlockMod;
import vazkii.quark.building.feature.Turf.ITurfBlock;

public class BlockTurf extends BlockMod implements ITurfBlock {
	
	public BlockTurf() {
		super("turf", Material.GRASS);
		setHardness(0.6F);
		setSoundType(SoundType.PLANT);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

}
