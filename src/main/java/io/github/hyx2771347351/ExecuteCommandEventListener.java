package io.github.hyx2771347351;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.*;

public final class ExecuteCommandEventListener implements Listener {
    @EventHandler
    public void ExecuteCommandFromSocket(ReceiveAndExecuteCommandEvent event) {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            inputStream = event.getSocketHandler().getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            outputStream = event.getSocketHandler().getOutputStream();
            printWriter = new PrintWriter(outputStream);

            printWriter.write("Command Executor is not enable");
            printWriter.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
                if (bufferedReader != null)
                    bufferedReader.close();
                if (outputStream != null)
                    outputStream.close();
                if (printWriter != null)
                    printWriter.close();
                if (event.getSocketHandler() != null)
                    event.closeSocketHandler();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
