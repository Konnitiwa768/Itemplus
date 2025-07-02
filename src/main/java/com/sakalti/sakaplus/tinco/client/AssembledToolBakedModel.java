package com.sakalti.sakaplus.tinco.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.block.model.ItemOverride;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Environment(EnvType.CLIENT)
public class AssembledToolBakedModel implements BakedModel {
    private final TextureAtlasSprite defaultSprite;

    public AssembledToolBakedModel() {
        defaultSprite = Minecraft.getInstance()
            .getTextureAtlas(TextureMap.LOCATION_BLOCKS)
            .apply(new ResourceLocation("tinco:item/assembled_tool_default"));
    }

    @Override public List<BakedQuad> getQuads(net.minecraft.world.level.block.state.BlockState state, Direction side, Random rand) {
        return Collections.emptyList();
    }
    @Override public boolean useAmbientOcclusion() { return true; }
    @Override public boolean isGui3d() { return true; }
    @Override public boolean usesBlockLight() { return false; }
    @Override public boolean isCustomRenderer() { return true; }
    @Override public TextureAtlasSprite getParticleIcon() { return defaultSprite; }
    @Override public ItemTransforms getTransforms() { return ItemTransforms.NO_TRANSFORMS; }
    @Override public List<ItemOverride> getOverrides() { return Collections.emptyList(); }
}
