package com.sakalti.sakaplus.registry.abyssalite;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundEvent;

public class AbyssaliteArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = {13, 15, 16, 11}; // boots, leggings, chestplate, helmet
    private static final int[] PROTECTION = {4, 5, 6, 3}; // boots, leggings, chestplate, helmet

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getEquipmentSlot().getEntitySlotId()] * 44; // ネザライト(37)より少し高い
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION[type.getEquipmentSlot().getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModAbyssaliteItems.ABYSSALITE_INGOT);
    }

    @Override
    public String getName() {
        return "abyssalite";
    }

    @Override
    public float getToughness() {
        return 2.5f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1f;
    }
}
