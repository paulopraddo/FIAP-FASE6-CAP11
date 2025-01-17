package org.example.dao.impl;

import org.example.dao.InvestimentoDao;
import org.example.factory.ConnectionFactory;
import org.example.model.Investimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDaoImpl implements InvestimentoDao {

    Connection connection = null;
    PreparedStatement statement = null;

    @Override
    public void create(Investimento investimento) {
        String sql = "INSERT INTO T_Investimento (cd_investimento, cd_usuario, dt_compra, nm_ativo, vl_preco, ds_classe, vl_taxa, dt_vencimento) " +
                "VALUES (SEQ_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, investimento.getCodigoUsuario());
            statement.setDate(2, new Date(investimento.getDataCompra().getTime()));
            statement.setString(3, investimento.getNomeAtivo());
            statement.setFloat(4, investimento.getValorPreco());
            statement.setString(5, investimento.getClasse());
            statement.setFloat(6, investimento.getValorTaxa());
            statement.setDate(7, new Date(investimento.getDataVencimento().getTime()));

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir investimento no banco de dados." + e.getMessage());
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
    public List<Investimento> getAll() {
        String sql = "SELECT * FROM T_Investimento ORDER BY cd_investimento ASC";
        List<Investimento> investimentos = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

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
            System.err.println("Erro ao listar os investimentos." + e.getMessage());
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

        return investimentos;
    }

}
