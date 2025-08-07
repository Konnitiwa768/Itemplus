// src/main/java/com/sakalti/sakaplus/potion/LongtimePotionItem.java
package com.sakalti.sakaplus.potion;

import net.minecraft.item.PotionItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

public class LongtimePotionItem extends PotionItem {
    public LongtimePotionItem(Item.Settings settings) {
        super(settings);
    }
    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 50; // 50tick
    }
}
