package com.martinhomods.modvski.items.vehicles.lamborghini;

import com.martinhomods.modvski.console;
import com.martinhomods.modvski.entities.lamborghini_entity;
import com.martinhomods.modvski.init.EntityInit;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
import java.util.function.Predicate;

public class lamborghini_item extends Item implements IDispenseItemBehavior {
    public lamborghini_item(Properties p_i48487_1_) {
        super(p_i48487_1_);
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

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        RayTraceResult raytraceresult = getPlayerPOVHitResult(world, player, RayTraceContext.FluidMode.ANY);
        if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(itemStack);
        } else{
            Vector3d vector3d = player.getViewVector(1.0F);

            List<Entity> list = world.getEntities(player, player.getBoundingBox().expandTowards(vector3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vector3d vector3d1 = player.getEyePosition(1.0F);

                for(Entity entity : list) {
                    AxisAlignedBB axisalignedbb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                    if (axisalignedbb.contains(vector3d1)) {
                        return ActionResult.pass(itemStack);
                    }
                }
            }

            if(raytraceresult.getType() == RayTraceResult.Type.BLOCK){
                lamborghini_entity lamborghini = new lamborghini_entity(world,raytraceresult.getLocation().x,raytraceresult.getLocation().y,raytraceresult.getLocation().z);//EntityInit.LAMBORGHINI_ENTITY.get().create(world);//
                lamborghini.setYBodyRot(player.yRot);
                /*lamborghini.setPos(x,y,z);
                if(!world.isClientSide){
                    world.addFreshEntity(lamborghini);
                    if(!player.abilities.instabuild){
                        itemStack.shrink(1);
                    }
                }
                return ActionResult.sidedSuccess(itemStack,world.isClientSide());
                */

                if(!world.noCollision(lamborghini,lamborghini.getBoundingBox())){
                    return ActionResult.fail(itemStack);
                } else{

                    if(!world.isClientSide){
                        world.addFreshEntity(lamborghini);
                        if(!player.abilities.instabuild){
                            itemStack.shrink(1);
                        }
                    }
                    return ActionResult.sidedSuccess(itemStack,world.isClientSide());

                }
            }else {
                return ActionResult.pass(itemStack);
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
