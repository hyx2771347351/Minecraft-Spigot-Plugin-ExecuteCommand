package io.github.hyx2771347351;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ExecuteCommandFromSocket extends JavaPlugin {
    private SocketListener thread;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.getCommand("commandexecutor").setExecutor(new CommandExectorCommand(this));
        Plugin config = io.github.hyx2771347351.ExecuteCommandFromSocket.getProvidingPlugin(io.github.hyx2771347351.ExecuteCommandFromSocket.class);
        try {
            thread = new SocketListener(config.getConfig().getInt("port"));
//            thread.run();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        getLogger().info("Listener is running on " + config.getConfig().getInt("port"));
    }
    @Override
    public void onDisable() {
        thread.interrupt();
        getLogger().info("Listener interrupt");
    }
}
