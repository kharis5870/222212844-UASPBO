/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Kharis
 */
public class ClientHandler extends Thread{
    private final Socket socket;
    private final ServerController serverController;
    private DataInputStream dis;
    private DataOutputStream dout;

    public ClientHandler(Socket socket, ServerController serverController) {
        this.socket = socket;
        this.serverController = serverController;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = dis.readUTF()) != null) {
                serverController.sendMessage(message, false); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
                dout.close();
                socket.close();
                serverController.removeClient(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        try {
            dout.writeUTF(message);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengirim pesan ke client: " + e.getMessage());
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
