package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {

    public void insert(Login login) {
        String sql = "INSERT INTO T_Login (login, cd_usuario, dt_login) VALUES (?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, login.getLogin());
            statement.setInt(2, login.getCodigoUsuario());
            statement.setDate(3, new java.sql.Date(login.getDtLogin().getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir login: " + e.getMessage());
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

    public List<Login> getAll() {
        String sql = "SELECT * FROM T_Login";
        List<Login> logins = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Login login = new Login(
                        resultSet.getString("login"),
                        resultSet.getInt("cd_usuario"),
                        resultSet.getDate("dt_login")
                );
                logins.add(login);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar logins: " + e.getMessage());
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

        return logins;
    }
}
