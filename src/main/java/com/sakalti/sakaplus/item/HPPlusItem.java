package com.sakalti.sakaplus.item;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.UUID;

public class HPPlusItem extends Item {

    // 固定UUID（プレイヤーにユニークなHP増加を追加するために動的に生成しない）
    public static final UUID HP_BONUS_UUID = UUID.fromString("9f1f8711-a839-4dc0-943e-c731b2ea92a6");

    public HPPlusItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        return ActionResult.PASS;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, net.minecraft.util.Hand hand) {
        if (!world.isClient && user instanceof ServerPlayerEntity serverPlayer) {
            // 既に同じUUIDの修正があるか確認
            boolean alreadyHasModifier = serverPlayer.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)
                .getModifiers()
                .stream()
                .anyMatch(mod -> mod.getId().equals(HP_BONUS_UUID));

            if (!alreadyHasModifier) {
                // 最大HP +2 を追加（恒久的）
                EntityAttributeModifier modifier = new EntityAttributeModifier(
                    HP_BONUS_UUID,
                    "hp_plus_bonus",
                    2.0,
                    EntityAttributeModifier.Operation.ADDITION
                );
                serverPlayer.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addPersistentModifier(modifier);
                serverPlayer.sendMessage(Text.literal("最大HPが恒久的に +2 されました。"), true);

                // アイテムを1個消費
                user.getStackInHand(hand).decrement(1);
            } else {
                serverPlayer.sendMessage(Text.literal("このアイテムの効果はすでに適用されています。"), true);
            }
        }
        return ActionResult.SUCCESS;
    }
}
