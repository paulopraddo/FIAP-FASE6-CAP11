package org.example.dao;

import org.example.model.Login;

import java.util.List;

public interface LoginDao {

    void create(Login login);
//    boolean autenticar(String cd_usuario, String senha);
//    void delete(int codigoUsuario);
//    Login getByCodigo(int codigoUsuario);
    public List<Login> getAll();

}
