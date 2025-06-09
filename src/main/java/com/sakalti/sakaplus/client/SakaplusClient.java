import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.sakalti.sakaplus.client.model.ScorcherModel;
import com.sakalti.sakaplus.client.renderer.ScorcherRenderer;
import net.fabricmc.api.ClientModInitializer;

public class SakaplusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SCORCHER, ScorcherRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ScorcherRenderer.MODEL_LAYER, ScorcherModel::getTexturedModelData);
    }
}
