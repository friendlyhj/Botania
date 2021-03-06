/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 */
package vazkii.botania.common.block.tile;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.registries.ObjectHolder;

import vazkii.botania.common.block.subtile.functional.SubTileBubbell;
import vazkii.botania.common.lib.LibBlockNames;
import vazkii.botania.common.lib.LibMisc;

import javax.annotation.Nonnull;

public class TileFakeAir extends TileMod {

	@ObjectHolder(LibMisc.MOD_ID + ":" + LibBlockNames.FAKE_AIR) public static TileEntityType<TileFakeAir> TYPE;
	private static final String TAG_FLOWER_X = "flowerX";
	private static final String TAG_FLOWER_Y = "flowerY";
	private static final String TAG_FLOWER_Z = "flowerZ";

	private BlockPos flowerPos = BlockPos.ZERO;

	public TileFakeAir() {
		super(TYPE);
	}

	public void setFlower(TileEntity tile) {
		flowerPos = tile.getPos();
		markDirty();
	}

	public boolean canStay() {
		return SubTileBubbell.isValidBubbell(world, flowerPos);
	}

	@Nonnull
	@Override
	public CompoundNBT write(CompoundNBT tag) {
		CompoundNBT ret = super.write(tag);
		ret.putInt(TAG_FLOWER_X, flowerPos.getX());
		ret.putInt(TAG_FLOWER_Y, flowerPos.getY());
		ret.putInt(TAG_FLOWER_Z, flowerPos.getZ());
		return ret;
	}

	@Override
	public void read(CompoundNBT tag) {
		super.read(tag);
		flowerPos = new BlockPos(
				tag.getInt(TAG_FLOWER_X),
				tag.getInt(TAG_FLOWER_Y),
				tag.getInt(TAG_FLOWER_Z)
		);
	}

}
