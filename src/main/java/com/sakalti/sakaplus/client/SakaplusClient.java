// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.client;

import com.sakalti.sakaplus.parasitory.registry.ParasitoryEntities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.sakalti.sakaplus.parasitory.client.model.UgnazhiModel;
import com.sakalti.sakaplus.parasitory.client.renderer.UgnazhiRenderer;
import com.sakalti.sakaplus.client.renderer.NucreeperRenderer;
import com.sakalti.sakaplus.entity.ModEntities2;
import com.sakalti.sakaplus.client.renderer.KouriTakumiRenderer;
import net.minecraft.class_1299;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import com.sakalti.sakaplus.client.renderer.TotuTakumiRenderer;
import com.sakalti.sakaplus.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;

public class SakaplusClient implements ClientModInitializer
{
    public void onInitializeClient() {
        EntityRendererRegistry.register((class_1299)ModEntities.TOTU_TAKUMI, TotuTakumiRenderer::new);
        EntityRendererRegistry.register((class_1299)ModEntities.KOURI_TAKUMI, KouriTakumiRenderer::new);
        EntityRendererRegistry.register((class_1299)ModEntities2.NUCREEPER, NucreeperRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(UgnazhiRenderer.LAYER, UgnazhiModel::getTexturedModelData);
        EntityRendererRegistry.register((class_1299)ParasitoryEntities.UGNAZHI, UgnazhiRenderer::new);
    }
}
