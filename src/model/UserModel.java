/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Kharis
 */
public class UserModel {
    private int id_user, id_level;
    private String username, password, nama_user;

    public UserModel() {}

    public UserModel(int id_user, String username, String password, String nama_user, int id_level) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.nama_user = nama_user;
        this.id_level = id_level;
    }

    // Getter and setter methods
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public int getId_level() {
        return id_level;
    }

    public void setId_level(int id_level) {
        this.id_level = id_level;
    }
}
