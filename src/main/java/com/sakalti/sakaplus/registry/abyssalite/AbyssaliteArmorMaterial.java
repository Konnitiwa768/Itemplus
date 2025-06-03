package com.sakalti.sakaplus.registry.abyssalite;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class AbyssaliteArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = {13, 15, 16, 11}; // HELMET, CHEST, LEGS, BOOTS
    private static final int[] PROTECTION = {3, 6, 5, 4}; // HELMET, CHEST, LEGS, BOOTS

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId() - 2] * 44; // slot IDs: HEAD=5, CHEST=6, LEGS=7, FEET=8
    }

    @Override
    public int getProtection(EquipmentSlot slot) {
        return PROTECTION[slot.getEntitySlotId() - 2];
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
