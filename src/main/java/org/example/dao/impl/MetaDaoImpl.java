package org.example.dao.impl;

import org.example.dao.MetaDao;
import org.example.factory.ConnectionFactory;
import org.example.model.Meta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetaDaoImpl implements MetaDao {

    Connection connection = null;
    PreparedStatement statement = null;

    @Override
    public void create(Meta meta) {
        String sql = "INSERT INTO T_Meta (cd_meta, cd_usuario, nm_meta, vl_meta, vl_poupar) " +
                "VALUES (SEQ_META.NEXTVAL, ?, ?, ?, ?)";

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, meta.getCodigoUsuario());
            statement.setString(2, meta.getNomeMeta());
            statement.setFloat(3, meta.getValorMeta());
            statement.setFloat(4, meta.getValorPoupar());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir meta no banco de dados." + e.getMessage());
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
    public List<Meta> getAll() {
        String sql = "SELECT * FROM T_Meta ORDER BY cd_meta ASC";
        List<Meta> metas = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Meta meta = new Meta(
                        resultSet.getInt("cd_meta"),
                        resultSet.getInt("cd_usuario"),
                        resultSet.getString("nm_meta"),
                        resultSet.getFloat("vl_meta"),
                        resultSet.getFloat("vl_poupar")
                );
                metas.add(meta);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar as metas." + e.getMessage());
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

        return metas;
    }
}
