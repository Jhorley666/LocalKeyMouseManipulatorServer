package com.bibavix.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {
    int port = 8082;
    public ServerController(){
    }

    public void init(){
        try (ServerSocket serverSocket = new ServerSocket(this.port)){
            System.out.println("Server started on port" + port);
            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message = in.readLine();
                System.out.println("Received from client: " + message);

                // Process the received message
                String response = "Hello, Client!";

                // Send the response back to the client
                out.println(response);
                System.out.println("Sent to client: " + response);

                // Close the socket
                clientSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
