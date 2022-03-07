package com.martinhomods.modvski.init;

import com.martinhomods.modvski.blocks.black_gold_block;
import com.martinhomods.modvski.blocks.wuantanio_block;
import com.martinhomods.modvski.blocks.wuantanio_ore;
import com.martinhomods.modvski.modvski;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

//tutoriais http://smolcodes.com/forge-modding-tutorial/text%20tutorials/tutorial#3
//tutoriais https://suppergerrie2.com/minecraft-1-15-modding-with-forge-5-custom-basic-block/

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {
        //é o que informa o FML sobre os meus blocos
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,modvski.MODID);

        //blocos
        public static final RegistryObject<Block> WUANTANIO_BLOCK = BLOCKS.register("wuantanio_block",()
                -> new wuantanio_block(AbstractBlock.Properties.copy(Blocks.DIAMOND_BLOCK)));
        public static final RegistryObject<Block> WUANTANIO_ORE = BLOCKS.register("wuantanio_ore",()
                -> new wuantanio_ore(AbstractBlock.Properties.copy(Blocks.DIAMOND_ORE)));
        public static final RegistryObject<Block> BLACK_GOLD_BLOCK = BLOCKS.register("black_gold_block", ()
                -> new black_gold_block(AbstractBlock.Properties.copy(Blocks.DIAMOND_BLOCK)));
        //public static final RegistryObject<Block> BLACK_GOLD_BLOCK = BLOCKS.register("black_gold_block",()
        //        -> new black_gold_block(AbstractBlock.Properties.copy(Blocks.DIAMOND_BLOCK)));
                //AbstractBlock.Properties.
                //of(new Material(MaterialColor.COLOR_RED,false, true,false,true,false,false, PushReaction.NORMAL))));
        //public static final RegistryObject<Block> wuantanio_ore = BLOCKS.register("wuantanio_ore", () -> new Block(Block))


        @SubscribeEvent
        //regista o bloco automaticamente
        public static void onRegisterItems(final RegistryEvent.Register<Item> event){
                final IForgeRegistry<Item> regist = event.getRegistry();

                BLOCKS.getEntries().stream().map(RegistryObject::get).forEach((block)->{
                        final Item.Properties props = new Item.Properties().tab(ItemInit.menuGrupoItemsCreativo.instance);
                        final BlockItem blockItem = new BlockItem(block,props);
                        if(block.getRegistryName() == null)
                                blockItem.setRegistryName("Sem nome");
                        else blockItem.setRegistryName(block.getRegistryName());
                        regist.register(blockItem);
                });
        }
}


