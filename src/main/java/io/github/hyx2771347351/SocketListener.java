package io.github.hyx2771347351;

import org.bukkit.Bukkit;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketListener extends Thread{
    private ServerSocket serverSocket;
    public SocketListener(int ReceivePort) {
        try {
            serverSocket = new ServerSocket(ReceivePort);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        Socket socket = new Socket();
        while (true) {
            try {
                socket = serverSocket.accept();
                ReceiveAndExecuteCommandEvent event = new ReceiveAndExecuteCommandEvent(socket);
                Bukkit.getServer().getPluginManager().callEvent(event);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
