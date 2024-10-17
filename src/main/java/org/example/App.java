package org.example;

import org.example.dao.impl.*;
import org.example.model.*;

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

        System.out.println("Inserindo novos registros...");
        Usuario usuario = new Usuario(null, "João Silva", "joao.silva@example.com", null, "123456789", "senhaSegura", new Date());
        int usuarioId = usuarioDao.create(usuario);
        // Armazenar o ID do usuário gerado
        Investimento investimento = new Investimento(null, usuarioId, new Date(), "Ação XYZ", 100.50f, "Ação", 0.5f, new Date());
        investimentoDao.create(investimento);

        Login login = new Login(null, usuarioId, new Date());
        loginDao.create(login);

        Meta meta = new Meta(null, usuarioId, "Comprar um carro", 100000.0f, 5000.0f);
        metaDao.create(meta);

        Patrimonio patrimonio = new Patrimonio(null, usuarioId, "Casa própria", 300000.0f);
        patrimonioDao.create(patrimonio);

        Transacao transacao = new Transacao(null, usuarioId, "Remedios", 200.0f, "Farmacia", "Despesa", new Date());
        transacaoDao.create(transacao);


        System.out.println("\nRecuperando os registros cadastrados...");
        System.out.println("Lista de Usuários:");
        usuarioDao.getAll().forEach(System.out::println);

        System.out.println("Lista de Investimentos:");
        investimentoDao.getAll().forEach(System.out::println);

        System.out.println("Lista de Logins:");
        loginDao.getAll().forEach(System.out::println);

        System.out.println("\nLista de Metas:");
        metaDao.getAll().forEach(System.out::println);

        System.out.println("\nLista de Patrimônios:");
        patrimonioDao.getAll().forEach(System.out::println);

        System.out.println("\nLista de Transações:");
        transacaoDao.getAll().forEach(System.out::println);

//        for (int i = 1; i <= 5; i++) {
//            calendar.set(2023, Calendar.JANUARY, 10 + i);
//            Date dataCompra = calendar.getTime();
//            calendar.set(2025, Calendar.JANUARY, 10 + i);
//            Date dataVencimento = calendar.getTime();

//            Investimento investimento = new Investimento(
//                    1000 + i,
//                    usuario.getCodigoUsuario(),
//                    dataCompra,
//                    "Ativo " + (100 + i),
//                    1000.0f + (i * 50),
//                    "Classe " + i,
//                    0.2f + (i * 0.05f),
//                    dataVencimento
//            );
//            investimentoDao.create(investimento);

//            Login login = new Login(
//                    "user" + (200 + i),
//                    usuario.getCodigoUsuario(),
//                    new Date()
//            );
//            loginDao.insert(login);
//
//            Meta meta = new Meta(
//                    400 + i,
//                    500 + i,
//                    "Meta " + (i * 10),
//                    10000.0f + (i * 1000),
//                    5000.0f + (i * 500)
//            );
//            metaDao.insert(meta);
//
//            Patrimonio patrimonio = new Patrimonio(
//                    600 + i,
//                    700 + i,
//                    "Patrimônio " + (i + 5),
//                    30000.0f + (i * 3000)
//            );
//            patrimonioDao.insert(patrimonio);
//
//            Transacao transacao = new Transacao(
//                    800 + i,
//                    900 + i,
//                    "Transação " + (i * 20),
//                    200.0f + (i * 25),
//                    "Categoria " + i,
//                    (i % 2 == 0) ? "Despesa" : "Receita",
//                    new Date()
//            );
//            transacaoDao.insert(transacao);
    }

//        System.out.println("\nRecuperando os registros cadastrados...");
//
//        System.out.println("Lista de Usuários:");
//        usuarioDao.getAll().forEach(System.out::println);
//
//        System.out.println("Lista de Investimentos:");
//        investimentoDao.getAll().forEach(System.out::println);

//        System.out.println("\nLista de Logins:");
//        loginDao.getAll().forEach(System.out::println);
//
//        System.out.println("\nLista de Metas:");
//        metaDao.getAll().forEach(System.out::println);
//
//        System.out.println("\nLista de Patrimônios:");
//        patrimonioDao.getAll().forEach(System.out::println);
//
//        System.out.println("\nLista de Transações:");
//        transacaoDao.getAll().forEach(System.out::println);
}
