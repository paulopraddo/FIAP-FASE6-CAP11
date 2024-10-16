package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Transacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDao {

    public void insert(Transacao transacao) {
        String sql = "INSERT INTO T_Transacao (cd_transacao, cd_usuario, nm_transacao, vl_transacao, ds_categoria, ds_tipo, dt_transacao) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, transacao.getCodigoTransacao());
            statement.setInt(2, transacao.getCodigoUsuario());
            statement.setString(3, transacao.getNomeTransacao());
            statement.setFloat(4, transacao.getValorTransacao());
            statement.setString(5, transacao.getCategoria());
            statement.setString(6, transacao.getTipo());
            statement.setDate(7, new java.sql.Date(transacao.getDataTransacao().getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir transacao: " + e.getMessage());
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

    public List<Transacao> getAll() {
        String sql = "SELECT * FROM T_Transacao";
        List<Transacao> transacoes = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

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
            System.err.println("Erro ao recuperar transacoes: " + e.getMessage());
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

        return transacoes;
    }
}
