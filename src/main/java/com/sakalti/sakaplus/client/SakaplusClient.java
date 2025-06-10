import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import com.sakalti.sakaplus.client.model.ScorcherModel;
import com.sakalti.sakaplus.client.model.OganesonModel;
import com.sakalti.sakaplus.client.model.NyankoModel;
import com.sakalti.sakaplus.registry.ModEntities;
import com.sakalti.sakaplus.entity.ScorcherEntity;
import com.sakalti.sakaplus.client.renderer.ScorcherRenderer;
import com.sakalti.sakaplus.entity.NyankoEntity;
import com.sakalti.sakaplus.client.renderer.NyankoRenderer;
import com.sakalti.sakaplus.entity.OganesonEntity;
import com.sakalti.sakaplus.client.renderer.OganesonRenderer;
import net.fabricmc.api.ClientModInitializer;

public class SakaplusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SCORCHER, ScorcherRenderer::new);
        EntityRendererRegistry.register(ModEntities.NYANKO, NyankoRenderer::new);
        EntityRendererRegistry.register(ModEntities.OGANESON, OganesonRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ScorcherRenderer.MODEL_LAYER, ScorcherModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(NyankoRenderer.MODEL_LAYER, NyankoModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(OganesonRenderer.MODEL_LAYER, OganesonModel::getTexturedModelData);
    }
}
