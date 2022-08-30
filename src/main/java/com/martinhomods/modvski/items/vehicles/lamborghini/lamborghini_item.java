package com.martinhomods.modvski.items.vehicles.lamborghini;

import com.martinhomods.modvski.entities.lamborghini_entity;
import com.martinhomods.modvski.init.EntityInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Predicate;

public class lamborghini_item extends Item {
    public lamborghini_item(Properties p_i48487_1_) {
        super(p_i48487_1_);
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

    /*
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        RayTraceResult raytraceresult = getPlayerPOVHitResult(world, player, RayTraceContext.FluidMode.ANY);
        if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(itemstack);
        } else{
            Vector3d vector3d = player.getViewVector(1.0F);

            List<Entity> list = world.getEntities(player, player.getBoundingBox().expandTowards(vector3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vector3d vector3d1 = player.getEyePosition(1.0F);

                for(Entity entity : list) {
                    AxisAlignedBB axisalignedbb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                    if (axisalignedbb.contains(vector3d1)) {
                        return ActionResult.pass(itemstack);
                    }
                }
            }

            if(raytraceresult.getType() == RayTraceResult.Type.BLOCK){
                lamborghini_entity lamborghini = new lamborghini_entity(world,raytraceresult.getLocation().x,raytraceresult.getLocation().y,raytraceresult.getLocation().z);//EntityInit.LAMBORGHINI_ENTITY.get().create(world);//
                lamborghini.yRot = player.yRot;
                if(!world.noCollision(lamborghini,lamborghini.getBoundingBox().inflate(2D))){
                    return ActionResult.fail(itemstack);
                } else{
                    if(!world.isClientSide){
                        world.addFreshEntity(lamborghini);
                        if(!player.abilities.instabuild){
                            itemstack.shrink(1);
                        }
                    }
                    return ActionResult.sidedSuccess(itemstack,world.isClientSide());

                }
            }else {
                return ActionResult.pass(itemstack);
            }

        }

    }
    */
}
