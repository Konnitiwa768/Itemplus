// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.mixin;

import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.class_1548;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({ class_1548.class })
public interface CreeperEntityAccessor
{
    @Accessor("fuseTime")
    int getFuseTime();
    
    @Accessor("currentFuseTime")
    int getCurrentFuseTime();
    
    @Accessor("explosionRadius")
    int getExplosionRadius();
    
    @Accessor("fuseTime")
    void setFuseTime(final int p0);
    
    @Accessor("explosionRadius")
    void setExplosionRadius(final int p0);
}
