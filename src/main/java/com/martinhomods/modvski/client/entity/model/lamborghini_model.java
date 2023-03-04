package com.martinhomods.modvski.client.entity.model;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class lamborghini_model extends EntityModel<Entity> {
	private final ModelRenderer rodas;
	private final ModelRenderer corpo;
	private final ModelRenderer vidroinclinado2_r1;
	private final ModelRenderer vidro5_r1;
	private final ModelRenderer vidro4_r1;
	private final ModelRenderer vidro3_r1;
	private final ModelRenderer barratras2_r1;
	private final ModelRenderer barrafrente2_r1;

	public lamborghini_model() {
		texWidth = 64;
		texHeight = 64;

		rodas = new ModelRenderer(this);
		rodas.setPos(0.0F, -17.0F, 1.0F);
		rodas.texOffs(0, 59).addBox(-9.5F, 37.25F, 4.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		rodas.texOffs(0, 59).addBox(-9.5F, 37.25F, -6.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		rodas.texOffs(0, 59).addBox(4.5F, 37.25F, -6.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		rodas.texOffs(0, 59).addBox(4.5F, 37.25F, 4.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		corpo = new ModelRenderer(this);
		corpo.setPos(0.0F, 65.0F, 0.0F);
		setRotationAngle(corpo, 3.1416F, 0.0F, 0.0F);
		corpo.texOffs(4, 0).addBox(-11.0F, 43.0F, -5.0F, 21.0F, 4.0F, 9.0F, 0.0F, false);
		corpo.texOffs(16, 11).addBox(-8.75F, 50.0F, -5.0F, 12.0F, 1.0F, 9.0F, 0.0F, false);
		corpo.texOffs(0, 0).addBox(-6.0F, 45.0F, 2.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		corpo.texOffs(0, 0).addBox(-6.0F, 45.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		corpo.texOffs(48, 41).addBox(-5.0F, 45.0F, 3.0F, 6.0F, 5.0F, 0.0F, 0.0F, false);
		corpo.texOffs(52, 51).addBox(-5.0F, 45.0F, -4.0F, 6.0F, 5.0F, 0.0F, 0.0F, false);

		vidroinclinado2_r1 = new ModelRenderer(this);
		vidroinclinado2_r1.setPos(0.0F, 42.0F, 0.0F);
		corpo.addChild(vidroinclinado2_r1);
		setRotationAngle(vidroinclinado2_r1, 0.0F, 0.0F, 0.829F);
		vidroinclinado2_r1.texOffs(58, 58).addBox(4.0F, -1.0F, -4.0F, 3.0F, 6.0F, 0.0F, 0.0F, false);
		vidroinclinado2_r1.texOffs(58, 54).addBox(4.0F, -1.0F, 3.0F, 3.0F, 6.0F, 0.0F, 0.0F, false);

		vidro5_r1 = new ModelRenderer(this);
		vidro5_r1.setPos(0.0F, 42.0F, 0.0F);
		corpo.addChild(vidro5_r1);
		setRotationAngle(vidro5_r1, 0.0F, 0.0F, 0.7854F);
		vidro5_r1.texOffs(51, 39).addBox(8.0F, -1.0F, -3.0F, 0.0F, 5.0F, 5.0F, 0.0F, false);

		vidro4_r1 = new ModelRenderer(this);
		vidro4_r1.setPos(0.0F, 42.0F, 0.0F);
		corpo.addChild(vidro4_r1);
		setRotationAngle(vidro4_r1, 0.0F, 0.0F, -0.3491F);
		vidro4_r1.texOffs(54, 50).addBox(-10.0F, 0.0F, -3.0F, 0.0F, 5.0F, 5.0F, 0.0F, false);

		vidro3_r1 = new ModelRenderer(this);
		vidro3_r1.setPos(0.0F, 42.0F, 0.0F);
		corpo.addChild(vidro3_r1);
		setRotationAngle(vidro3_r1, 0.0F, 0.0F, -0.1187F);
		vidro3_r1.texOffs(51, 46).addBox(-9.0F, 1.0F, -4.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);
		vidro3_r1.texOffs(52, 54).addBox(-9.0F, 1.0F, 3.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);

		barratras2_r1 = new ModelRenderer(this);
		barratras2_r1.setPos(0.0F, 44.0F, 16.0F);
		corpo.addChild(barratras2_r1);
		setRotationAngle(barratras2_r1, 0.0F, 0.0F, 1.1781F);
		barratras2_r1.texOffs(0, 0).addBox(-2.0F, 9.0F, -20.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		barratras2_r1.texOffs(0, 0).addBox(-2.0F, 9.0F, -14.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		barrafrente2_r1 = new ModelRenderer(this);
		barrafrente2_r1.setPos(0.0F, 42.0F, 0.0F);
		corpo.addChild(barrafrente2_r1);
		setRotationAngle(barrafrente2_r1, 0.0F, 0.0F, -0.6981F);
		barrafrente2_r1.texOffs(0, 0).addBox(-4.0F, 7.0F, -4.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		barrafrente2_r1.texOffs(0, 0).addBox(-4.0F, 7.0F, 2.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		rodas.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		corpo.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}