package com.sakalti.sakaplus.tinco.client;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;

public class ToolTextureGenerator {

    public static DynamicTexture generateToolTexture(String head, String handle, String extra) {
        try {
            ResourceLocation headTex = new ResourceLocation("tinco:textures/item/" + head.toLowerCase() + "_head.png");
            ResourceLocation handleTex = new ResourceLocation("tinco:textures/item/" + handle.toLowerCase() + "_handle.png");
            ResourceLocation extraTex = new ResourceLocation("tinco:textures/item/" + extra.toLowerCase() + "_extra.png");

            NativeImage base = loadImage(handleTex);
            NativeImage headImg = loadImage(headTex);
            NativeImage extraImg = loadImage(extraTex);

            overlayImage(base, headImg);
            overlayImage(base, extraImg);

            return new DynamicTexture(base);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static NativeImage loadImage(ResourceLocation location) throws IOException {
        return NativeImage.read(Minecraft.getInstance().getResourceManager().open(location));
    }

    private static void overlayImage(NativeImage base, NativeImage overlay) {
        for (int x = 0; x < base.getWidth(); x++) {
            for (int y = 0; y < base.getHeight(); y++) {
                int color = overlay.getPixelRGBA(x, y);
                if ((color >> 24) != 0) { // 透明ピクセル無視
                    base.setPixelRGBA(x, y, color);
                }
            }
        }
    }
}
