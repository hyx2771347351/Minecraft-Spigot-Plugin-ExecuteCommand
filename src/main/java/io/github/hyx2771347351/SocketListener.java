package io.github.hyx2771347351;

import org.bukkit.Bukkit;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class SocketListener extends Thread{
    private ServerSocket serverSocket;
    public SocketListener(int ReceivePort) {
        try {
            serverSocket = new ServerSocket(ReceivePort);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void run() {
        super.run();
        Socket socket = new Socket();
        while (!isInterrupted()) {
            try {
                socket = serverSocket.accept();
                ReceiveAndExecuteCommandEvent event = new ReceiveAndExecuteCommandEvent(socket);
                Bukkit.getServer().getPluginManager().callEvent(event);
            } catch (SocketException socketException) {
                socketException.printStackTrace();
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
