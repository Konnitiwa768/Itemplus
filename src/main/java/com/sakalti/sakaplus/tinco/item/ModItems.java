package com.sakalti.sakaplus.tinco.item;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.*;

public class ModItems {

    public static final Item ASSEMBLED_TOOL = new AssembledToolItem();

    // 素材データ
    private static final Map<String, MaterialData> HEADS = new HashMap<>();
    private static final Map<String, MaterialData> HANDLES = new HashMap<>();
    private static final Map<String, MaterialData> EXTRAS = new HashMap<>();

    public static void register() {

        // 素材定義
        HEADS.put("iron", new MaterialData(250, 2.0f, 6.0f, 2, List.of("reinforced")));
        HEADS.put("diamond", new MaterialData(1561, 3.0f, 8.0f, 3, List.of("sharp")));
        HEADS.put("netherite", new MaterialData(2031, 4.0f, 9.0f, 4, List.of("reinforced", "sharp")));
        HEADS.put("hachilite", new MaterialData(800, 2.5f, 7.5f, 3, List.of("lightweight")));

        HANDLES.put("iron", new MaterialData(1.0f, 0.0f, 0.0f, 0, List.of()));
        HANDLES.put("diamond", new MaterialData(1.1f, 0.5f, 0.0f, 0, List.of("sharp")));
        HANDLES.put("netherite", new MaterialData(1.2f, 1.0f, 0.0f, 0, List.of("reinforced")));
        HANDLES.put("hachilite", new MaterialData(1.15f, 0.3f, 0.0f, 0, List.of("lightweight")));

        EXTRAS.put("iron", new MaterialData(50, 0.0f, 0.0f, 0, List.of()));
        EXTRAS.put("diamond", new MaterialData(100, 0.0f, 0.0f, 0, List.of("sharp")));
        EXTRAS.put("netherite", new MaterialData(150, 0.0f, 0.0f, 0, List.of("reinforced")));
        EXTRAS.put("hachilite", new MaterialData(75, 0.0f, 0.0f, 0, List.of("lightweight")));

        // 登録
        Registry.register(Registry.ITEM, new Identifier(TincoMod.MOD_ID, "assembled_tool"), ASSEMBLED_TOOL);

        // reinforced 耐久軽減
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            ItemStack stack = player.getMainHandStack();
            if (stack.getItem() instanceof AssembledToolItem tool && tool.hasTrait(stack, "reinforced")) {
                if (world.random.nextFloat() < 0.5f) return false;
            }
            return true;
        });

        // sharp 追加ダメージ
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            ItemStack stack = player.getMainHandStack();
            if (stack.getItem() instanceof AssembledToolItem tool && tool.hasTrait(stack, "sharp")) {
                if (entity instanceof LivingEntity target) {
                    target.damage(DamageSource.player(player), 2.0f);
                }
            }
            return ActionResult.PASS;
        });
    }

    // 材料データ
    public static class MaterialData {
        public final float durabilityFactor;
        public final float attackBonus;
        public final float miningSpeed;
        public final int miningLevel;
        public final List<String> traits;

        public MaterialData(float durabilityFactor, float attackBonus, float miningSpeed, int miningLevel, List<String> traits) {
            this.durabilityFactor = durabilityFactor;
            this.attackBonus = attackBonus;
            this.miningSpeed = miningSpeed;
            this.miningLevel = miningLevel;
            this.traits = traits;
        }
    }

    // 組み立てツール
    public static class AssembledToolItem extends Item {

        public AssembledToolItem() {
            super(new Settings().maxCount(1));
        }

        private static final String TAG_HEAD = "Head";
        private static final String TAG_HANDLE = "Handle";
        private static final String TAG_EXTRA = "Extra";

        public static void setComposition(ItemStack stack, String head, String handle, String extra) {
            NbtCompound nbt = stack.getOrCreateNbt();
            nbt.putString(TAG_HEAD, head);
            nbt.putString(TAG_HANDLE, handle);
            nbt.putString(TAG_EXTRA, extra);
        }

        private MaterialData getHead(ItemStack stack) {
            return HEADS.get(stack.getOrCreateNbt().getString(TAG_HEAD));
        }

        private MaterialData getHandle(ItemStack stack) {
            return HANDLES.get(stack.getOrCreateNbt().getString(TAG_HANDLE));
        }

        private MaterialData getExtra(ItemStack stack) {
            return EXTRAS.get(stack.getOrCreateNbt().getString(TAG_EXTRA));
        }

        public List<String> getAllTraits(ItemStack stack) {
            List<String> traits = new ArrayList<>();
            traits.addAll(getHead(stack).traits);
            traits.addAll(getHandle(stack).traits);
            traits.addAll(getExtra(stack).traits);
            return traits;
        }

        public boolean hasTrait(ItemStack stack, String trait) {
            return getAllTraits(stack).contains(trait);
        }

        public float getAttackDamage(ItemStack stack) {
            float base = getHead(stack).attackBonus + getHandle(stack).attackBonus;
            if (hasTrait(stack, "sharp")) base += 2.0f;
            return base;
        }

        public float getMiningSpeed(ItemStack stack) {
            float speed = getHead(stack).miningSpeed;
            if (hasTrait(stack, "lightweight")) speed *= 1.2f;
            return speed;
        }

        public int getDurability(ItemStack stack) {
            return (int) (getHead(stack).durabilityFactor * getHandle(stack).durabilityFactor) + (int) getExtra(stack).durabilityFactor;
        }

        @Override
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            stack.damage(1, attacker, e -> e.sendToolBreakStatus(attacker.getActiveHand()));
            return super.postHit(stack, target, attacker);
        }

        @Override
        public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("耐久値: " + getDurability(stack)));
            tooltip.add(Text.literal("攻撃: " + getAttackDamage(stack)));
            tooltip.add(Text.literal("マイニングスピード: " + getMiningSpeed(stack)));
            tooltip.add(Text.literal("能力: " + String.join(", ", getAllTraits(stack))));
        }
    }
}
