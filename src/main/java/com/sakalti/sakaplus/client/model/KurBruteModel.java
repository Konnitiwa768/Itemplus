package com.sakalti.sakaplus.client.model;

import com.sakalti.sakaplus.entity.KurBruteEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class KurBruteModel extends SinglePartEntityModel<KurBruteEntity> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart frontLeftLeg;
    private final ModelPart frontRightLeg;
    private final ModelPart backLeftLeg;
    private final ModelPart backRightLeg;

    public KurBruteModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.frontLeftLeg = root.getChild("front_left_leg");
        this.frontRightLeg = root.getChild("front_right_leg");
        this.backLeftLeg = root.getChild("back_left_leg");
        this.backRightLeg = root.getChild("back_right_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // Body (central part)
        root.addChild("body",
            ModelPartBuilder.create().uv(0, 0)
                .cuboid(-4.0F, -4.0F, -6.0F, 8, 8, 12),
            ModelTransform.pivot(0.0F, 12.0F, 0.0F)
        );

        // Head
        root.addChild("head",
            ModelPartBuilder.create().uv(0, 20)
                .cuboid(-3.0F, -4.0F, -4.0F, 6, 6, 6),
            ModelTransform.pivot(0.0F, 10.0F, -6.0F)
        );

        // Legs (4 total)

        // Front Left Leg
        root.addChild("front_left_leg",
            ModelPartBuilder.create().uv(32, 0)
                .cuboid(-1.0F, 0.0F, -1.0F, 2, 8, 2),
            ModelTransform.pivot(3.0F, 16.0F, -4.0F)
        );

        // Front Right Leg
        root.addChild("front_right_leg",
            ModelPartBuilder.create().uv(40, 0)
                .cuboid(-1.0F, 0.0F, -1.0F, 2, 8, 2),
            ModelTransform.pivot(-3.0F, 16.0F, -4.0F)
        );

        // Back Left Leg
        root.addChild("back_left_leg",
            ModelPartBuilder.create().uv(48, 0)
                .cuboid(-1.0F, 0.0F, -1.0F, 2, 8, 2),
            ModelTransform.pivot(3.0F, 16.0F, 4.0F)
        );

        // Back Right Leg
        root.addChild("back_right_leg",
            ModelPartBuilder.create().uv(56, 0)
                .cuboid(-1.0F, 0.0F, -1.0F, 2, 8, 2),
            ModelTransform.pivot(-3.0F, 16.0F, 4.0F)
        );

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void setAngles(KurBruteEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        float swing = MathHelper.cos(limbAngle) * limbDistance;

        // 脚を交互に動かす（前後）
        this.frontLeftLeg.pitch = swing;
        this.backRightLeg.pitch = swing;
        this.frontRightLeg.pitch = -swing;
        this.backLeftLeg.pitch = -swing;

        // 頭の回転（オプション）
        this.head.yaw = headYaw * 0.0174533F; // degrees to radians
        this.head.pitch = headPitch * 0.0174533F;
    }
}
