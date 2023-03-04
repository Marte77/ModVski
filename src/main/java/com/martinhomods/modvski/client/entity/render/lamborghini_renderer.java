package com.martinhomods.modvski.client.entity.render;

import com.martinhomods.modvski.client.entity.model.lamborghini_model;
import com.martinhomods.modvski.entities.lamborghini_entity;
import com.martinhomods.modvski.modvski;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;


public class lamborghini_renderer extends EntityRenderer<Entity> {
    protected final lamborghini_model model = new lamborghini_model();
    protected static final ResourceLocation TEXTURE = new ResourceLocation(modvski.MODID,"textures/entity/lamborghini_entity/carro.png");
    public static final float SHADOW_SIZE = .6f;

    public lamborghini_renderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
        this.shadowRadius = SHADOW_SIZE;
    }


    @Override
    public void render(Entity lamborghini_entity, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        p_225623_4_.pushPose();
        p_225623_4_.translate(0.0D, 0.375D, 0.0D);
        p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_225623_2_));


        p_225623_4_.scale(-1.0F, -1.0F, 1.0F);
        p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        this.model.setupAnim(lamborghini_entity, p_225623_3_, 0.0F, -0.1F, 0.0F, 0.0F);
        IVertexBuilder ivertexbuilder = p_225623_5_.getBuffer(this.model.renderType(this.getTextureLocation(lamborghini_entity)));
        this.model.renderToBuffer(p_225623_4_, ivertexbuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        p_225623_4_.popPose();

        //this.model.setupAnim(lamborghini_entity, p_225623_3_, 0.0F, -0.1F, 0.0F, 0.0F);
        //IVertexBuilder ivertexbuilder = p_225623_5_.getBuffer(this.model.renderType(this.getTextureLocation(lamborghini_entity)));
        //this.model.renderToBuffer(p_225623_4_, ivertexbuilder, p_225623_6_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        super.render(lamborghini_entity, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity p_110775_1_) {
        return TEXTURE;
    }
}
