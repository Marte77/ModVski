package com.martinhomods.modvski.util;

import com.martinhomods.modvski.client.entity.render.ExampleEntityRenderer;
import com.martinhomods.modvski.client.entity.render.lamborghini_renderer;
import com.martinhomods.modvski.entities.lamborghini_entity;
import com.martinhomods.modvski.init.EntityInit;
import com.martinhomods.modvski.modvski;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = modvski.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.LAMBORGHINI_ENTITY.get(), lamborghini_renderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.EXAMPLE.get(), ExampleEntityRenderer::new);
    }
}
