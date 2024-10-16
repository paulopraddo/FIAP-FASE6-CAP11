package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Meta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetaDao {

    public void insert(Meta meta) {
        String sql = "INSERT INTO T_Meta (cd_meta, cd_usuario, nm_meta, vl_meta, vl_popular) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, meta.getCd_metas());
            statement.setInt(2, meta.getCodigoUsuario());
            statement.setString(3, meta.getNomeMeta());
            statement.setFloat(4, meta.getVl_meta());
            statement.setFloat(5, meta.getVl_popular());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir meta: " + e.getMessage());
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

    public List<Meta> getAll() {
        String sql = "SELECT * FROM T_Meta";
        List<Meta> metas = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Meta meta = new Meta(
                        resultSet.getInt("cd_meta"),
                        resultSet.getInt("cd_usuario"),
                        resultSet.getString("nm_meta"),
                        resultSet.getFloat("vl_meta"),
                        resultSet.getFloat("vl_popular")
                );
                metas.add(meta);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar metas: " + e.getMessage());
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

        return metas;
    }
}
