package com.jay.db.simple.domain;

public class Usuario {
    private int idUsuario;
    private String userName;
    private String password;

    public Usuario() {
    }

    public Usuario(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Usuario(int idUsuario, String userName, String password) {
        this.idUsuario = idUsuario;
        this.userName = userName;
        this.password = password;
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return idUsuario + " "  +userName + " " + password;
    }

    
}
