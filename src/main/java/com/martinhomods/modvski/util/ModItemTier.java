package com.martinhomods.modvski.util;

import com.martinhomods.modvski.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

//base harvest level, durability, mining speed, damage and enchantablity (the higher this is, the better enchantments you get)
//WUANTANIO(5,15000,7.5,10000,5,()->{
//        return
//        });
public enum ModItemTier implements IItemTier {
    //base harvest level, durability, mining speed, damage and enchantablity (the higher this is, the better enchantments you get)
    WUANTANIO(5,15000,50,10000,5,
            ()-> Ingredient.of(ItemInit.WUANTANIO_INGOT.get()));



    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;

    ModItemTier(int harvest_level, int durability, float mining_speed, float damage, int enchantment_value, Supplier<Ingredient> repair_Ingredient) {
        this.level = harvest_level;
        this.uses = durability;
        this.speed = mining_speed;
        this.damage = damage;
        this.enchantmentValue = enchantment_value;
        this.repairIngredient = new LazyValue<>(repair_Ingredient);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
