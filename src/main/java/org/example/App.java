package org.example;

import org.example.dao.InvestimentoDao;
import org.example.dao.LoginDao;
import org.example.dao.MetaDao;
import org.example.dao.PatrimonioDao;
import org.example.dao.TransacaoDao;
import org.example.model.Investimento;
import org.example.model.Login;
import org.example.model.Meta;
import org.example.model.Patrimonio;
import org.example.model.Transacao;

import java.util.Date;
import java.util.Calendar;

public class App {

    public static void main(String[] args) {
        InvestimentoDao investimentoDao = new InvestimentoDao();
        LoginDao loginDao = new LoginDao();
        MetaDao metaDao = new MetaDao();
        PatrimonioDao patrimonioDao = new PatrimonioDao();
        TransacaoDao transacaoDao = new TransacaoDao();

        Calendar calendar = Calendar.getInstance();

        System.out.println("Inserindo novos registros...");

        for (int i = 1; i <= 5; i++) {
            calendar.set(2023, Calendar.JANUARY, 10 + i);
            Date dataCompra = calendar.getTime();
            calendar.set(2025, Calendar.JANUARY, 10 + i);
            Date dataVencimento = calendar.getTime();

            Investimento investimento = new Investimento(
                    1000 + i,
                    200 + i,
                    dataCompra,
                    "Ativo " + (100 + i),
                    1000.0f + (i * 50),
                    "Classe " + i,
                    0.2f + (i * 0.05f),
                    dataVencimento
            );
            investimentoDao.insert(investimento);

            Login login = new Login(
                    "user" + (200 + i),
                    300 + i,
                    new Date()
            );
            loginDao.insert(login);

            Meta meta = new Meta(
                    400 + i,
                    500 + i,
                    "Meta " + (i * 10),
                    10000.0f + (i * 1000),
                    5000.0f + (i * 500)
            );
            metaDao.insert(meta);

            Patrimonio patrimonio = new Patrimonio(
                    600 + i,
                    700 + i,
                    "Patrimônio " + (i + 5),
                    30000.0f + (i * 3000)
            );
            patrimonioDao.insert(patrimonio);

            Transacao transacao = new Transacao(
                    800 + i,
                    900 + i,
                    "Transação " + (i * 20),
                    200.0f + (i * 25),
                    "Categoria " + i,
                    (i % 2 == 0) ? "Despesa" : "Receita",
                    new Date()
            );
            transacaoDao.insert(transacao);
        }

        System.out.println("\nRecuperando os registros cadastrados...");

        System.out.println("Lista de Investimentos:");
        investimentoDao.getAll().forEach(System.out::println);

        System.out.println("\nLista de Logins:");
        loginDao.getAll().forEach(System.out::println);

        System.out.println("\nLista de Metas:");
        metaDao.getAll().forEach(System.out::println);

        System.out.println("\nLista de Patrimônios:");
        patrimonioDao.getAll().forEach(System.out::println);

        System.out.println("\nLista de Transações:");
        transacaoDao.getAll().forEach(System.out::println);
    }
}
