package com.sakalti.sakaplus.client.renderer;

import com.sakalti.sakaplus.entity.NyankoEntity;
import com.sakalti.sakaplus.client.model.NyankoModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class NyankoRenderer extends MobEntityRenderer<NyankoEntity, NyankoModel> {
    private static final Identifier TEXTURE = new Identifier("sakaplus", "textures/entity/nyanko.png");

    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(
        new Identifier("sakaplus", "nyanko"), "main");

    public NyankoRenderer(EntityRendererFactory.Context context) {
        super(context, new NyankoModel(context.getPart(MODEL_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(NyankoEntity entity) {
        return TEXTURE;
    }
}
