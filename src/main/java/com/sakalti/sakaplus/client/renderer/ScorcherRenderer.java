package com.sakalti.sakaplus.client.renderer;

import com.sakalti.sakaplus.entity.ScorcherEntity;
import com.sakalti.sakaplus.client.model.ScorcherModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.ModelIdentifier;

public class ScorcherRenderer extends MobEntityRenderer<ScorcherEntity, ScorcherModel> {
    private static final Identifier TEXTURE = new Identifier("sakaplus", "textures/entity/scorcher.png");

    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(
        new Identifier("sakaplus", "scorcher"), "main");

    public ScorcherRenderer(EntityRendererFactory.Context context) {
        super(context, new ScorcherModel(context.getPart(MODEL_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(ScorcherEntity entity) {
        return TEXTURE;
    }
}
