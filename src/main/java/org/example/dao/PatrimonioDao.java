package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Patrimonio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatrimonioDao {

    public void insert(Patrimonio patrimonio) {
        String sql = "INSERT INTO T_Patrimonio (cd_patrimonio, cd_usuario, nm_patrimonio, vl_patrimonio) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, patrimonio.getCodigoPatrimonio());
            statement.setInt(2, patrimonio.getCodigoUsuario());
            statement.setString(3, patrimonio.getNomePatrimonio());
            statement.setFloat(4, patrimonio.getValorPatrimonio());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir patrimonio: " + e.getMessage());
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

    public List<Patrimonio> getAll() {
        String sql = "SELECT * FROM T_Patrimonio";
        List<Patrimonio> patrimonios = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Patrimonio patrimonio = new Patrimonio(
                        resultSet.getInt("cd_patrimonio"),
                        resultSet.getInt("cd_usuario"),
                        resultSet.getString("nm_patrimonio"),
                        resultSet.getFloat("vl_patrimonio")
                );
                patrimonios.add(patrimonio);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar patrimonios: " + e.getMessage());
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

        return patrimonios;
    }
}
