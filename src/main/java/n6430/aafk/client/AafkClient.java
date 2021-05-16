package n6430.aafk.client;

import n6430.aafk.AntiAfk;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class AafkClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AntiAfk.register();
    }
}
