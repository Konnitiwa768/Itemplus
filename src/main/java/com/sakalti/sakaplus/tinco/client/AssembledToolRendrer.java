package com.sakalti.sakaplus.tinco.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
public class AssembledToolRenderer {

    /**
     * GUI描画内などでツールを表現する矩形と模様を描く
     */
    public void render(GuiGraphics graphics, ItemStack stack, int x, int y) {
        var tag = stack.getOrCreateTag();
        String head = tag.getString("head");
        String handle = tag.getString("handle");
        String extra = tag.getString("extra");

        String headMat = parseMaterial(head);
        String handleMat = parseMaterial(handle);
        String extraMat = parseMaterial(extra);

        int headColor = ToolColorGenerator.getColor(headMat);
        int handleColor = ToolColorGenerator.getColor(handleMat);
        int extraColor = ToolColorGenerator.getColor(extraMat);

        // 背景として handle の斜め線模様 (8px間隔)
        drawDiagonalPattern(graphics, x, y, 16, handleColor, 8);

        // 上から head の斜め線模様 (4px間隔)
        drawDiagonalPattern(graphics, x, y, 16, headColor, 4);

        // 中央に extra の 2x2 四角
        graphics.fill(x + 7, y + 7, x + 9, y + 9, extraColor);
    }

    private void drawDiagonalPattern(GuiGraphics graphics, int x, int y, int size, int color, int spacing) {
        for (int offset = 0; offset < size; offset += spacing) {
            for (int i = 0; i < size; i++) {
                int px = x + i;
                int py = y + (i + offset) % size;
                if (px < x + size && py < y + size) {
                    graphics.fill(px, py, px + 1, py + 1, color);
                }
            }
        }
    }

    private String parseMaterial(String partStr) {
        if (partStr == null) return "";
        String lower = partStr.toLowerCase();
        if (lower.endsWith("_handle")) return lower.substring(0, lower.length() - 7);
        if (lower.endsWith("_head")) return lower.substring(0, lower.length() - 5);
        if (lower.endsWith("_extra")) return lower.substring(0, lower.length() - 6);
        return lower;
    }
}
