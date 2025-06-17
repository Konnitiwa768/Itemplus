package com.sakalti.sakaplus.item;

import net.minecraft.item.SwordItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.util.ActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.Rarity;
import net.minecraft.item.ToolMaterials;
import net.minecraft.entity.Entity;

public class LightningStinger extends SwordItem {

    public LightningStinger() {
        super(new ToolMaterial() {
            @Override public int getDurability() { return 1985; }
            @Override public float getMiningSpeedMultiplier() { return 9.0F; }
            @Override public float getAttackDamage() { return 14.5F - ToolMaterials.NETHERITE.getAttackDamage(); } // relative boost
            @Override public int getMiningLevel() { return ToolMaterials.NETHERITE.getMiningLevel(); }
            @Override public int getEnchantability() { return 15; }
            @Override public Ingredient getRepairIngredient() {
                return Ingredient.ofItems(Items.NETHERITE_INGOT);
            }
        }, 3, -2.4F, new Item.Settings().rarity(Rarity.EPIC).maxCount(1).maxDamage(1985));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(10);
        stack.damage(1, attacker, e -> e.sendToolBreakStatus(attacker.getActiveHand()));
        return true;
    }

    @Override
    public boolean isFireproof() {
        return true;
    }
}
