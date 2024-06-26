/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import view.ClientView;
/**
 *
 * @author Kharis
 */
public class ServerListener extends Thread {
    private final Socket socket;
    private final ClientView view;
    private final DataInputStream dis;

    public ServerListener(Socket socket, ClientView view) throws IOException {
        this.socket = socket;
        this.view = view;
        dis = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = dis.readUTF()) != null) {
                view.appendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
