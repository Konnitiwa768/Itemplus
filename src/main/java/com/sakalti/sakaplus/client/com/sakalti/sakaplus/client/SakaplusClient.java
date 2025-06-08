/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
 *  net.minecraft.class_5601
 */
package com.sakalti.sakaplus.client;

import com.sakalti.sakaplus.client.renderer.KouriTakumiRenderer;
import com.sakalti.sakaplus.client.renderer.NucreeperRenderer;
import com.sakalti.sakaplus.client.renderer.TotuTakumiRenderer;
import com.sakalti.sakaplus.entity.ModEntities;
import com.sakalti.sakaplus.entity.ModEntities2;
import com.sakalti.sakaplus.parasitory.client.model.UgnazhiModel;
import com.sakalti.sakaplus.parasitory.client.renderer.UgnazhiRenderer;
import com.sakalti.sakaplus.parasitory.registry.ParasitoryEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.class_5601;

public class SakaplusClient
implements ClientModInitializer {
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.TOTU_TAKUMI, TotuTakumiRenderer::new);
        EntityRendererRegistry.register(ModEntities.KOURI_TAKUMI, KouriTakumiRenderer::new);
        EntityRendererRegistry.register(ModEntities2.NUCREEPER, NucreeperRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)UgnazhiRenderer.LAYER, UgnazhiModel::getTexturedModelData);
        EntityRendererRegistry.register(ParasitoryEntities.UGNAZHI, UgnazhiRenderer::new);
    }
}
