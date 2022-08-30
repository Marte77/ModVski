package com.martinhomods.modvski.init;

import com.martinhomods.modvski.entities.ExampleEntity;
import com.martinhomods.modvski.entities.lamborghini_entity;
import com.martinhomods.modvski.modvski;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityInit {
    //é o que informa o FML sobre os meus blocos
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, modvski.MODID);

    public static final RegistryObject<EntityType<Entity>> LAMBORGHINI_ENTITY = ENTITIES.register("lamborghini_entity",() ->
                    EntityType.Builder.of(
                            lamborghini_entity::new,
                            EntityClassification.MISC
                    ).sized(1f,1f)
                    .build(new ResourceLocation(modvski.MODID,"lamborghini_entity").toString())
            );

    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE = ENTITIES.register("example",
            ()->EntityType.Builder.
                    of(
                            ExampleEntity::new,
                            EntityClassification.MONSTER)
                    .sized(1f,1f)
                    .build( new ResourceLocation(modvski.MODID,"example").toString()));

    @SubscribeEvent
    public static void createAttributes(EntityAttributeCreationEvent event) {
        //COLOCAR AQUI PARA CRIAR ENTIDADES CRIATURAS
        //event.put(LAMBORGHINI_ENTITY.get(), lamborghini_entity.setAttributes());
        event.put(EXAMPLE.get(),ExampleEntity.setAttributes());
        //GlobalEntityTypeAttributes.put(LAMBORGHINI_ENTITY.get(),lamborghini_entity.setAttributes());
        //EntityAttributeCreationEvent.put(LAMBORGHINI_ENTITY.get(),lamborghini_entity.setCustomAttributes().create());
    }
}
