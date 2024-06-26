/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.Koneksi;
import javax.swing.JOptionPane;
import model.MenuModel;
import model.Transaksi;

/**
 *
 * @author Kharis
 */
public class TransaksiController {
    private final Connection conn;

    public TransaksiController() {
        conn = Koneksi.connectDB();
    }

    public List<MenuModel> getAllMenu() throws SQLException {
        List<MenuModel> menuList = new ArrayList<>();
        String query = "SELECT * FROM menu WHERE status='Tersedia'";
        PreparedStatement stat = conn.prepareStatement(query);
        ResultSet rs = stat.executeQuery();

        while (rs.next()) {
            MenuModel menu = new MenuModel();
            menu.setId_menu(rs.getInt("id_menu"));
            menu.setNama_menu(rs.getString("nama_menu"));
            menu.setHarga(rs.getInt("harga"));
            menuList.add(menu);
        }
        return menuList;
    }

    public void insertTransaksi(Transaksi transaksi) throws SQLException {
        String query = "INSERT INTO transaksi (nama_pelanggan, id_menu, tanggal, nama_menu, harga, jumlah_beli, total_bayar) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, transaksi.getNama_pelanggan());
            stmt.setInt(2, transaksi.getId_menu());
            stmt.setString(3, transaksi.getTanggal());
            stmt.setString(4, transaksi.getNama_menu());
            stmt.setInt(5, transaksi.getHarga());
            stmt.setInt(6, transaksi.getJumlah_beli());
            stmt.setInt(7, transaksi.getTotal_bayar());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Transaksi added successfully");
            }
        }
    }

    public void updateTransaksi(Transaksi transaksi) throws SQLException {
        String query = "UPDATE transaksi SET nama_pelanggan=?, id_menu=?, tanggal=?, nama_menu=?, harga=?, jumlah_beli=?, total_bayar=? "
                + "WHERE id_transaksi=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, transaksi.getNama_pelanggan());
            stmt.setInt(2, transaksi.getId_menu());
            stmt.setString(3, transaksi.getTanggal());
            stmt.setString(4, transaksi.getNama_menu());
            stmt.setInt(5, transaksi.getHarga());
            stmt.setInt(6, transaksi.getJumlah_beli());
            stmt.setInt(7, transaksi.getTotal_bayar());
            stmt.setInt(8, transaksi.getId_transaksi());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Transaksi updated successfully");
            }
        }
    }

    public void deleteTransaksi(int id_transaksi) throws SQLException {
        String query = "DELETE FROM transaksi WHERE id_transaksi=?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_transaksi);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Transaksi deleted successfully");
            }
        }
    }

    public List<Transaksi> getAllTransaksi() throws SQLException {
        List<Transaksi> transaksiList = new ArrayList<>();
        String query = "SELECT * FROM transaksi";
        try (PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setId_transaksi(rs.getInt("id_transaksi"));
                transaksi.setNama_pelanggan(rs.getString("nama_pelanggan"));
                transaksi.setId_menu(rs.getInt("id_menu"));
                transaksi.setTanggal(rs.getString("tanggal"));
                transaksi.setNama_menu(rs.getString("nama_menu"));
                transaksi.setHarga(rs.getInt("harga"));
                transaksi.setJumlah_beli(rs.getInt("jumlah_beli"));
                transaksi.setTotal_bayar(rs.getInt("total_bayar"));
                transaksiList.add(transaksi);
            }
        }
        return transaksiList;
    }
}
