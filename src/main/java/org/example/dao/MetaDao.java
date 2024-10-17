package org.example.dao;

import org.example.model.Login;
import org.example.model.Meta;

import java.util.List;

public interface MetaDao {

    void create(Meta meta);
//    void update(Meta meta);
//    void delete(int codigoMeta);
//    Meta getByCodigo(int codigoMeta);
    List<Meta> getAll();
}
