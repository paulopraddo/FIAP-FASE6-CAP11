package org.example.model;

import java.util.Date;

public class Login {
    private String login;  // PK
    private Integer codigoUsuario;  // F
    private Date dtLogin;

    public Login(String login, Integer codigoUsuario, Date dtLogin) {
        this.login = login;
        this.codigoUsuario = codigoUsuario;
        this.dtLogin = dtLogin;
    }

    // Getters e Setters
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

    public Date getDtLogin() {
        return dtLogin;
    }

    public void setDtLogin(Date dtLogin) {
        this.dtLogin = dtLogin;
    }
}
