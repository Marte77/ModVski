package com.martinhomods.modvski.items.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.ActionResultType;

public class wuantanio_shovel extends ShovelItem {
    public wuantanio_shovel(IItemTier iItemTier, int attackDamage, float attackSpeed, Properties props) {
        super(iItemTier, attackDamage, attackSpeed, props);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        return super.onItemUseFirst(stack, context);
    }
}
