package com.martinhomods.modvski.init;

import com.martinhomods.modvski.modvski;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS= DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, modvski.MODID);

    public static final RegistryObject<SoundEvent> WUANTANIO_ORE_BREAK = SOUNDS.register("wuantanio_ore_break"
            , ()-> new SoundEvent(new ResourceLocation(modvski.MODID,"wuantanio_ore_break")));




}
