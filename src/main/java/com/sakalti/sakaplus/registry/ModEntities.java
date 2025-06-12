package com.sakalti.sakaplus.registry;

import com.sakalti.sakaplus.entity.*;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
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

    public static final EntityType<WarperdunEntity> WARPERDUN = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("sakaplus", "warperdun"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WarperdunEntity::new)
                    .dimensions(EntityDimensions.fixed(3.0F, 3.0F))
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
        FabricDefaultAttributeRegistry.register(WARPERDUN, WarperdunEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(OGANESON, OganesonEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NYANKO, NyankoEntity.createAttributes());

        // Spawns
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST),
                SpawnGroup.MONSTER, SCORCHER, 20, 1, 5
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                SpawnGroup.MONSTER, NYANKO, 11, 1, 5
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST, BiomeKeys.CRIMSON_FOREST),
                SpawnGroup.MONSTER, OGANESON, 20, 1, 6
        );

        // 例：WARPERDUNはネザーのソウルサンドの谷にスポーン
        //BiomeModifications.addSpawn(
        //        BiomeSelectors.includeByKey(BiomeKeys.SOUL_SAND_VALLEY),
        //        SpawnGroup.MONSTER, WARPERDUN, 5, 1, 1
        //);

        // Spawn Eggs 登録（ModItems にまとめる）
        ModItems.registerSpawnEgg("scorcher_spawn_egg", SCORCHER, 0xAA0000, 0xFF5500);
        ModItems.registerSpawnEgg("warperdun_spawn_egg", WARPERDUN, 0x003366, 0x660099);
        ModItems.registerSpawnEgg("oganeson_spawn_egg", OGANESON, 0x336699, 0x00FFFF);
        ModItems.registerSpawnEgg("nyanko_spawn_egg", NYANKO, 0xFFFFCC, 0xFF66CC);
    }
}
