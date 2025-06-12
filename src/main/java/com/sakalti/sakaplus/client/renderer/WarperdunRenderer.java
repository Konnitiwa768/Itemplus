package com.sakalti.sakaplus.client.renderer;

import com.sakalti.sakaplus.entity.WarperdunEntity;
import com.sakalti.sakaplus.client.model.WarperdunModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class WarperdunRenderer extends MobEntityRenderer<WarperdunEntity, WarperdunModel> {
    private static final Identifier TEXTURE = new Identifier("sakaplus", "textures/entity/warperdun.png");

    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(
        new Identifier("sakaplus", "warperdun"), "main");

    public WarperdunRenderer(EntityRendererFactory.Context context) {
        super(context, new WarperdunModel(context.getPart(MODEL_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(WarperdunEntity entity) {
        return TEXTURE;
    }
}
