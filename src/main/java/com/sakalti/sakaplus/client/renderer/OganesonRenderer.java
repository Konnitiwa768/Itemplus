package com.sakalti.sakaplus.client.renderer;

import com.sakalti.sakaplus.entity.OganesonEntity;
import com.sakalti.sakaplus.client.model.ScorcherModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.ModelIdentifier;

public class OganesonRenderer extends MobEntityRenderer<OganesonEntity, OganesonModel> {
    private static final Identifier TEXTURE = new Identifier("sakaplus", "textures/entity/oganeson.png");

    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(
        new Identifier("sakaplus", "oganeson"), "main");

    public OganesonRenderer(EntityRendererFactory.Context context) {
        super(context, new ScorcherModel(context.getPart(MODEL_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(OganesonEntity entity) {
        return TEXTURE;
    }
}
