package com.martinhomods.modvski.init;

import com.martinhomods.modvski.items.ingots.black_gold_ingot;
import com.martinhomods.modvski.items.ingots.wuantanio_ingot;
import com.martinhomods.modvski.items.misc.black_gold_wheel;
import com.martinhomods.modvski.items.misc.wuantanio_cart;
import com.martinhomods.modvski.items.tools.*;
import com.martinhomods.modvski.items.vehicles.lamborghini.lamborghini_item;
import com.martinhomods.modvski.modvski;
import com.martinhomods.modvski.util.ModItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

//summon minecraft:wither ~ ~ ~ {NoAI: 1b,Silent:1b,PersistenceRequired:1b}

public class ItemInit {
        //é o que informa o FML sobre os meus items
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, modvski.MODID);

        //ingots
        public static final RegistryObject<Item> WUANTANIO_INGOT = ITEMS.register("wuantanio_ingot", () -> new wuantanio_ingot(new Item.Properties().tab(menuGrupoItemsCreativo.instance).stacksTo(64)));
        public static final RegistryObject<Item> BLACK_GOLD_INGOT = ITEMS.register("black_gold_ingot", ()-> new black_gold_ingot(new Item.Properties().tab(menuGrupoItemsCreativo.instance).stacksTo(64)));

        //tools
        public static final RegistryObject<Item> WUANTANIO_SWORD = ITEMS.register("wuantanio_sword", () -> new wuantanio_sword(ModItemTier.WUANTANIO,5000,10,new Item.Properties().tab(menuGrupoItemsCreativo.instance).stacksTo(1)));
        public static final RegistryObject<Item> WUANTANIO_PICKAXE = ITEMS.register("wuantanio_pickaxe",()-> new wuantanio_pickaxe(ModItemTier.WUANTANIO,-9990,0,new Item.Properties().tab(menuGrupoItemsCreativo.instance).stacksTo(1)));
        public static final RegistryObject<Item> WUANTANIO_SHOVEL = ITEMS.register("wuantanio_shovel",()-> new wuantanio_shovel(ModItemTier.WUANTANIO,-9990,0,new Item.Properties().tab(menuGrupoItemsCreativo.instance).stacksTo(1)));
        public static final RegistryObject<Item> WUANTANIO_AXE = ITEMS.register("wuantanio_axe",()-> new wuantanio_axe(ModItemTier.WUANTANIO,3500,0,new Item.Properties().tab(menuGrupoItemsCreativo.instance).stacksTo(1)));
        public static final RegistryObject<Item> WUANTANIO_HOE = ITEMS.register("wuantanio_hoe",()-> new wuantanio_hoe(ModItemTier.WUANTANIO,350000,0,new Item.Properties().tab(menuGrupoItemsCreativo.instance).stacksTo(1)));

        //misc
        public static final RegistryObject<Item> BLACK_GOLD_WHEEL = ITEMS.register("black_gold_wheel", () -> new black_gold_wheel(new Item.Properties().tab(menuGrupoItemsCreativo.instance).stacksTo(64)));
        public static final RegistryObject<Item> WUANTANIO_CART = ITEMS.register("wuantanio_cart", () -> new wuantanio_cart(new Item.Properties().tab(menuGrupoItemsCreativo.instance).stacksTo(64)));

        //vehicles
        public static final RegistryObject<Item> LAMBORGHINI = ITEMS.register("lamborghini_item",() -> new lamborghini_item(new Item.Properties().tab(menuGrupoItemsCreativo.instance).stacksTo(1)));

        //menu no modo criativo
        public static class menuGrupoItemsCreativo extends ItemGroup {
                public static final menuGrupoItemsCreativo instance = new menuGrupoItemsCreativo(ItemGroup.TABS.length,modvski.MODID);
                public menuGrupoItemsCreativo(int index, String label) {
                        super(index,label);
                }

                @Override @Nonnull
                public ItemStack makeIcon() {
                        return new ItemStack(BlockInit.WUANTANIO_BLOCK.get());
                }
        }



}


