## Conexao com o banco de dados:
    URL = "jdbc:oracle:thin:@localhost:1521:xe";
    USER = "system";
    PASSWORD = "12345678";

## Criando a tabela no banco de dados
```SQL

CREATE TABLE t_investimento (
    cd_investimento INTEGER NOT NULL,
    cd_usuario      INTEGER NOT NULL,
    dt_compra       DATE NOT NULL,
    nm_ativo        VARCHAR2(100) NOT NULL,
    vl_preco        FLOAT NOT NULL,
    ds_classe       VARCHAR2(50) NOT NULL,
    vl_taxa         FLOAT,
    dt_vencimento   DATE NOT NULL
);

ALTER TABLE t_investimento ADD CONSTRAINT t_investimento_pk PRIMARY KEY (cd_investimento);


CREATE TABLE t_login (
    cd_login   INTEGER NOT NULL,
    cd_usuario INTEGER NOT NULL,
    dt_login   DATE NOT NULL
);

ALTER TABLE t_login ADD CONSTRAINT t_login_pk PRIMARY KEY (cd_login);

CREATE TABLE t_meta (
    cd_metas   INTEGER NOT NULL,
    cd_usuario INTEGER NOT NULL,
    nm_meta    VARCHAR2(100) NOT NULL,
    vl_meta    FLOAT NOT NULL,
    vl_poupar  FLOAT NOT NULL
);

ALTER TABLE t_meta ADD CONSTRAINT t_meta_pk PRIMARY KEY (cd_metas);

CREATE TABLE t_patrimonio (
    cd_patrimonio INTEGER NOT NULL,
    cd_usuario    INTEGER NOT NULL,
    nm_patrimonio VARCHAR2(100) NOT NULL,
    vl_patrimonio FLOAT NOT NULL
);

ALTER TABLE t_patrimonio ADD CONSTRAINT t_patrimonio_pk PRIMARY KEY (cd_patrimonio);

-- Criando a tabela t_transacao sem sequence
CREATE TABLE t_transacao (
    cd_transacao INTEGER NOT NULL,
    cd_usuario   INTEGER NOT NULL,
    nm_transacao VARCHAR2(100) NOT NULL,
    vl_transacao FLOAT NOT NULL,
    ds_categoria VARCHAR2(30) NOT NULL,
    ds_tipo      VARCHAR2(50) NOT NULL,
    dt_transacao DATE NOT NULL
);

ALTER TABLE t_transacao ADD CONSTRAINT t_transacao_pk PRIMARY KEY (cd_transacao);

CREATE TABLE t_usuario (
    cd_usuario INTEGER NOT NULL,
    nm_nome    VARCHAR2(100) NOT NULL,
    ds_email   VARCHAR2(50) NOT NULL,
    tx_imagem  BLOB,
    nr_celular VARCHAR2(12) NOT NULL,
    tx_senha   VARCHAR2(100) NOT NULL,
    dt_criacao DATE NOT NULL
);

ALTER TABLE t_usuario ADD CONSTRAINT t_usuario_pk PRIMARY KEY (cd_usuario);

-- Adicionando chaves estrangeiras para todas as tabelas que referenciam t_usuario
ALTER TABLE t_investimento
    ADD CONSTRAINT t_investimento_t_usuario_fk FOREIGN KEY (cd_usuario)
        REFERENCES t_usuario (cd_usuario);

ALTER TABLE t_login
    ADD CONSTRAINT t_login_t_usuario_fk FOREIGN KEY (cd_usuario)
        REFERENCES t_usuario (cd_usuario);

ALTER TABLE t_meta
    ADD CONSTRAINT t_meta_t_usuario_fk FOREIGN KEY (cd_usuario)
        REFERENCES t_usuario (cd_usuario);

ALTER TABLE t_patrimonio
    ADD CONSTRAINT t_patrimonio_t_usuario_fk FOREIGN KEY (cd_usuario)
        REFERENCES t_usuario (cd_usuario);

ALTER TABLE t_transacao
    ADD CONSTRAINT t_transacao_t_usuario_fk FOREIGN KEY (cd_usuario)
        REFERENCES t_usuario (cd_usuario);

```
## Comandos para deletar as tabelas:

```SQL

ALTER TABLE t_investimento DROP CONSTRAINT t_investimento_t_usuario_fk;
ALTER TABLE t_login DROP CONSTRAINT t_login_t_usuario_fk;
ALTER TABLE t_meta DROP CONSTRAINT t_meta_t_usuario_fk;
ALTER TABLE t_patrimonio DROP CONSTRAINT t_patrimonio_t_usuario_fk;
ALTER TABLE t_transacao DROP CONSTRAINT t_transacao_t_usuario_fk;

DROP TABLE t_investimento;
DROP TABLE t_login;
DROP TABLE t_meta;
DROP TABLE t_patrimonio;
DROP TABLE t_transacao;
DROP TABLE t_usuario;

DROP SEQUENCE seq_investimento;
DROP SEQUENCE seq_login;
DROP SEQUENCE seq_meta;
DROP SEQUENCE seq_patrimonio;
DROP SEQUENCE seq_transacao;
DROP SEQUENCE seq_usuario;


