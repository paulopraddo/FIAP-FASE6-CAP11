package org.example.dao.impl;

import org.example.dao.TransacaoDao;
import org.example.factory.ConnectionFactory;
import org.example.model.Transacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDaoImpl implements TransacaoDao {

    Connection connection = null;
    PreparedStatement statement = null;

    @Override
    public void create(Transacao transacao) {
        String sql = "INSERT INTO T_Transacao (cd_transacao, cd_usuario, nm_transacao, vl_transacao, ds_categoria, ds_tipo, dt_transacao) " +
                "VALUES (SEQ_TRANSACAO.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, transacao.getCodigoUsuario());
            statement.setString(2, transacao.getNomeTransacao());
            statement.setFloat(3, transacao.getValorTransacao());
            statement.setString(4, transacao.getCategoria());
            statement.setString(5, transacao.getTipo());
            statement.setDate(6, new java.sql.Date(transacao.getDataTransacao().getTime()));

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir transação no banco de dados: " + e.getMessage());
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
    public List<Transacao> getAll() {
        String sql = "SELECT * FROM T_Transacao ORDER BY cd_transacao ASC";
        List<Transacao> transacoes = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Transacao transacao = new Transacao(
                        resultSet.getInt("cd_transacao"),
                        resultSet.getInt("cd_usuario"),
                        resultSet.getString("nm_transacao"),
                        resultSet.getFloat("vl_transacao"),
                        resultSet.getString("ds_categoria"),
                        resultSet.getString("ds_tipo"),
                        resultSet.getDate("dt_transacao")
                );
                transacoes.add(transacao);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar as transações." + e.getMessage());
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

        return transacoes;
    }
}
