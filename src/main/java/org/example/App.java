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
                    3000 + i,
                    3000 + i,
                    dataCompra,
                    "Ativo " + (100 + i),
                    1000.0f + (i * 50),
                    "Classe " + i,
                    0.2f + (i * 0.05f),
                    dataVencimento
            );
            investimentoDao.insert(investimento);
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
