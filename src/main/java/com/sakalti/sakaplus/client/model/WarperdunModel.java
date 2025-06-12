package com.sakalti.sakaplus.client.model;

import com.sakalti.sakaplus.entity.WarperdunEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class WarperdunModel extends SinglePartEntityModel<WarperdunEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
        new net.minecraft.util.Identifier("sakaplus", "warperdun"), "main");

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart[] legs = new ModelPart[4];
    private final ModelPart lantern_l;
    private final ModelPart lantern_r;
    private final ModelPart portal;

    public WarperdunModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.legs[0] = root.getChild("leg1");
        this.legs[1] = root.getChild("leg2");
        this.legs[2] = root.getChild("leg3");
        this.legs[3] = root.getChild("leg4");
        this.lantern_l = root.getChild("lantern_l");
        this.lantern_r = root.getChild("lantern_r");
        this.portal = root.getChild("portal");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // 体（立方体 12x10x8）
        root.addChild("body",
            ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-6F, -10F, -4F, 12, 10, 8),
            ModelTransform.pivot(0F, 24F, 0F)
        );

        // 頭（立方体 6x6x6、体の前上部に配置）
        root.addChild("head",
            ModelPartBuilder.create()
                .uv(0, 18)
                .cuboid(-3F, -6F, -3F, 6, 6, 6),
            ModelTransform.pivot(0F, 14F, -4F)
        );

        // 足4本（横向きに4本、細長い 2x8x2）
        root.addChild("leg1",
            ModelPartBuilder.create()
                .uv(24, 18)
                .cuboid(-1F, 0F, -1F, 2, 8, 2),
            ModelTransform.pivot(-5F, 16F, 3F)
        );
        root.addChild("leg2",
            ModelPartBuilder.create()
                .uv(28, 18)
                .cuboid(-1F, 0F, -1F, 2, 8, 2),
            ModelTransform.pivot(5F, 16F, 3F)
        );
        root.addChild("leg3",
            ModelPartBuilder.create()
                .uv(24, 28)
                .cuboid(-1F, 0F, -1F, 2, 8, 2),
            ModelTransform.pivot(-5F, 16F, -3F)
        );
        root.addChild("leg4",
            ModelPartBuilder.create()
                .uv(28, 28)
                .cuboid(-1F, 0F, -1F, 2, 8, 2),
            ModelTransform.pivot(5F, 16F, -3F)
        );

        // 提灯 左右（小さい箱 3x4x3）
        root.addChild("lantern_l",
            ModelPartBuilder.create()
                .uv(0, 28)
                .cuboid(-1.5F, -4F, -1.5F, 3, 4, 3),
            ModelTransform.pivot(-6F, 14F, -2F)
        );
        root.addChild("lantern_r",
            ModelPartBuilder.create()
                .uv(12, 28)
                .cuboid(-1.5F, -4F, -1.5F, 3, 4, 3),
            ModelTransform.pivot(6F, 14F, -2F)
        );

        // ポータル（薄い板 8x8x1）
        root.addChild("portal",
            ModelPartBuilder.create()
                .uv(24, 36)
                .cuboid(-4F, -4F, -0.5F, 8, 8, 1),
            ModelTransform.pivot(0F, 12F, 4F)
        );

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setAngles(WarperdunEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // 足は左右交互に前後に動かす（歩行モーション）
        float speed = 1.0F;
        float degree = 0.8F;
        legs[0].pitch = MathHelper.cos(limbAngle * speed) * degree * limbDistance;
        legs[1].pitch = MathHelper.cos(limbAngle * speed + (float)Math.PI) * degree * limbDistance;
        legs[2].pitch = MathHelper.cos(limbAngle * speed + (float)Math.PI) * degree * limbDistance;
        legs[3].pitch = MathHelper.cos(limbAngle * speed) * degree * limbDistance;

        // 頭の回転（左右上下）
        head.yaw = headYaw * ((float)Math.PI / 180F);
        head.pitch = headPitch * ((float)Math.PI / 180F);

        // ポータルは常にゆっくり回転（アニメーション進行度に依存）
        portal.yaw = animationProgress * 0.5F;
    }
}
