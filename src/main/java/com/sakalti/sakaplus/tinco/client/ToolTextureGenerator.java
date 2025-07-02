package com.sakalti.sakaplus.tinco.client;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;

public class ToolTextureGenerator {

    public static DynamicTexture generate(String head, String handle, String extra) {
        try {
            NativeImage base = load("item/" + handle + "_handle");
            NativeImage headImg = load("item/" + head + "_head");
            NativeImage extraImg = load("item/" + extra + "_extra");

            overlay(base, headImg);
            overlay(base, extraImg);

            return new DynamicTexture(base);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static NativeImage load(String path) throws IOException {
        ResourceLocation res = new ResourceLocation("sakaplus", "textures/" + path + ".png");
        return NativeImage.read(Minecraft.getInstance().getResourceManager().open(res));
    }

    private static void overlay(NativeImage base, NativeImage overlay) {
        if (base.getWidth() != overlay.getWidth() || base.getHeight() != overlay.getHeight()) {
            throw new IllegalStateException("Texture sizes differ!");
        }
        for (int y = 0; y < base.getHeight(); y++) {
            for (int x = 0; x < base.getWidth(); x++) {
                int col = overlay.getPixelRGBA(x, y);
                if ((col >> 24 & 0xFF) > 0) base.setPixelRGBA(x, y, col);
            }
        }
    }
}
