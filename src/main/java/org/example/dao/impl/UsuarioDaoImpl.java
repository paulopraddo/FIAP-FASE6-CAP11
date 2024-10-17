package org.example.dao.impl;

import org.example.dao.UsuarioDao;
import org.example.factory.ConnectionFactory;
import org.example.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {

    PreparedStatement statement = null;
    Connection connection = null;

    @Override
    public void create(Usuario usuario) {
        String sql = "INSERT INTO T_Usuario (cd_usuario, nm_nome, ds_email, tx_imagem, nr_celular, tx_senha, dt_criacao) " +
                "VALUES (seq_usuario.nextval, ?, ?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getImagem());
            statement.setString(4, usuario.getCelular());
            statement.setString(5, usuario.getSenha());
            statement.setDate(6, new Date(usuario.getDataCriacao().getTime()));

            statement.executeUpdate();
            System.out.println("Usuário inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário no banco de dados." + e.getMessage());
        }
    }

    @Override
    public List<Usuario> getAll() {
        String sql = "SELECT * FROM T_Usuario ORDER BY nm_name DESC";
        List<Usuario> usuarios = new ArrayList<>();
        connection = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("cd_usuario"),
                        resultSet.getString("nm_nome"),
                        resultSet.getString("ds_email"),
                        resultSet.getString("tx_imagem"),
                        resultSet.getString("nr_celular"),
                        resultSet.getString("tx_senha"),
                        resultSet.getDate("dt_criacao")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar os investimentos: " + e.getMessage());
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar Statement/ResultSet: " + e.getMessage());
            }
            ConnectionFactory.closeConnection(connection);
        }

        return usuarios;
    }
}
