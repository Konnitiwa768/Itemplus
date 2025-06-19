import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import com.sakalti.sakaplus.client.model.*;
import com.sakalti.sakaplus.registry.ModEntities333;
import com.sakalti.sakaplus.client.renderer.*;
import com.sakalti.sakaplus.entity.*;
import net.fabricmc.api.ClientModInitializer;

public class SakaplusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities333.SCORCHER, ScorcherRenderer::new);
        EntityRendererRegistry.register(ModEntities333.KULOOGIE, KuloogieRenderer::new);
        EntityRendererRegistry.register(ModEntities333.KUR_BRUTE, KurBruteRenderer::new);
        EntityRendererRegistry.register(ModEntities333.WARPERDUN, WarperdunRenderer::new);
        EntityRendererRegistry.register(ModEntities333.NYANKO, NyankoRenderer::new);
        EntityRendererRegistry.register(ModEntities333.BATTLE_NYANKO, BattleNyankoRenderer::new);
        EntityRendererRegistry.register(ModEntities333.OGANESON, OganesonRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ScorcherRenderer.MODEL_LAYER, ScorcherModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(KuloogieRenderer.MODEL_LAYER, KuloogieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(KurBruteRenderer.MODEL_LAYER, KurBruteModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(WarperdunRenderer.MODEL_LAYER, WarperdunModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(NyankoRenderer.MODEL_LAYER, NyankoModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(BattleNyankoRenderer.MODEL_LAYER, BattleNyankoModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(OganesonRenderer.MODEL_LAYER, OganesonModel::getTexturedModelData);
    }
}
