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
import view.ClientView;
/**
 *
 * @author Kharis
 */
public class ClientController  {
    private final ClientView view;
    private DataOutputStream dout;

    public ClientController(ClientView view) {
        this.view = view;
    }

    public void connectToServer() {
        try {
            Socket s = new Socket("127.0.0.1", 1201);
            dout = new DataOutputStream(s.getOutputStream());

            new Thread(() -> {
                try {
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    String message;
                    while ((message = dis.readUTF()) != null) {
                        view.appendMessage(message); 
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(view, "Gagal menerima pesan: " + e.getMessage());
                }
            }).start();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Gagal terhubung ke server: " + e.getMessage());
        }
    }

    public void sendMessage(String message) {
        try {
            dout.writeUTF(message);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Gagal mengirim pesan: " + e.getMessage());
        }
    }
}
