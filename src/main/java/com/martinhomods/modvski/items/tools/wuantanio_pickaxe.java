package com.martinhomods.modvski.items.tools;

import com.martinhomods.modvski.console;
import com.martinhomods.modvski.init.SoundInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class wuantanio_pickaxe extends PickaxeItem {

    public wuantanio_pickaxe(IItemTier iItemTier, int attackDamage, float attackSpeed, Properties props) {
        super(iItemTier, attackDamage, attackSpeed, props);

    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand hand) {
        worldIn.playSound(playerIn,new BlockPos(playerIn.blockPosition()), SoundInit.WUANTANIO_ORE_BREAK.get(), SoundCategory.AMBIENT,1.0f,1.0f);
        return super.use(worldIn, playerIn, hand);
    }


}
