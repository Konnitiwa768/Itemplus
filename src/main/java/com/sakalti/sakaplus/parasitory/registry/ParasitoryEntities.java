package com.sakalti.sakaplus.parasitory.registry;

import net.minecraft.class_4048;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_1311;
import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_2902;
import net.minecraft.class_1317;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import com.sakalti.sakaplus.parasitory.entity.UgnazhiEntity;
import com.sakalti.sakaplus.parasitory.entity.ShiberEntity; // ←追加
import net.minecraft.class_1299;

public class ParasitoryEntities
{
    public static final class_1299<UgnazhiEntity> UGNAZHI;
    public static final class_1299<ShiberEntity> SHIBER; // ←追加

    public static void register() {
        FabricDefaultAttributeRegistry.register((class_1299)ParasitoryEntities.UGNAZHI, UgnazhiEntity.createAttributes());
        class_1317.method_20637((class_1299)ParasitoryEntities.UGNAZHI, class_1317.class_1319.field_6317, class_2902.class_2903.field_13203, UgnazhiEntity::canSpawn);

        // Shiber 登録処理を追加
        FabricDefaultAttributeRegistry.register((class_1299)ParasitoryEntities.SHIBER, ShiberEntity.createAttributes());
        class_1317.method_20637((class_1299)ParasitoryEntities.SHIBER, class_1317.class_1319.field_6317, class_2902.class_2903.field_13203, ShiberEntity::canSpawn);
    }

    static {
        UGNAZHI = (class_1299)class_2378.method_10230(
            (class_2378)class_2378.field_11145,
            new class_2960("sakaplus", "ugnazhi"),
            (Object)FabricEntityTypeBuilder.create(class_1311.field_6302, UgnazhiEntity::new)
                .dimensions(class_4048.method_18385(0.6f, 0.8f))
                .trackRangeBlocks(8)
                .build()
        );

        // SHIBER登録
        SHIBER = (class_1299)class_2378.method_10230(
            (class_2378)class_2378.field_11145,
            new class_2960("sakaplus", "shiber"),
            (Object)FabricEntityTypeBuilder.create(class_1311.field_6302, ShiberEntity::new)
                .dimensions(class_4048.method_18385(0.7f, 1.0f)) // サイズはお好みで調整
                .trackRangeBlocks(8)
                .build()
        );
    }
}
