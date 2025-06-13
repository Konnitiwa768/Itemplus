package com.sakalti.sakaplus.client.renderer;

import com.sakalti.sakaplus.entity.KurBruteEntity;
import com.sakalti.sakaplus.client.model.KurBruteModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class KurBruteRenderer extends MobEntityRenderer<KurBruteEntity, KurBruteModel> {
    private static final Identifier TEXTURE = new Identifier("sakaplus", "textures/entity/kur_brute.png");

    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(
        new Identifier("sakaplus", "kur_brute"), "main");

    public KurBruteRenderer(EntityRendererFactory.Context context) {
        super(context, new KurBruteModel(context.getPart(MODEL_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(KurBruteEntity entity) {
        return TEXTURE;
    }
}
