package com.sakalti.sakaplus.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static final StatusEffect LIGHT_BLOCK = new LightBlockEffect();
    public static final StatusEffect PARALYZE = new ParalyzeEffect();
    public static final StatusEffect MUDO = new MudoStatusEffect();
    public static final StatusEffect ADAPT = new AdaptEffect();

    // バニラのエフェクト
    public static final StatusEffect[] VANILLA = {
        StatusEffect.SPEED,
        StatusEffect.SLOWNESS,
        StatusEffect.HASTE,
        StatusEffect.MINING_FATIGUE,
        StatusEffect.STRENGTH,
        StatusEffect.INSTANT_HEALTH,
        StatusEffect.INSTANT_DAMAGE,
        StatusEffect.JUMP_BOOST,
        StatusEffect.NAUSEA,
        StatusEffect.REGENERATION,
        StatusEffect.RESISTANCE,
        StatusEffect.FIRE_RESISTANCE,
        StatusEffect.WATER_BREATHING,
        StatusEffect.INVISIBILITY,
        StatusEffect.BLINDNESS,
        StatusEffect.NIGHT_VISION,
        StatusEffect.HUNGER,
        StatusEffect.WEAKNESS,
        StatusEffect.POISON,
        StatusEffect.WITHER,
        StatusEffect.HEALTH_BOOST,
        StatusEffect.ABSORPTION,
        StatusEffect.SATURATION,
        StatusEffect.GLOWING,
        StatusEffect.LEVITATION,
        StatusEffect.LUCK,
        StatusEffect.UNLUCK,
        StatusEffect.SLOW_FALLING,
        StatusEffect.CONDUIT_POWER,
        StatusEffect.DOLPHINS_GRACE,
        StatusEffect.BAD_OMEN,
        StatusEffect.HERO_OF_THE_VILLAGE,
        StatusEffect.DARKNESS
    };

    public static final StatusEffect[] ALL = {
        MUDO, LIGHT_BLOCK, ADAPT, PARALYZE,
        StatusEffect.SPEED,
        StatusEffect.SLOWNESS,
        StatusEffect.HASTE,
        StatusEffect.MINING_FATIGUE,
        StatusEffect.STRENGTH,
        StatusEffect.INSTANT_HEALTH,
        StatusEffect.INSTANT_DAMAGE,
        StatusEffect.JUMP_BOOST,
        StatusEffect.NAUSEA,
        StatusEffect.REGENERATION,
        StatusEffect.RESISTANCE,
        StatusEffect.FIRE_RESISTANCE,
        StatusEffect.WATER_BREATHING,
        StatusEffect.INVISIBILITY,
        StatusEffect.BLINDNESS,
        StatusEffect.NIGHT_VISION,
        StatusEffect.HUNGER,
        StatusEffect.WEAKNESS,
        StatusEffect.POISON,
        StatusEffect.WITHER,
        StatusEffect.HEALTH_BOOST,
        StatusEffect.ABSORPTION,
        StatusEffect.SATURATION,
        StatusEffect.GLOWING,
        StatusEffect.LEVITATION,
        StatusEffect.LUCK,
        StatusEffect.UNLUCK,
        StatusEffect.SLOW_FALLING,
        StatusEffect.CONDUIT_POWER,
        StatusEffect.DOLPHINS_GRACE,
        StatusEffect.BAD_OMEN,
        StatusEffect.HERO_OF_THE_VILLAGE,
        StatusEffect.DARKNESS
    };
    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "light_block"), LIGHT_BLOCK);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "paralyze"), PARALYZE);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "adapt"), ADAPT);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "mudo"), MUDO);
    }
}
