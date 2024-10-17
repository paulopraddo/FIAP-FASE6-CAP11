package org.example.dao.impl;

import org.example.dao.LoginDao;
import org.example.factory.ConnectionFactory;
import org.example.model.Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDaoImpl implements LoginDao {

    Connection connection = null;
    PreparedStatement statement = null;

    @Override
    public void create(Login login) {
        String sql = "INSERT INTO T_Login (cd_login, cd_usuario, dt_login) " +
                "VALUES (SEQ_LOGIN.NEXTVAL, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, login.getCodigoUsuario());
            statement.setDate(2, new Date(login.getDataLogin().getTime()));

            statement.executeUpdate();
            System.out.println("Dados do login inserido com sucesso!");

            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir login no banco de dados." + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage());
            }
            ConnectionFactory.closeConnection(connection);
        }
    }

    @Override
    public List<Login> getAll() {
        String sql = "SELECT * FROM T_Login ORDER BY cd_login DESC";
        List<Login> logins = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Login login = new Login(
                        resultSet.getString("cd_login"),
                        resultSet.getInt("cd_usuario"),
                        resultSet.getDate("dt_login")
                );
                logins.add(login);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar os logins" + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar Statement/ResultSet" + e.getMessage());
            }
            ConnectionFactory.closeConnection(connection);
        }

        return logins;
    }

}
