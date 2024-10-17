## Conexao com o banco de dados:
    URL = "jdbc:oracle:thin:@localhost:1521:xe";
    USER = "system";
    PASSWORD = "12345678";

## Criando a tabela no banco de dados
```SQL
CREATE SEQUENCE  seq_investimento
    START WITH 1
    INCREMENT BY 1;
    
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

ALTER TABLE t_investimento ADD CONSTRAINT t_investimento_pk PRIMARY KEY ( cd_investimento );

CREATE SEQUENCE  seq_login
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE t_login (
    cd_login   INTEGER NOT NULL,
    cd_usuario INTEGER NOT NULL,
    dt_login   DATE NOT NULL
);

ALTER TABLE t_login ADD CONSTRAINT t_login_pk PRIMARY KEY ( cd_login );

CREATE SEQUENCE  seq_meta
    START WITH 1
    INCREMENT BY 1;
    
CREATE TABLE t_meta (
    cd_meta   INTEGER NOT NULL,
    cd_usuario INTEGER NOT NULL,
    nm_meta    VARCHAR2(100) NOT NULL,
    vl_meta    FLOAT NOT NULL,
    vl_poupar  FLOAT NOT NULL
);

ALTER TABLE t_meta ADD CONSTRAINT t_meta_pk PRIMARY KEY ( cd_metas );

CREATE SEQUENCE  seq_patrimonio
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE t_patrimonio (
    cd_patrimonio INTEGER NOT NULL,
    cd_usuario    INTEGER NOT NULL,
    nm_patrimonio VARCHAR2(100) NOT NULL,
    vl_patrimonio FLOAT NOT NULL
);

ALTER TABLE t_patrimonio ADD CONSTRAINT t_patrimonio_pk PRIMARY KEY ( cd_patrimonio );

CREATE SEQUENCE  seq_transacao
    START WITH 1
    INCREMENT BY 1;
    
CREATE TABLE t_transacao (
    cd_transacao INTEGER NOT NULL,
    cd_usuario   INTEGER NOT NULL,
    nm_transacao VARCHAR2(100) NOT NULL,
    vl_transacao FLOAT NOT NULL,
    ds_categoria VARCHAR2(30) NOT NULL,
    ds_tipo      VARCHAR2(50) NOT NULL,
    dt_transacao DATE NOT NULL
);

ALTER TABLE t_transacao ADD CONSTRAINT t_transacao_pk PRIMARY KEY ( cd_transacao );

CREATE SEQUENCE  seq_usuario
    START WITH 1
    INCREMENT BY 1;
    
CREATE TABLE t_usuario (
    cd_usuario INTEGER NOT NULL,
    nm_nome    VARCHAR2(100) NOT NULL,
    ds_email   VARCHAR2(50) NOT NULL,
    tx_imagem  BLOB,
    nr_celular VARCHAR2(12) NOT NULL,
    tx_senha   VARCHAR2(100) NOT NULL,
    dt_criacao DATE NOT NULL
);

ALTER TABLE t_usuario ADD CONSTRAINT t_usuario_pk PRIMARY KEY ( cd_usuario );

ALTER TABLE t_investimento
    ADD CONSTRAINT t_investimento_t_usuario_fk FOREIGN KEY ( cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_login
    ADD CONSTRAINT t_login_t_usuario_fk FOREIGN KEY ( cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_meta
    ADD CONSTRAINT t_meta_t_usuario_fk FOREIGN KEY ( cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_patrimonio
    ADD CONSTRAINT t_patrimonio_t_usuario_fk FOREIGN KEY ( cd_usuario )
        REFERENCES t_usuario ( cd_usuario );

ALTER TABLE t_transacao
    ADD CONSTRAINT t_transacao_t_usuario_fk FOREIGN KEY ( cd_usuario )
        REFERENCES t_usuario ( cd_usuario );
