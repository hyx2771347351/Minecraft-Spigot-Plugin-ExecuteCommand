package io.github.hyx2771347351;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ExecuteCommandFromSocket extends JavaPlugin {
    private SocketListener thread;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        Plugin config = io.github.hyx2771347351.ExecuteCommandFromSocket.getProvidingPlugin(io.github.hyx2771347351.ExecuteCommandFromSocket.class);
        try {
            thread = new SocketListener(config.getConfig().getInt("port"));
            thread.run();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Listener is running on " + config.getConfig().getInt("port"));
    }
    @Override
    public void onDisable() {
        thread.stop();
        System.out.println("Listener stop");
    }
}
