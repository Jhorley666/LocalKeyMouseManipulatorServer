package com.bibavix.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {
    int port = 8082;

    ServerSocket serverSocket;
    Socket clientSocket;

    boolean serverStatus;

    public ServerController() {
        serverSocket = null;
        clientSocket = null;
        serverStatus = false;
    }

    public boolean startServer() {
        try {
            serverSocket = new ServerSocket(this.port);

            return Boolean.TRUE;

        } catch (IOException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public Boolean stopServer() {
        try {
            Boolean statusServer = Boolean.FALSE;
            if (clientSocket != null) {
                clientSocket.close();
                statusServer = Boolean.TRUE;
            }
            if (serverSocket != null) {
                serverSocket.close();
                statusServer = Boolean.TRUE;
            }
            return statusServer;
        } catch (IOException e) {
            return Boolean.FALSE;
        }
    }

    public void acceptConnections(){
        Runnable runnable = () -> {

                try {
                    clientSocket = serverSocket.accept();
                    BufferedReader in = null;
                    if (clientSocket.isConnected()){
                        System.out.println("Client connected: " + clientSocket.getInetAddress());
                        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    }
                    while (true && clientSocket.isConnected()) {
                        String message = in.readLine();
                        System.out.println("Received from client: " + message);

                        if  (!serverStatus) break;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
        };
        Thread thread = new Thread(runnable);

        thread.start();
    }

    public boolean getServerStatus() {
        return this.serverStatus;
    }

    public void setServerStatus(boolean serverStatus) {
        this.serverStatus = serverStatus;
    }

}
