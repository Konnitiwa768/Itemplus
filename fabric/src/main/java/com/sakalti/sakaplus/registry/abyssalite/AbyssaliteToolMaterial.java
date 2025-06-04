package com.sakalti.sakaplus.registry.abyssalite;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Items;

public class AbyssaliteToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 1884;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 11.0f;
    }

    @Override
    public float getAttackDamage() {
        return 3.5f; // 剣のベース＋5.0で計8.5
    }

    @Override
    public int getMiningLevel() {
        return 4; // ネザライト相当
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModAbyssaliteItems.ABYSSALITE_INGOT);
    }
}
