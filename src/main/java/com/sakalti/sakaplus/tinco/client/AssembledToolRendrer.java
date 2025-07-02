package com.sakalti.sakaplus.tinco.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class AssembledToolRenderer extends BlockEntityWithoutLevelRenderer {
    private ResourceLocation textureRL = null;
    private String lastKey = "";

    public AssembledToolRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType type, PoseStack ms,
                             MultiBufferSource buffers, int light, int overlay) {
        var tag = stack.getOrCreateTag();
        String head = tag.getString("head"), handle = tag.getString("handle"), extra = tag.getString("extra");
        String key = head + "_" + handle + "_" + extra;

        if (!key.equals(lastKey)) {
            var tex = ToolTextureGenerator.generate(head, handle, extra);
            if (tex != null) {
                textureRL = Minecraft.getInstance().getTextureManager().register("tinco/generated/" + key, tex);
                lastKey = key;
            }
        }

        if (textureRL != null) {
            var buf = buffers.getBuffer(RenderType.entityCutout(textureRL));
            Minecraft.getInstance().getItemRenderer().renderModel(ms, buf, null, stack, light, OverlayTexture.NO_OVERLAY);
        }
    }
}
