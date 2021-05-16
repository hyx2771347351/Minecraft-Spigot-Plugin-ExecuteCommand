package io.github.hyx2771347351;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.net.ServerSocket;
import java.net.Socket;

public final class ReceiveAndExecuteCommandEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private Socket SocketHandler;
    public ReceiveAndExecuteCommandEvent(Socket socket) {
        SocketHandler = socket;
    }
    public Socket getSocketHandler() {
        return SocketHandler;
    }
    public void closeSocketHandler() {
        try {
            SocketHandler.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean isCancelled() {
        return cancelled;
    }
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
