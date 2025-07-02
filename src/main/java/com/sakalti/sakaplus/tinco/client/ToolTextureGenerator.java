package com.sakalti.sakaplus.tinco.client;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.renderer.texture.DynamicTexture;

import java.util.HashMap;
import java.util.Map;

public class ToolTextureGenerator {

    private static final Map<String, Integer> COLOR_MAP = new HashMap<>();
    static {
        COLOR_MAP.put("hachilite", 0xFFB3E5FC);
        COLOR_MAP.put("iron", 0xFFAAAAAA);
        COLOR_MAP.put("diamond", 0xFF55FFFF);
        COLOR_MAP.put("netherite", 0xFF554433);
    }

    private static String[] parsePart(String partStr) {
        if (partStr == null) return new String[]{"", ""};
        String lower = partStr.toLowerCase();
        if (lower.endsWith("_handle")) return new String[]{lower.substring(0, lower.length() - 7), "handle"};
        if (lower.endsWith("_head")) return new String[]{lower.substring(0, lower.length() - 5), "head"};
        if (lower.endsWith("_extra")) return new String[]{lower.substring(0, lower.length() - 6), "extra"};
        return new String[]{lower, ""};
    }

    public static DynamicTexture generate(String headPart, String handlePart, String extraPart) {
        final int size = 64;
        NativeImage img = new NativeImage(size, size, true);

        for (int y = 0; y < size; y++)
            for (int x = 0; x < size; x++)
                img.setPixelRGBA(x, y, 0x00000000);

        String[] headInfo = parsePart(headPart);
        String[] handleInfo = parsePart(handlePart);
        String[] extraInfo = parsePart(extraPart);

        int headColor = COLOR_MAP.getOrDefault(headInfo[0], 0xFFFFFFFF);
        int handleColor = COLOR_MAP.getOrDefault(handleInfo[0], 0xFFFFFFFF);
        int extraColor = COLOR_MAP.getOrDefault(extraInfo[0], 0xFFFFFFFF);

        if ("handle".equals(handleInfo[1])) {
            drawDiagonalLines(img, handleColor, 8);
        }

        if ("head".equals(headInfo[1])) {
            drawDiagonalLines(img, headColor, 4);
        }

        if ("extra".equals(extraInfo[1])) {
            drawSquare(img, size / 2 - 1, size / 2 - 1, 2, extraColor);
        }

        return new DynamicTexture(img);
    }

    private static void drawDiagonalLines(NativeImage img, int color, int spacing) {
        int size = img.getWidth();
        for (int start = 0; start < size; start += spacing) {
            for (int i = 0; i < size - start; i++) {
                int x = i;
                int y = i + start;
                if (y < size && x < size) img.setPixelRGBA(x, y, color);
                if (start != 0 && y < size && x < size) img.setPixelRGBA(y, x, color);
            }
        }
    }

    private static void drawSquare(NativeImage img, int startX, int startY, int size, int color) {
        for (int y = startY; y < startY + size; y++) {
            for (int x = startX; x < startX + size; x++) {
                if (x >= 0 && y >= 0 && x < img.getWidth() && y < img.getHeight())
                    img.setPixelRGBA(x, y, color);
            }
        }
    }
}
