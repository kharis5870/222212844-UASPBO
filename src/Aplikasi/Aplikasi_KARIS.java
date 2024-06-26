/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Aplikasi;

import view.LoginView;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

/**
 *
 * @author Kharis
 */
public class Aplikasi_KARIS {

    /**
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        // Menggunakan Singleton untuk mendapatkan koneksi
        FlatMacDarkLaf.setup();
        LoginView l = new LoginView();
        l.setVisible(true);
    }
}
