/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.Koneksi;
import model.MenuModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kharis
 */
public class MenuController {
    private final Connection conn;

    public MenuController() {
        this.conn = Koneksi.connectDB();
    }

    public void insertMenu(MenuModel menu) throws SQLException {
        String sql = "INSERT INTO menu (nama_menu, harga, status) VALUES (?, ?, ?)";
        try (PreparedStatement stat = conn.prepareStatement(sql)) {
            stat.setString(1, menu.getNama_menu());
            stat.setInt(2, menu.getHarga());
            stat.setString(3, menu.getStatus());
            stat.executeUpdate();
        }
    }

    public void updateMenu(MenuModel menu) throws SQLException {
        String sql = "UPDATE menu SET nama_menu=?, harga=?, status=? WHERE id_menu=?";
        try (PreparedStatement stat = conn.prepareStatement(sql)) {
            stat.setString(1, menu.getNama_menu());
            stat.setInt(2, menu.getHarga());
            stat.setString(3, menu.getStatus());
            stat.setInt(4, menu.getId_menu());
            stat.executeUpdate();
        }
    }

    public void deleteMenu(int id_menu) throws SQLException {
        String sql = "DELETE FROM menu WHERE id_menu=?";
        try (PreparedStatement stat = conn.prepareStatement(sql)) {
            stat.setInt(1, id_menu);
            stat.executeUpdate();
        }
    }

    public DefaultTableModel getMenuTableModel() throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Menu");
        model.addColumn("Nama Menu");
        model.addColumn("Harga");
        model.addColumn("Status Menu");

        String sql = "SELECT * FROM menu";
        try (PreparedStatement stat = conn.prepareStatement(sql); ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                Object[] data = {
                        rs.getInt("id_menu"),
                        rs.getString("nama_menu"),
                        rs.getInt("harga"),
                        rs.getString("status")
                };
                model.addRow(data);
            }
        }
        return model;
    }
}
