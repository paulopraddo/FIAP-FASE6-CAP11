package org.example.dao;

import org.example.model.Investimento;

import java.util.List;

public interface InvestimentoDao {

    void create(Investimento investimento);
//    void update(Investimento investimento);
//    void delete(int codigoInvestimento);
//    Investimento getByCodigo(int codigoInvestimento);
    List<Investimento> getAll();

}
