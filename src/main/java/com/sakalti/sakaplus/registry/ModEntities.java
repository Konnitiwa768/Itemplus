package com.sakalti.sakaplus.registry;

import com.sakalti.sakaplus.entity.ScorcherEntity;
import com.sakalti.sakaplus.entity.OganesonEntity;
import com.sakalti.sakaplus.entity.NyankoEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
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
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ScorcherEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.8F))
                    .build()
    );
    public static final EntityType<OganesonEntity> OGANESON = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("sakaplus", "oganeson"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, OganesonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.8F))
                    .build()
    );
    public static final EntityType<NyankoEntity> NYANKO = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("sakaplus", "nyanko"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, NyankoEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8F, 0.8F))
                    .build()
    );

    public static void register() {
        // Attribute Registry
        FabricDefaultAttributeRegistry.register(SCORCHER, ScorcherEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(OGANESON, OganesonEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NYANKO, NyankoEntity.createAttributes());

        // Scorcher: 深紅の森のみ
        BiomeModifications.addSpawn(
            BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST),
            SpawnGroup.MONSTER,
            SCORCHER,
            20, // ウェイト
            1,  // 最小スポーン数
            5   // 最大スポーン数
        );
        // Nyanko: 平原
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
