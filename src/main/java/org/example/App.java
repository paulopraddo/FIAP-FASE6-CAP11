package org.example;


import org.example.dao.InvestimentoDao;
import org.example.dao.LoginDao;
import org.example.dao.MetaDao;
import org.example.dao.PatrimonioDao;
import org.example.dao.TransacaoDao;
import org.example.dao.impl.*;
import org.example.model.Investimento;
import org.example.model.Login;
import org.example.model.Meta;
import org.example.model.Patrimonio;
import org.example.model.Transacao;

import java.util.Date;
import java.util.Calendar;

public class App {

    public static void main(String[] args) {
        UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
        InvestimentoDaoImpl investimentoDao = new InvestimentoDaoImpl();
        LoginDaoImpl loginDao = new LoginDaoImpl();
        MetaDaoImpl metaDao = new MetaDaoImpl();
        PatrimonioDaoImpl patrimonioDao = new PatrimonioDaoImpl();
        TransacaoDaoImpl transacaoDao = new TransacaoDaoImpl();

        Calendar calendar = Calendar.getInstance();

        System.out.println("CRIANDO NOVOS REGISTROS...");

        for (int i = 1; i <= 5; i++) {
            calendar.set(2023, Calendar.JANUARY, 10 + i);
            Date dataCompra = calendar.getTime();
            calendar.set(2025, Calendar.JANUARY, 10 + i);
            Date dataVencimento = calendar.getTime();

            Usuario usuario = new Usuario(
                    0 + i,
                    "NomeUsario" + i,
                    "EmailUsuario" + i,
                    null,
                    "99876578" + i,
                    "SenhaUsuario" + i,
                    new Date()
            );
            int usuarioId = usuarioDao.create(usuario); // Armazenar o ID do usuário gerado

            Investimento investimento = new Investimento(
                    1000 + i,
                    usuarioId,
                    dataCompra,
                    "Ativo " + (100 + i),
                    1000.0f + (i * 50),
                    "Classe " + i,
                    0.2f + (i * 0.05f),
                    dataVencimento
            );
            investimentoDao.create(investimento);

            Login login = new Login(
                    "user" + (200 + i),
                    usuarioId,
                    new Date()
            );
            loginDao.create(login);

            Meta meta = new Meta(
                    400 + i,
                    usuarioId,
                    "Meta " + (i * 10),
                    10000.0f + (i * 1000),
                    5000.0f + (i * 500)
            );
            metaDao.create(meta);

            Patrimonio patrimonio = new Patrimonio(
                    600 + i,
                    usuarioId,
                    "Patrimônio " + (i + 5),
                    30000.0f + (i * 3000)
            );
            patrimonioDao.create(patrimonio);

            Transacao transacao = new Transacao(
                    800 + i,
                    usuarioId,
                    "Transação " + (i * 20),
                    200.0f + (i * 25),
                    "Categoria " + i,
                    (i % 2 == 0) ? "Despesa" : "Receita",
                    new Date()
            );
            transacaoDao.create(transacao);
        }

        System.out.println("\nLISTAGEM DOS REGISTROS CADASTRADOS:");

        System.out.println("Lista de Usuários:");
        usuarioDao.getAll().forEach(System.out::println);

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
