package com.martinhomods.modvski.blocks;

import com.martinhomods.modvski.console;
import com.martinhomods.modvski.init.SoundInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.Random;


public class wuantanio_ore extends OreBlock {
    public wuantanio_ore(Properties props) {
        super(props);

    }
    public static int veinSize = 3;
    public static int minHeigth = 1;
    public static int maxHeigth = 69;
    public static int amount = 3;

    @Override
    public void playerWillDestroy(World worldIn, BlockPos blockPos, BlockState p_176208_3_, PlayerEntity playerIn) {
        super.playerWillDestroy(worldIn, blockPos, p_176208_3_, playerIn);
        worldIn.playSound(playerIn,blockPos,SoundInit.WUANTANIO_ORE_BREAK.get(), SoundCategory.BLOCKS,1.0f,1.0f);
    }

    @Override
    protected int xpOnDrop(Random p_220281_1_) {
        return MathHelper.nextInt(p_220281_1_, 0, 15);
    }


    @Override
    public void playerDestroy(World worldIn, PlayerEntity playerIn, BlockPos blockPos, BlockState blockState, @Nullable TileEntity p_180657_5_, ItemStack p_180657_6_) {
        super.playerDestroy(worldIn, playerIn, blockPos, blockState, p_180657_5_, p_180657_6_);
        //worldIn.playSound(playerIn,blockPos,SoundInit.WUANTANIO_ORE_BREAK.get(), SoundCategory.BLOCKS,1.0f,1.0f);

    }


}
