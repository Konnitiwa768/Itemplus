package com.sakalti.sakaplus.client.model;

import com.sakalti.sakaplus.entity.KuloogieEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.math.MathHelper;

public class KuloogieModel extends SinglePartEntityModel<KuloogieEntity> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart[] legs = new ModelPart[4];
    private final ModelPart[] ears = new ModelPart[2];

    public KuloogieModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.legs[0] = root.getChild("leg_fl");
        this.legs[1] = root.getChild("leg_fr");
        this.legs[2] = root.getChild("leg_bl");
        this.legs[3] = root.getChild("leg_br");
        this.ears[0] = root.getChild("ear_l");
        this.ears[1] = root.getChild("ear_r");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // 本体 13*13*13
        root.addChild("body",
            ModelPartBuilder.create().uv(0, 0).cuboid(-6.5F, -13F, -6.5F, 13, 13, 13),
            ModelTransform.pivot(0, 13, 0)
        );

        // 足（小さい四隅 3x3x3）
        root.addChild("leg_fl", ModelPartBuilder.create().uv(0, 26).cuboid(-1.5F, 0F, -1.5F, 3, 3, 3), ModelTransform.pivot(-5F, 13F, -5F));
        root.addChild("leg_fr", ModelPartBuilder.create().uv(12, 26).cuboid(-1.5F, 0F, -1.5F, 3, 3, 3), ModelTransform.pivot(5F, 13F, -5F));
        root.addChild("leg_bl", ModelPartBuilder.create().uv(24, 26).cuboid(-1.5F, 0F, -1.5F, 3, 3, 3), ModelTransform.pivot(-5F, 13F, 5F));
        root.addChild("leg_br", ModelPartBuilder.create().uv(36, 26).cuboid(-1.5F, 0F, -1.5F, 3, 3, 3), ModelTransform.pivot(5F, 13F, 5F));

        // 耳（小さい三角柱 2x3x2）
        root.addChild("ear_l", ModelPartBuilder.create().uv(0, 32).cuboid(-1F, -3F, -1F, 2, 3, 2), ModelTransform.pivot(-3F, 0F, -5F));
        root.addChild("ear_r", ModelPartBuilder.create().uv(8, 32).cuboid(-1F, -3F, -1F, 2, 3, 2), ModelTransform.pivot(3F, 0F, -5F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setAngles(BattleNyankoEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // 足のパタパタ
        float speed = 1.0F;
        float degree = 1.0F;
        this.legs[0].pitch = MathHelper.cos(limbAngle * speed) * degree * limbDistance;
        this.legs[1].pitch = MathHelper.cos(limbAngle * speed + (float)Math.PI) * degree * limbDistance;
        this.legs[2].pitch = MathHelper.cos(limbAngle * speed + (float)Math.PI) * degree * limbDistance;
        this.legs[3].pitch = MathHelper.cos(limbAngle * speed) * degree * limbDistance;
    }
}
