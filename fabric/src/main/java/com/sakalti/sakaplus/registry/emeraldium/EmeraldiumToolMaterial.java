package com.sakalti.sakaplus.registry.emeraldium;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Items;

public class EmeraldiumToolMaterial implements ToolMaterial {
    @Override public int getDurability() { return 1900; }
    @Override public float getMiningSpeedMultiplier() { return 14.0f; }
    @Override public float getAttackDamage() { return 4.0f; }
    @Override public int getMiningLevel() { return 4; }
    @Override public int getEnchantability() { return 15; }
    @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.EMERALD); }
}
