package com.sakalti.sakaplus.dimension;

import net.minecraft.world.biome.*;
import com.sakalti.sakaplus.entity.BattleNyankoEntity;
import com.sakalti.sakaplus.registry.ModEntities3;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.EntityType;

public class KruzivilimBiome {

    public static Biome createKruzivilim() {
        BiomeEffects effects = new BiomeEffects.Builder()
                .skyColor(0xDDBB77)  // 黄土色の空
                .fogColor(0xA08050)
                .waterColor(0xCCAA55)
                .waterFogColor(0xCCAA55)
                .build();

        // モブスポーン設定
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        // パッシブモブだけスポーン（例：牛・羊）
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 10, 2, 4));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities3.KULOOGIE, 1, 1, 3));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities3.KUR_BRUTE, 25, 2, 6));
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntities3.BATTLE_NYANKO, 3, 1, 3));
        spawnBuilder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 10, 2, 4));

        // 敵モブなどはスポーンさせない

        // デフォルトの地下構造（鉱石など）は維持
        GenerationSettings.Builder genBuilder = new GenerationSettings.Builder();
        DefaultBiomeFeatures.addDefaultOres(genBuilder);
        DefaultBiomeFeatures.addDefaultDisks(genBuilder);

        return new Biome.Builder()
                .precipitation(Biome.Precipitation.NONE)
                .temperature(0.3F)  // ネザーっぽい高温
                .downfall(0.0F)
                .effects(effects)
                .spawnSettings(spawnBuilder.build())
                .generationSettings(genBuilder.build())
                .build();
    }
}
