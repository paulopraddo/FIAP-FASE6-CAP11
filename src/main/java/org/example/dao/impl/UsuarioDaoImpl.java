package org.example.dao.impl;

import org.example.dao.UsuarioDao;
import org.example.factory.ConnectionFactory;
import org.example.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {

    Connection connection = null;
    PreparedStatement statement = null;

    @Override
    public int create(Usuario usuario) {
        String sql = "INSERT INTO T_Usuario (cd_usuario, nm_nome, ds_email, tx_imagem, nr_celular, tx_senha, dt_criacao) " +
                "VALUES (seq_usuario.nextval, ?, ?, ?, ?, ?, ?)";
        int generatedId = 0;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql, new String[]{"cd_usuario"});

            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getImagem() != null ? usuario.getImagem() : null);
            statement.setString(4, usuario.getCelular());
            statement.setString(5, usuario.getSenha());
            statement.setDate(6, new Date(usuario.getDataCriacao().getTime()));

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário no banco de dados." + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection);
        }

        return generatedId;

    }

    @Override
    public List<Usuario> getAll() {
        String sql = "SELECT * FROM T_Usuario ORDER BY cd_usuario ASC";
        List<Usuario> usuarios = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("cd_usuario"),
                        resultSet.getString("nm_nome"),
                        resultSet.getString("ds_email"),
                        null,
//                        resultSet.getString("tx_imagem"),
                        resultSet.getString("nr_celular"),
                        resultSet.getString("tx_senha"),
                        resultSet.getDate("dt_criacao")
                );
                usuarios.add(usuario);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao listar os usuários." + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection);
        }

        return usuarios;
    }

}
