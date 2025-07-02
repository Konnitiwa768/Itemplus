package com.sakalti.sakaplus.tinco.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
public class AssembledToolRenderer extends BlockEntityWithoutLevelRenderer {

    private ResourceLocation dynamicTextureId = null;
    private String cachedKey = "";

    public AssembledToolRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack matrices,
                             MultiBufferSource vertexConsumers, int light, int overlay) {

        var tag = stack.getOrCreateTag();
        String head = tag.getString("head");
        String handle = tag.getString("handle");
        String extra = tag.getString("extra");

        String currentKey = head + "_" + handle + "_" + extra;

        if (!currentKey.equals(cachedKey)) {
            var texture = ToolTextureGenerator.generate(head, handle, extra);
            if (texture != null) {
                ResourceLocation key = new ResourceLocation("tinco", "generated/" + currentKey);
                dynamicTextureId = Minecraft.getInstance().getTextureManager().register(key, texture);
                cachedKey = currentKey;
            }
        }

        if (dynamicTextureId != null) {
            VertexConsumer buffer = vertexConsumers.getBuffer(RenderType.entityCutoutNoCull(dynamicTextureId));
            // ※独自描画はここに実装が必要です。ここでは単にMinecraftの標準レンダラー呼び出しだけ。
            Minecraft.getInstance().getItemRenderer().renderStatic(stack, transformType, light, overlay, matrices, vertexConsumers, 0);
        }
    }
}
