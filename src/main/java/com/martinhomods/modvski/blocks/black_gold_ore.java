package com.martinhomods.modvski.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class black_gold_ore extends OreBlock {
    public black_gold_ore(Properties p_i48357_1_) {
        super(p_i48357_1_);
    }
    public static int veinSize = 3;
    public static int minHeigth = 1;
    public static int maxHeigth = 69;
    public static int amount = 3;
    @Override
    protected int xpOnDrop(Random random) {
        return MathHelper.nextInt(random, 0, 3);
    }


    @Override
    public void playerDestroy(World p_180657_1_, PlayerEntity p_180657_2_, BlockPos p_180657_3_, BlockState p_180657_4_, @Nullable TileEntity p_180657_5_, ItemStack p_180657_6_) {
        super.playerDestroy(p_180657_1_, p_180657_2_, p_180657_3_, p_180657_4_, p_180657_5_, p_180657_6_);
    }
}
