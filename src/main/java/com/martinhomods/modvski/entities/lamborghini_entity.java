package com.martinhomods.modvski.entities;

import com.martinhomods.modvski.init.EntityInit;
import com.martinhomods.modvski.init.ItemInit;
import com.martinhomods.modvski.modvski;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeEntity;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;

public class lamborghini_entity extends Entity {

    private static final DataParameter<Integer> DATA_ID_HURT = EntityDataManager.defineId(lamborghini_entity.class, DataSerializers.INT);
    private static final DataParameter<Integer> DATA_ID_HURTDIR = EntityDataManager.defineId(lamborghini_entity.class, DataSerializers.INT);
    private static final DataParameter<Float> DATA_ID_DAMAGE = EntityDataManager.defineId(lamborghini_entity.class, DataSerializers.FLOAT);
    private int lerpSteps;
    private double lerpX;
    private double lerpY;
    private double lerpZ;
    private double lerpYRot;
    private double lerpXRot;

    protected float deltaRotation;

    public lamborghini_entity(EntityType<? extends Entity> type, World world){
        super(type,world);
    }
/*
    public lamborghini_entity(World worldIn, double x, double y, double z) {
        super(EntityInit.LAMBORGHINI_ENTITY.get()
        //EntityType.Builder.of(
                //        lamborghini_entity::new,
                //        EntityClassification.MISC
                //).sized(1f,1f)
                //.build(new ResourceLocation(modvski.MODID,"lamborghini_entity").toString())
                ,worldIn);
        //super(worldIn);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }
*/

    @Override
    public ActionResultType interact(PlayerEntity player, Hand hand) {
        if (!player.isShiftKeyDown()) {
            if (player.getVehicle() != this) {
                if (!level.isClientSide) {
                    player.startRiding(this);
                }
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.FAIL;
    }


/*
    @Override
    public boolean hurt(DamageSource source, float damage) {

        if(this.isInvulnerableTo(source)){
            return false;
        }
        if(!this.level.isClientSide && !this.isAlive()){
            this.setHurtDir(-this.getHurtDir());
            this.setHurtTime(10);
            this.setDamage(this.getDamage() + damage * 10.0F);
            this.markHurt();
            boolean flag = source.getEntity() instanceof PlayerEntity && ((PlayerEntity)source.getEntity()).abilities.instabuild;
            if (flag || this.getDamage() > 40.0F) {
                if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                    this.spawnAtLocation(ItemInit.LAMBORGHINI.get());
                }
                this.remove();
            }
        }
        return true;
    }
*/
    @Override
    protected boolean isMovementNoisy() {
        return true;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT p_70037_1_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT p_213281_1_) {

    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

/*
    public void setHurtDir(int p_70269_1_) {
        this.entityData.set(DATA_ID_HURTDIR, p_70269_1_);
    }

    public int getHurtDir() {
        return this.entityData.get(DATA_ID_HURTDIR);
    }
    public void setDamage(float p_70266_1_) {
        this.entityData.set(DATA_ID_DAMAGE, p_70266_1_);
    }

    public float getDamage() {
        return this.entityData.get(DATA_ID_DAMAGE);
    }


    public void setHurtTime(int p_70265_1_) {
        this.entityData.set(DATA_ID_HURT, p_70265_1_);
    }

    public int getHurtTime() {
        return this.entityData.get(DATA_ID_HURT);
    }
    */
}
