package com.martinhomods.modvski.world.gen;

import com.martinhomods.modvski.blocks.wuantanio_ore;
import com.martinhomods.modvski.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {

    public static void gerarOres(final BiomeLoadingEvent biomeLoadingEvent){
        if(!(biomeLoadingEvent.getCategory().equals(Biome.Category.NETHER)) ||!(biomeLoadingEvent.getCategory().equals(Biome.Category.THEEND)) ) {
            generateOres(biomeLoadingEvent.getGeneration(),OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    BlockInit.WUANTANIO_ORE.get().defaultBlockState(), wuantanio_ore.veinSize,wuantanio_ore.minHeigth,wuantanio_ore.maxHeigth,wuantanio_ore.amount);
        }
    }

    //https://www.youtube.com/watch?v=8s1x4Z87Aw8
    private static void generateOres(BiomeGenerationSettingsBuilder settingsBuilder, RuleTest fillertype, BlockState state, int veinSize,
                              int minHeigth, int maxHeigth, int amount){
            settingsBuilder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.configured(new OreFeatureConfig(fillertype,state.getBlockState(),veinSize)).decorated(
                            Placement.RANGE.configured(new TopSolidRangeConfig(minHeigth,0,maxHeigth))
                                    .squared().
                                    count(amount)));
    }
}
