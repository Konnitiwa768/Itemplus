package com.sakalti.sakaplus.effect;
   
import net.minecraft.entity.effect.StatusEffects; // 追加
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static final StatusEffect LIGHT_BLOCK = new LightBlockEffect();
    public static final StatusEffect PARALYZE = new ParalyzeEffect();
    public static final StatusEffect MUDO = new MudoStatusEffect();
    public static final StatusEffect ADAPT = new AdaptEffect();

    // バニラのエフェクト
    public static final StatusEffect[] VANILLA = {
        StatusEffects.SPEED,
        StatusEffects.SLOWNESS,
        StatusEffects.HASTE,
        StatusEffects.MINING_FATIGUE,
        StatusEffects.STRENGTH,
        StatusEffects.INSTANT_HEALTH,
        StatusEffects.INSTANT_DAMAGE,
        StatusEffects.JUMP_BOOST,
        StatusEffects.NAUSEA,
        StatusEffects.REGENERATION,
        StatusEffects.RESISTANCE,
        StatusEffects.FIRE_RESISTANCE,
        StatusEffects.WATER_BREATHING,
        StatusEffects.INVISIBILITY,
        StatusEffects.BLINDNESS,
        StatusEffects.NIGHT_VISION,
        StatusEffects.HUNGER,
        StatusEffects.WEAKNESS,
        StatusEffects.POISON,
        StatusEffects.WITHER,
        StatusEffects.HEALTH_BOOST,
        StatusEffects.ABSORPTION,
        StatusEffects.SATURATION,
        StatusEffects.GLOWING,
        StatusEffects.LEVITATION,
        StatusEffects.LUCK,
        StatusEffects.UNLUCK,
        StatusEffects.SLOW_FALLING,
        StatusEffects.CONDUIT_POWER,
        StatusEffects.DOLPHINS_GRACE,
        StatusEffects.BAD_OMEN,
        StatusEffects.HERO_OF_THE_VILLAGE,
        StatusEffects.DARKNESS
    };

    public static final StatusEffect[] ALL = {
        MUDO, LIGHT_BLOCK, ADAPT, PARALYZE,
        StatusEffects.SPEED,
        StatusEffects.SLOWNESS,
        StatusEffects.HASTE,
        StatusEffects.MINING_FATIGUE,
        StatusEffects.STRENGTH,
        StatusEffects.INSTANT_HEALTH,
        StatusEffects.INSTANT_DAMAGE,
        StatusEffects.JUMP_BOOST,
        StatusEffects.NAUSEA,
        StatusEffects.REGENERATION,
        StatusEffects.RESISTANCE,
        StatusEffects.FIRE_RESISTANCE,
        StatusEffects.WATER_BREATHING,
        StatusEffects.INVISIBILITY,
        StatusEffects.BLINDNESS,
        StatusEffects.NIGHT_VISION,
        StatusEffects.HUNGER,
        StatusEffects.WEAKNESS,
        StatusEffects.POISON,
        StatusEffects.WITHER,
        StatusEffects.HEALTH_BOOST,
        StatusEffects.ABSORPTION,
        StatusEffects.SATURATION,
        StatusEffects.GLOWING,
        StatusEffects.LEVITATION,
        StatusEffects.LUCK,
        StatusEffects.UNLUCK,
        StatusEffects.SLOW_FALLING,
        StatusEffects.CONDUIT_POWER,
        StatusEffects.DOLPHINS_GRACE,
        StatusEffects.BAD_OMEN,
        StatusEffects.HERO_OF_THE_VILLAGE,
        StatusEffects.DARKNESS
    };
    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "light_block"), LIGHT_BLOCK);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "paralyze"), PARALYZE);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "adapt"), ADAPT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "mudo"), MUDO);
    }
}
