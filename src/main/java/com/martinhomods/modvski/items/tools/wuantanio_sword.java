package com.martinhomods.modvski.items.tools;

import com.martinhomods.modvski.console;
import com.martinhomods.modvski.util.ModItemTier;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;

public class wuantanio_sword extends SwordItem {
    int dano;

    public wuantanio_sword(IItemTier iItemTier, int attackDamage, float attackSpeed, Properties props) {
        super(iItemTier, attackDamage, attackSpeed, props);
    }

}
