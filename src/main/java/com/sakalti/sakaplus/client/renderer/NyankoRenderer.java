package com.sakalti.sakaplus.client.renderer;

import com.sakalti.sakaplus.entity.ModEntities;
import com.sakalti.sakaplus.client.model.NyankoModel;
import com.sakalti.sakaplus.entity.NyankoEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class NyankoRenderer extends MobEntityRenderer<NyankoEntity, NyankoModel> {
    private static final Identifier TEXTURE = new Identifier("sakaplus", "textures/entity/nyanko.png");

    public NyankoRenderer(EntityRendererFactory.Context context) {
        super(context, new NyankoModel(context.getPart(ModEntities.NYANKO_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(NyankoEntity entity) {
        return TEXTURE;
    }
}
