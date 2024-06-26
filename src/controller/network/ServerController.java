/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.network;

import view.ServerView;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Kharis
 */
public class ServerController {
    private final ServerView view;
    private final List<ClientHandler> clients;
    private ServerSocket serverSocket;

    public ServerController(ServerView view) {
        this.view = view;
        this.clients = new ArrayList<>();
        startServer();
    }

    public void sendMessage(String message, boolean fromServer) {
        String prefix = fromServer ? "Kasir: " : "Pelanggan: ";
        for (ClientHandler client : clients) {
            client.sendMessage(prefix + message); 
        }
        view.appendMessage(prefix + message); 
    }
    
    private void startServer() {
        try {
            serverSocket = new ServerSocket(1201);
            view.appendMessage("Server started on port 1201.");

            new Thread(() -> {
                while (true) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        ClientHandler client = new ClientHandler(clientSocket, this);
                        clients.add(client);
                        view.appendMessage("New client connected: " + clientSocket.getInetAddress().getHostAddress());
                        client.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Failed to start server: " + e.getMessage());
        }
    }

    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
        view.appendMessage("Client disconnected: " + client.getSocket().getInetAddress().getHostAddress());
    }
}
