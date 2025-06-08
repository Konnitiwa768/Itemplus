/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1548
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package com.sakalti.sakaplus.mixin;

import net.minecraft.class_1548;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_1548.class})
public interface CreeperEntityAccessor {
    @Accessor(value="fuseTime")
    public int getFuseTime();

    @Accessor(value="currentFuseTime")
    public int getCurrentFuseTime();

    @Accessor(value="explosionRadius")
    public int getExplosionRadius();

    @Accessor(value="fuseTime")
    public void setFuseTime(int var1);

    @Accessor(value="explosionRadius")
    public void setExplosionRadius(int var1);
}
