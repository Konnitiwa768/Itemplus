package com.sakalti.sakaplus.client.renderer;

import com.sakalti.sakaplus.entity.KuloogieEntity;
import com.sakalti.sakaplus.client.model.KuloogieModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class KuloogieRenderer extends MobEntityRenderer<KuloogieEntity, KuloogieModel> {
    private static final Identifier TEXTURE = new Identifier("sakaplus", "textures/entity/kuloogie.png");

    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(
        new Identifier("sakaplus", "kuloogie"), "main");

    public KuloogieRenderer(EntityRendererFactory.Context context) {
        super(context, new KuloogieModel(context.getPart(MODEL_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(KuloogieEntity entity) {
        return TEXTURE;
    }
}
