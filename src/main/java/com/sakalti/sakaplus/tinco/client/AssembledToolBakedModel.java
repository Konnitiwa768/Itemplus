package com.sakalti.sakaplus.tinco.client;

import com.sakalti.sakaplus.tinco.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.List;

@Environment(EnvType.CLIENT)
public class AssembledToolBakedModel implements BakedModel {

    private final SpriteAtlasTexture atlas;
    private final Sprite defaultSprite;

    public AssembledToolBakedModel() {
        this.atlas = MinecraftClient.getInstance().getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
        this.defaultSprite = atlas.getSprite(new Identifier("tinco", "item/assembled_tool_default"));
    }

    @Override
    public List<BakedQuad> getQuads(...) {
        return List.of(); // 実際の描画はOverrideで処理
    }

    @Override
    public Sprite getParticleSprite() {
        return defaultSprite;
    }

    @Override
    public boolean isBuiltin() {
        return true;
    }
}
