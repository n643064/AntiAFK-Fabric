package n6430.aafk;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.Optional;
import java.util.Random;


public class AntiAfk {
    public static KeyBinding AKey;
    public static boolean AAFK = false;
    public static Random random = new Random();
    public static int r;


    public static void register()
    {

        AKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.aafk.t",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                "category.n6430"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null)
            {
                if (AKey.wasPressed())
                {
                    AAFK = !AAFK;
                    if (AAFK) {
                        client.player.sendMessage(Text.of("AntiAFK - ON"), true);
                    } else {
                        client.player.sendMessage(Text.of("AntiAFK - OFF"), true);
                        client.options.keyRight.setPressed(false);
                        client.options.keyLeft.setPressed(false);
                        client.options.keyForward.setPressed(false);
                        client.options.keyBack.setPressed(false);
                        client.options.keySneak.setPressed(false);
                    }
                }
                if (AAFK)
                {
                    client.options.keyRight.setPressed(false);
                    client.options.keyLeft.setPressed(false);
                    client.options.keyForward.setPressed(false);
                    client.options.keyBack.setPressed(false);
                    client.player.setSprinting(random.nextBoolean());
                    client.options.keySneak.setPressed(random.nextBoolean());
                    r = random.nextInt(3);
                    switch (r) {
                        case 0: client.options.keyRight.setPressed(true); break;
                        case 1: client.options.keyLeft.setPressed(true); break;
                        case 2: client.options.keyBack.setPressed(true); break;
                        case 3: client.options.keyForward.setPressed(true); break;
                    }
                }

            }
    });
}
}

