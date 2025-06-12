package com.sakalti.sakaplus.world.dimension;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerLevelData;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.levelgen.presets.WorldPreset;

import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.BiomeManager;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class SakaplusDimensions {
    public static final ResourceKey<Level> KRUZIVILIM_DIMENSION_KEY =
        ResourceKey.create(Registries.DIMENSION, new ResourceLocation(Sakaplus.MOD_ID, "kruzivilim"));
    
    public static final ResourceKey<DimensionType> KRUZIVILIM_TYPE =
        ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(Sakaplus.MOD_ID, "kruzivilim"));
    
    public static final ResourceKey<Biome> KRUZIVILIM_BIOME =
        ResourceKey.create(Registries.BIOME, new ResourceLocation(Sakaplus.MOD_ID, "kruzivilim_biome"));
    
    public static final ResourceKey<NoiseGeneratorSettings> KRUZIVILIM_NOISE_SETTINGS =
        ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(Sakaplus.MOD_ID, "kruzivilim_generator"));

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            Registry<LevelStem> dimensionRegistry = server.registryAccess().registryOrThrow(Registries.LEVEL_STEM);

            if (!dimensionRegistry.containsKey(KRUZIVILIM_DIMENSION_KEY)) {
                Holder<DimensionType> dimensionType = server.registryAccess().registryOrThrow(Registries.DIMENSION_TYPE)
                    .getHolderOrThrow(KRUZIVILIM_TYPE);
                Holder<NoiseGeneratorSettings> generatorSettings = server.registryAccess().registryOrThrow(Registries.NOISE_SETTINGS)
                    .getHolderOrThrow(KRUZIVILIM_NOISE_SETTINGS);
                Holder<Biome> biome = server.registryAccess().registryOrThrow(Registries.BIOME)
                    .getHolderOrThrow(KRUZIVILIM_BIOME);

                NoiseBasedChunkGenerator chunkGenerator = new NoiseBasedChunkGenerator(
                    MultiNoiseBiomeSource.create(biome),
                    generatorSettings
                );

                LevelStem stem = new LevelStem(dimensionType, chunkGenerator);

                ((net.minecraft.core.WritableRegistry<LevelStem>) dimensionRegistry)
                    .register(KRUZIVILIM_DIMENSION_KEY, stem, null);
            }
        });
    }
}
