package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Investimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDao {

    public void insert(Investimento investimento) {
        String sql = "INSERT INTO T_Investimento (cd_investimento, cd_usuario, dt_compra, nm_ativo, vl_preco, ds_classe, vl_taxa, dt_vencimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, investimento.getCd_investimento());
            statement.setInt(2, investimento.getCd_usuario());
            statement.setDate(3, new java.sql.Date(investimento.getDt_compra().getTime()));
            statement.setString(4, investimento.getNm_ativo());
            statement.setFloat(5, investimento.getVl_preco());
            statement.setString(6, investimento.getClasse());
            statement.setFloat(7, investimento.getVl_taxa());
            statement.setDate(8, new java.sql.Date(investimento.getDt_vencimento().getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir investimento: " + e.getMessage());
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


    public List<Investimento> getAll() {
        String sql = "SELECT * FROM T_Investimento";
        List<Investimento> investimentos = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Investimento investimento = new Investimento(
                        resultSet.getInt("cd_investimento"),
                        resultSet.getInt("cd_usuario"),
                        resultSet.getDate("dt_compra"),
                        resultSet.getString("nm_ativo"),
                        resultSet.getFloat("vl_preco"),
                        resultSet.getString("ds_classe"),
                        resultSet.getFloat("vl_taxa"),
                        resultSet.getDate("dt_vencimento")
                );
                investimentos.add(investimento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar investimentos: " + e.getMessage());
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

        return investimentos;
    }
}
