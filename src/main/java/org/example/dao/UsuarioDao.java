package org.example.dao;

import org.example.model.Usuario;

import java.util.List;

public interface UsuarioDao {

    public int create(Usuario usuario);
//    public void update(Usuario usuario);
//    public void delete(int codigoUsuario);
//    public Usuario getByCodigo(int codigoUsuario);
       public List<Usuario> getAll();
}
