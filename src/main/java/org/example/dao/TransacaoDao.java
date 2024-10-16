package org.example.dao;

import org.example.model.Transacao;

import java.util.List;

public interface TransacaoDao {

    void create(Transacao transacao);
//    void update(Transacao transacao);
//    void delete(int codigoTransacao);
//    Transacao findById(int codigoTransacao);
    List<Transacao> getAll();

}
