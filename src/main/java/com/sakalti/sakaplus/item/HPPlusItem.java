package com.sakalti.sakaplus.item;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.UUID;

public class HPPlusItem extends Item {

    public HPPlusItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && user instanceof ServerPlayerEntity serverPlayer) {
            var attrInstance = serverPlayer.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

            if (attrInstance != null) {
                // UUIDをランダムに生成して重複適用可能に
                UUID uniqueId = UUID.randomUUID();
                EntityAttributeModifier modifier = new EntityAttributeModifier(
                        uniqueId,
                        "hp_plus_bonus",
                        2.0,
                        EntityAttributeModifier.Operation.ADDITION
                );

                attrInstance.addPersistentModifier(modifier);
                serverPlayer.sendMessage(Text.literal("最大HPが恒久的に +2 されました。"), true);

                // アイテムを1つ消費
                user.getStackInHand(hand).decrement(1);
            }
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
