package com.sakalti.sakaplus.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static final StatusEffect LIGHT_BLOCK = new LightBlockEffect();
    public static final StatusEffect PARALYZE = new ParalyzeEffect();
    public static final StatusEffect MUDO = new MudoStatusEffect();

    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "light_block"), LIGHT_BLOCK);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "paralyze"), PARALYZE);
        Registry.register(Registry.STATUS_EFFECT, new Identifier("sakaplus", "mudo"), MUDO);
    }
}
