package com.sakalti.sakaplus.registry.gemstone;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModGemstoneItems {
    public static final ArmorMaterial GEMSTONE_ARMOR_MATERIAL = new GemstoneArmorMaterial();

    public static final Item GEMSTONE_HELMET = Util.register("gemstone_helmet",
        new ArmorItem(GEMSTONE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()));
    public static final Item GEMSTONE_CHESTPLATE = Util.register("gemstone_chestplate",
        new ArmorItem(GEMSTONE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()));
    public static final Item GEMSTONE_LEGGINGS = Util.register("gemstone_leggings",
        new ArmorItem(GEMSTONE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()));
    public static final Item GEMSTONE_BOOTS = Util.register("gemstone_boots",
        new ArmorItem(GEMSTONE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()));

    public static final ToolMaterial GEMSTONE_TOOL_MATERIAL = new ToolMaterial() {
        @Override
        public int getDurability() { return 1100; }

        @Override
        public float getMiningSpeedMultiplier() { return 8.0f; }

        @Override
        public float getAttackDamage() { return 4.0f; }

        @Override
        public int getMiningLevel() { return 3; } // ダイヤと同等

        @Override
        public int getEnchantability() { return 20; }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.LAPIS_LAZULI, Items.DIAMOND);
        }
    };

    public static final Item GEMSTONE_SWORD = Util.register("gemstone_sword",
        new SwordItem(GEMSTONE_TOOL_MATERIAL, 5, -2.4f, new Item.Settings())); // 4 + 5 = 攻撃力9
}
