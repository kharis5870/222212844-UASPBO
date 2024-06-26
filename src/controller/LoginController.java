/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.Koneksi;
import model.UserModel;
import view.LoginView;
import view.MenuRegistrasiView;
import view.MenuTransaksiView;
import view.MenuKantinView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kharis
 */
public class LoginController {
    private final LoginView view;
    private final Connection conn;
    private PreparedStatement stat;
    private ResultSet rs;

    public LoginController(LoginView view) {
        this.view = view;
        conn = Koneksi.connectDB(); 
    }

    public void authenticateUser() {
        UserModel user = new UserModel();
        user.setUsername(view.getUsername());
        user.setPassword(view.getPassword());

        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            stat = conn.prepareStatement(query);
            stat.setString(1, user.getUsername());
            stat.setString(2, user.getPassword());
            rs = stat.executeQuery();
            if (rs.next()) { 
                user.setId_level(rs.getInt("id_level"));
                switch (user.getId_level()) {
                    case 1:
                        MenuRegistrasiView regView = new MenuRegistrasiView();
                        regView.setVisible(true);
                        view.setVisible(false);
                        break;
                    case 2:
                        MenuTransaksiView tranView = new MenuTransaksiView();
                        tranView.setVisible(true);
                        view.setVisible(false);
                        break;
                    case 3:
                        MenuKantinView kantinView = new MenuKantinView();
                        kantinView.setVisible(true);
                        view.setVisible(false);
                        kantinView.btn_chat.setEnabled(true);
                        break;
                    default:
                        view.showErrorMessage("AKUN TIDAK DITEMUKAN");
                        break;
                }
            } else {
                view.showErrorMessage("AKUN TIDAK DITEMUKAN");
            }
        } catch (SQLException e) {
            view.showErrorMessage("Connection Failed: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stat != null) stat.close();
            } catch (SQLException ex) {
                view.showErrorMessage("Error closing resources: " + ex.getMessage());
            }
        }
    }
}
