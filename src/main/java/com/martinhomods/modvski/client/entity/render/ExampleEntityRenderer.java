package com.martinhomods.modvski.client.entity.render;

import com.martinhomods.modvski.client.entity.model.ExampleEntityModel;
import com.martinhomods.modvski.entities.ExampleEntity;
import com.martinhomods.modvski.modvski;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ExampleEntityRenderer extends MobRenderer<ExampleEntity, ExampleEntityModel<ExampleEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(modvski.MODID, "textures/entity/example/example.png");

    public ExampleEntityRenderer(EntityRendererManager manager) {
        super(manager, new ExampleEntityModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(ExampleEntity p_110775_1_) {
        return TEXTURE;
    }

}