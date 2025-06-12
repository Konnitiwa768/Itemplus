package com.sakalti.sakaplus.client.model;

import com.sakalti.sakaplus.entity.OganesonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class OganesonModel extends SinglePartEntityModel<OganesonEntity> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;

    public OganesonModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.leftLeg = root.getChild("left_leg");
        this.rightLeg = root.getChild("right_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // Body: 8x8x8, centered at origin
        root.addChild("body",
            ModelPartBuilder.create().uv(0, 0)
                .cuboid(-4.0F, -4.0F, -4.400F, 8, 8, 8),
            ModelTransform.pivot(0.0F, 12.0F, 0.0F)
        );

        // Left Leg: 8x8x8, rotated +45° Y, positioned below body
        root.addChild("left_leg",
            ModelPartBuilder.create().uv(32, 0)
                .cuboid(-4.0F, 0.0F, -4.0F, 2, 8, 2),
            ModelTransform.of(0.0F, 20.0F, 0.0F, 0.0F, MathHelper.PI / 4, 0.0F)
        );

        // Right Leg: 8x8x8, rotated -45° Y, positioned below body
        root.addChild("right_leg",
            ModelPartBuilder.create().uv(40, 0)
                .cuboid(-4.0F, 0.0F, -4.0F, 2, 8, 2),
            ModelTransform.of(0.0F, 20.0F, 0.0F, 0.0F, -MathHelper.PI / 4, 0.0F)
        );

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void setAngles(OganesonEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // 脚を歩行アニメーションで上下に振る
        this.leftLeg.pitch = MathHelper.cos(limbAngle) * limbDistance * 0.5F;
        this.rightLeg.pitch = MathHelper.cos(limbAngle + (float)Math.PI) * limbDistance * 0.5F;
    }
}
