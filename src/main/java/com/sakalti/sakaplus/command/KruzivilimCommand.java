package com.sakalti.sakaplus.command;

import com.mojang.brigadier.CommandDispatcher;
import com.sakalti.sakaplus.dimension.SakaplusDimensions;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class KruzivilimCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("kruzivilim")
            .then(CommandManager.literal("iku")
                .executes(ctx -> teleport(ctx.getSource(), true)))
            .then(CommandManager.literal("modoru")
                .executes(ctx -> teleport(ctx.getSource(), false)))
        );
    }

    private static int teleport(ServerCommandSource source, boolean toKruzivilim) {
        ServerPlayerEntity player = source.getPlayer();
        if (player == null) {
            source.sendError(Text.of("§cこのコマンドはプレイヤー専用です。"));
            return 0;
        }

        // 必要な金インゴットの数
        int required = 28;
        int goldCount = countItems(player, Items.GOLD_INGOT);
        if (goldCount < required) {
            player.sendMessage(Text.of("§c金インゴットが28個必要です。現在: " + goldCount + "個"), false);
            return 0;
        }

        // 消費処理
        removeItems(player, Items.GOLD_INGOT, required);

        ServerWorld targetWorld = player.getServer().getWorld(
            toKruzivilim ? SakaplusDimensions.KRUZIVILIM_DIMENSION_KEY : World.OVERWORLD
        );
        if (targetWorld == null) {
            player.sendMessage(Text.of("§cテレポート先ワールドが見つかりません。"), false);
            return 0;
        }

        BlockPos pos = player.getBlockPos();
        player.teleport(targetWorld, pos.getX(), pos.getY(), pos.getZ(), player.getYaw(), player.getPitch());
        player.sendMessage(Text.of(toKruzivilim ? "§6クルジヴィリムへ移動しました。" : "§6元の世界に戻りました。"), false);
        return 1;
    }

    private static int countItems(ServerPlayerEntity player, net.minecraft.item.Item item) {
        return player.getInventory().main.stream()
            .filter(stack -> stack != null && stack.getItem() == item)
            .mapToInt(stack -> stack.getCount())
            .sum();
    }

    private static void removeItems(ServerPlayerEntity player, net.minecraft.item.Item item, int amount) {
        int remaining = amount;
        for (int i = 0; i < player.getInventory().main.size(); i++) {
            var stack = player.getInventory().main.get(i);
            if (stack != null && stack.getItem() == item) {
                int take = Math.min(stack.getCount(), remaining);
                stack.decrement(take);
                remaining -= take;
                if (remaining <= 0) break;
            }
        }
    }
}
