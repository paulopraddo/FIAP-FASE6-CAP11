package org.example.dao.impl;

import org.example.dao.PatrimonioDao;
import org.example.factory.ConnectionFactory;
import org.example.model.Patrimonio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatrimonioDaoImpl implements PatrimonioDao {

    Connection connection = null;
    PreparedStatement statement = null;

    @Override
    public void create(Patrimonio patrimonio) {
        String sql = "INSERT INTO T_Patrimonio (cd_patrimonio, cd_usuario, nm_patrimonio, vl_patrimonio) " +
                "VALUES (SEQ_PATRIMONIO.NEXTVAL, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, patrimonio.getCodigoUsuario());
            statement.setString(2, patrimonio.getNomePatrimonio());
            statement.setFloat(3, patrimonio.getValorPatrimonio());

            statement.executeUpdate();
            System.out.println("Patrimônio inserido com sucesso!");

            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir patrimonio no banco de dados." + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar PreparedStatement." + e.getMessage());
            }
            ConnectionFactory.closeConnection(connection);
        }
    }

    @Override
    public List<Patrimonio> getAll() {
        String sql = "SELECT * FROM T_Patrimonio ORDER BY cd_patrimonio DESC";
        List<Patrimonio> patrimonios = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
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
            System.err.println("Erro ao listar patrimônios." + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar Statement/ResultSet." + e.getMessage());
            }
            ConnectionFactory.closeConnection(connection);
        }

        return patrimonios;
    }
}
