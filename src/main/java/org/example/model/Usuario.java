package org.example.model;

import java.util.Date;

public class Usuario {

    private Integer codigoUsuario;
    private String nome;
    private String email;
    private String imagem;
    private String celular;
    private String senha;
    private Date dataCriacao;

    public Usuario(Integer codigoUsuario, String nome, String email, String imagem, String celular, String senha, Date dataCriacao) {
        this.codigoUsuario = codigoUsuario;
        this.nome = nome;
        this.email = email;
        this.imagem = imagem;
        this.celular = celular;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "codigoUsuario=" + codigoUsuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }

}
