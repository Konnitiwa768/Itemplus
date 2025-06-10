package com.sakalti.sakaplus.registry;

import com.sakalti.sakaplus.entity.ScorcherEntity;
import com.sakalti.sakaplus.entity.OganesonEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntities {
    public static final EntityType<ScorcherEntity> SCORCHER = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("sakaplus", "scorcher"),
            EntityType.Builder.create(ScorcherEntity::new, SpawnGroup.MONSTER)
                    .setDimensions(0.6F, 1.8F)
                    .build("scorcher")
    );
    public static final EntityType<OganesonEntity> OGANESON = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("sakaplus", "oganeson"),
            EntityType.Builder.create(OganesonEntity::new, SpawnGroup.MONSTER)
                    .setDimensions(0.6F, 1.8F)
                    .build("oganeson")
    );
    public static final EntityType<NyankoEntity> NYANKO = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("sakaplus", "nyanko"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, NyankoEntity::new)
                .dimensions(EntityDimensions.fixed(0.8f, 0.8f)) // サイズは自由に調整
                .build("nyanko")
    );

    public static void register() {
        // Scorcher: 深紅の森のみ
        BiomeModifications.addSpawn(
            BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST),
            SpawnGroup.MONSTER,
            SCORCHER,
            20, // ウェイト
            1,  // 最小スポーン数
            5   // 最大スポーン数
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
            SpawnGroup.MONSTER,
            NYANKO,
            11, // ウェイト
            1,  // 最小スポーン数
            5   // 最大スポーン数
        );

        // Oganeson: 歪んだ森または深紅の森
        BiomeModifications.addSpawn(
            BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST, BiomeKeys.CRIMSON_FOREST),
            SpawnGroup.MONSTER,
            OGANESON,
            20, // ウェイト
            1,  // 最小スポーン数
            6   // 最大スポーン数
        );
    }
}
