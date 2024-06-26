/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.Koneksi;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kharis
 */
public class RegistrasiController {
    private final Connection conn;

    public RegistrasiController() {
        this.conn = Koneksi.connectDB();
    }

    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();
        try {
            String query = "SELECT * FROM user";
            PreparedStatement stat = conn.prepareStatement(query);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                UserModel user = new UserModel(
                        rs.getInt("id_user"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nama_user"),
                        rs.getInt("id_level")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat mengambil data: " + e.getMessage());
        }
        return users;
    }

    public void insertUser(UserModel user) {
        try {
            String query = "INSERT INTO user (username, password, nama_user, id_level) VALUES (?, ?, ?, ?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, user.getUsername());
            stat.setString(2, user.getPassword());
            stat.setString(3, user.getNama_user());
            stat.setInt(4, user.getId_level());
            stat.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat menyimpan data: " + e.getMessage());
        }
    }

    public void updateUser(UserModel user) {
        try {
            String query = "UPDATE user SET username=?, password=?, nama_user=?, id_level=? WHERE id_user=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, user.getUsername());
            stat.setString(2, user.getPassword());
            stat.setString(3, user.getNama_user());
            stat.setInt(4, user.getId_level());
            stat.setInt(5, user.getId_user());
            stat.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat memperbarui data: " + e.getMessage());
        }
    }

    public void deleteUser(int id_user) {
        try {
            String query = "DELETE FROM user WHERE id_user=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, id_user);
            stat.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kesalahan saat menghapus data: " + e.getMessage());
        }
    }
}
