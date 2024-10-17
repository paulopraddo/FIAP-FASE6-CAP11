package org.example.dao;

import org.example.model.Patrimonio;

import java.util.List;

public interface PatrimonioDao {

    void create(Patrimonio patrimonio);
//    void update(Patrimonio patrimonio);
//    void delete(int codigoPatrimonio);
//    Patrimonio findById(int codigoPatrimonio);
    List<Patrimonio> getAll();


}
