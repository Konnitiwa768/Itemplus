package com.sakalti.sakaplus.effect;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.lwjgl.opengl.GL11;

public class LightBlockOverlay implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {
            MinecraftClient client = MinecraftClient.getInstance();
            if (client.player != null && client.player.hasStatusEffect(ModEffects.LIGHT_BLOCK)) {
                drawWhiteOverlay(matrices, client);
            }
        });
    }

    private void drawWhiteOverlay(MatrixStack matrices, MinecraftClient client) {
        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();

        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 0.93f); // 0.93 = 93%不透明
        fill(matrices, 0, 0, width, height, 0xFFFFFFFF); // 完全白

        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.disableBlend();
        RenderSystem.enableTexture();
    }

    // Fabricでの矩形描画（MatrixStack対応）
    private void fill(MatrixStack matrices, int x1, int y1, int x2, int y2, int color) {
        float a = (float)(color >> 24 & 255) / 255.0F;
        float r = (float)(color >> 16 & 255) / 255.0F;
        float g = (float)(color >> 8 & 255) / 255.0F;
        float b = (float)(color & 255) / 255.0F;

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        BufferBuilder buffer = Tessellator.getInstance().getBuffer();
        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        buffer.vertex(x1, y2, 0.0D).color(r, g, b, a).next();
        buffer.vertex(x2, y2, 0.0D).color(r, g, b, a).next();
        buffer.vertex(x2, y1, 0.0D).color(r, g, b, a).next();
        buffer.vertex(x1, y1, 0.0D).color(r, g, b, a).next();
        BufferRenderer.drawWithShader(buffer.end());
    }
}
