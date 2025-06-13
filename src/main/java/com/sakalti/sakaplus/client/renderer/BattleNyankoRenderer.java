package com.sakalti.sakaplus.client.renderer;

import com.sakalti.sakaplus.entity.BattleNyankoEntity;
import com.sakalti.sakaplus.client.model.BattleNyankoModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class BattleNyankoRenderer extends MobEntityRenderer<BattleNyankoEntity, BattleNyankoModel> {
    private static final Identifier TEXTURE = new Identifier("sakaplus", "textures/entity/battle_nyanko.png");

    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(
        new Identifier("sakaplus", "battle_nyanko"), "main");

    public BattleNyankoRenderer(EntityRendererFactory.Context context) {
        super(context, new BattleNyankoModel(context.getPart(MODEL_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(BattleNyankoEntity entity) {
        return TEXTURE;
    }
}
