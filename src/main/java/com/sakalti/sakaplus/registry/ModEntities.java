package com.sakalti.sakaplus.registry;

import com.sakalti.sakaplus.entity.ScorcherEntity;
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
                    .setDimensions(0.6F, 1.8F))
                    .fireImmune()
                    .build()
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(SCORCHER, ScorcherEntity.createAttributes());
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST),
                SpawnGroup.MONSTER,
                SCORCHER,
                20, 1, 2
        );
    }
}
