// src/main/java/com/sakalti/sakaplus/registry/LongtimePotionRegistry.java
package com.sakalti.sakaplus.registry;

import com.sakalti.sakaplus.potion.LongtimePotionItem;
import com.sakalti.sakaplus.effect.ModEffects;

import net.minecraft.potion.Potion;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class LongtimePotionRegistry {
    public static void registerAll() {
        for (StatusEffect effect : ModEffects.ALL) {
            int duration = 9999; // 効果時間2倍の例
            Potion potion = new Potion(new StatusEffectInstance(effect, duration));
            String name = effect.getTranslationKey().replace("effect.", "") + "_longtime";
            Identifier id = new Identifier("sakaplus", name);

            Registry.register(Registry.POTION, id, potion);
            Registry.register(Registry.ITEM, id,
                new LongtimePotionItem(new Item.Settings().maxCount(7).group(ItemGroup.BREWING))
            );
        }
    }
}
