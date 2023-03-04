package com.martinhomods.modvski.items.vehicles.lamborghini;

import com.martinhomods.modvski.console;
import com.martinhomods.modvski.entities.lamborghini_entity;
import com.martinhomods.modvski.init.EntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.AbstractSpawner;
import org.antlr.v4.runtime.misc.NotNull;

import javax.annotation.Nullable;
import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class lamborghini_item extends Item implements IDispenseItemBehavior {
    Supplier<? extends EntityType<lamborghini_entity>> defaultType;
    public lamborghini_item(Properties p_i48487_1_, Supplier<? extends EntityType<lamborghini_entity>> entityType ) {
        super(p_i48487_1_);
        this.defaultType = entityType;
        DispenserBlock.registerBehavior(this, this);
    }
    Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.NO_SPECTATORS.and(Entity::isPickable);
    /*@Override
    public ActionResultType useOn(ItemUseContext context) {
        //return super.useOn(context);
        World world = context.getLevel();
        BlockPos clickedPlock = context.getClickedPos();
        ItemStack itemStack = context.getItemInHand();
        itemStack.shrink(1); //remove item do inventario
        lamborghini_entity lamborghini = new lamborghini_entity(EntityType.BOAT,);
        return  ActionResultType.CONSUME;
    }*/

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        return entity.hurt(DamageSource.GENERIC,5);
    }

    public EntityType<?> getType(@Nullable CompoundNBT p_208076_1_) {
        if (p_208076_1_ != null && p_208076_1_.contains("EntityTag", 10)) {
            CompoundNBT compoundnbt = p_208076_1_.getCompound("EntityTag");
            if (compoundnbt.contains("id", 8)) {
                return EntityType.byString(compoundnbt.getString("id")).orElse(EntityInit.LAMBORGHINI_ENTITY.get());
            }
        }

        return EntityInit.LAMBORGHINI_ENTITY.get();
    }


    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
        if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(itemstack);
        } else {
            Vector3d vec3d = playerIn.getViewVector(1.0F);
            List<Entity> list = worldIn.getEntities(playerIn, playerIn.getBoundingBox().expandTowards(vec3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vector3d vec3d1 = playerIn.getEyePosition(1.0F);

                for (Entity entity : list) {
                    AxisAlignedBB axisalignedbb = entity.getBoundingBox().inflate(entity.getPickRadius());
                    if (axisalignedbb.contains(vec3d1)) {
                        return ActionResult.pass(itemstack);
                    }
                }
            }

            if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                lamborghini_entity planeEntity = defaultType.get().create(worldIn);

                planeEntity.setPos(raytraceresult.getLocation().x(), raytraceresult.getLocation().y(), raytraceresult.getLocation().z());
                planeEntity.yRot = playerIn.yRot;
                planeEntity.yRotO = playerIn.yRotO;
                planeEntity.setCustomName(itemstack.getHoverName());

                if (!worldIn.noCollision(planeEntity, planeEntity.getBoundingBox().inflate(-0.1D))) {
                    return ActionResult.fail(itemstack);
                } else {
                    if (!worldIn.isClientSide) {
                        worldIn.addFreshEntity(planeEntity);
                        if (!playerIn.abilities.instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    return ActionResult.success(itemstack);
                }
            } else {
                return ActionResult.pass(itemstack);
            }
        }
    }

    @Override
    public ItemStack dispense(IBlockSource blockSource, ItemStack itemStack) {
        Direction direction = blockSource.getBlockState().getValue(DispenserBlock.FACING);
        int x = 0, y = 0, z = 0;

        if(direction.compareTo(Direction.UP) == 0){
            y = 1;
            //pos.mutable().move(new Vector3i(0,1,0));
        }else if(direction.compareTo(Direction.DOWN) == 0){
            y = -1;
            //pos.mutable().move(new Vector3i(0,-11,0));
        }else if(direction.compareTo(Direction.WEST) == 0) {
            x = -1;
            //pos.mutable().move(new Vector3i(1,0,0));
        }else if(direction.compareTo(Direction.EAST) == 0){
            x = 1;
            //pos.mutable().move(new Vector3i(-1,0,0));
        }else if(direction.compareTo(Direction.SOUTH) == 0){
            z = 1;
            //pos.mutable().move(new Vector3i(0,0,1));
        }else if(direction.compareTo(Direction.NORTH) == 0){
            z = -1;
            //pos.mutable().move(new Vector3i(0,0,-1));
        }
        BlockPos pos = new BlockPos(blockSource.x()+x,blockSource.y()+y,blockSource.z()+z);
        EntityInit.LAMBORGHINI_ENTITY.get().spawn(
                blockSource.getLevel(),
                itemStack,
                null,
                pos,
                SpawnReason.DISPENSER,
                direction != Direction.UP, false
                );
        itemStack.shrink(1);
        //DirectionProperty a = DispenserBlock.FACING

        return itemStack;
    }
}
