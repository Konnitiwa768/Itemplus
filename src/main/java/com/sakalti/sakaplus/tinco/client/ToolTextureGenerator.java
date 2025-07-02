package com.sakalti.sakaplus.tinco.client;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.util.Optional;

public class ToolTextureGenerator {

    public static DynamicTexture generate(String head, String handle, String extra) {
        try {
            NativeImage base = load("item/" + handle.toLowerCase() + "_handle");
            NativeImage headImg = load("item/" + head.toLowerCase() + "_head");
            NativeImage extraImg = load("item/" + extra.toLowerCase() + "_extra");

            overlay(base, headImg);
            overlay(base, extraImg);

            return new DynamicTexture(base);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static NativeImage load(String path) throws IOException {
        ResourceLocation res = new ResourceLocation("tinco", "textures/" + path + ".png");
        Optional<NativeImage> image = NativeImage.readToOptional(Minecraft.getInstance().getResourceManager().open(res));
        if (image.isPresent()) {
            return image.get();
        } else {
            throw new IOException("Texture not found: " + res);
        }
    }

    private static void overlay(NativeImage base, NativeImage overlay) {
        for (int y = 0; y < base.getHeight(); y++) {
            for (int x = 0; x < base.getWidth(); x++) {
                int color = overlay.getPixelRGBA(x, y);
                if ((color >> 24 & 0xFF) > 0) {
                    base.setPixelRGBA(x, y, color);
                }
            }
        }
    }
}
