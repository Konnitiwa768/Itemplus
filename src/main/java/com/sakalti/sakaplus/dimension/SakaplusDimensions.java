package com.sakalti.sakaplus.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

public class SakaplusDimensions {

    // ディメンションキー
    public static final RegistryKey<World> KRUZIVILIM_DIMENSION_KEY = RegistryKey.of(
            Registry.WORLD_KEY,
            new Identifier("sakaplus", "kruzivilim")
    );

    // ディメンションタイプキー
    public static final RegistryKey<DimensionType> KRUZIVILIM_DIMENSION_TYPE_KEY = RegistryKey.of(
            Registry.DIMENSION_TYPE_KEY,
            new Identifier("sakaplus", "kruzivilim")
    );

    // バイオームキー（例：黄土色の昆布バイオーム）
    public static final RegistryKey<Biome> KRUZIVILIM_BIOME_KEY = RegistryKey.of(
            Registry.BIOME_KEY,
            new Identifier("sakaplus", "kruzivilim_biome")
    );

    // ノイズ設定キー（チャンク生成用）
    public static final RegistryKey<ChunkGeneratorSettings> KRUZIVILIM_NOISE_SETTINGS_KEY = RegistryKey.of(
            Registry.CHUNK_GENERATOR_SETTINGS_KEY,
            new Identifier("sakaplus", "kruzivilim_noise")
    );

}
