package org.example.model;

import java.util.Date;

public class Login {

    private String login;
    private Integer codigoUsuario;
    private Date dateLogin;

    public Login(String login, Integer codigoUsuario, Date dateLogin) {
        this.login = login;
        this.codigoUsuario = codigoUsuario;
        this.dateLogin = dateLogin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Date getDataLogin() {
        return dateLogin;
    }

    public void setDateLogin(Date dateLogin) {
        this.dateLogin = dateLogin;
    }

    @Override
    public String toString() {
        return "Login {" +
                "cd_login='" + login + '\'' +
                ", cd_usuario=" + codigoUsuario + '\'' +
                ", dt_login=" + dateLogin +
                '}';
    }

}

