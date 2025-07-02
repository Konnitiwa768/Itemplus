package com.sakalti.sakaplus.tinco.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;

@Environment(EnvType.CLIENT)
public class AssembledToolRenderer extends BlockEntityWithoutLevelRenderer {

    private ResourceLocation dynamicLocation = null;

    public AssembledToolRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack matrices,
                             MultiBufferSource vertexConsumers, int light, int overlay) {

        String head = stack.getOrCreateTag().getString("head");
        String handle = stack.getOrCreateTag().getString("handle");
        String extra = stack.getOrCreateTag().getString("extra");

        if (dynamicLocation == null) {
            var texture = ToolTextureGenerator.generateToolTexture(head, handle, extra);
            if (texture != null) {
                dynamicLocation = Minecraft.getInstance().getTextureManager().register("tinco:assembled_tool_" + head + handle + extra, texture);
            }
        }

        if (dynamicLocation != null) {
            var buffer = vertexConsumers.getBuffer(RenderType.entityCutout(dynamicLocation));
            Minecraft.getInstance().getItemRenderer().renderModel(matrices, buffer, null, stack, light, OverlayTexture.NO_OVERLAY);
        }
    }
}
