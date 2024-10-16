package org.example.model;

import java.util.Date;

public class Transacao {
    private Integer codigoTransacao;
    private Integer codigoUsuario;
    private String nomeTransacao;
    private float valorTransacao;
    private String categoria;
    private String tipo;
    private Date dataTransacao;

    public Transacao(Integer codigoTransacao, Integer codigoUsuario, String nomeTransacao, float valorTransacao, String categoria, String tipo, Date dataTransacao) {
        this.codigoTransacao = codigoTransacao;
        this.codigoUsuario = codigoUsuario;
        this.nomeTransacao = nomeTransacao;
        this.valorTransacao = valorTransacao;
        this.categoria = categoria;
        this.tipo = tipo;
        this.dataTransacao = dataTransacao;
    }

    // Getters e Setters
    public Integer getCodigoTransacao() {
        return codigoTransacao;
    }

    public void setCodigoTransacao(Integer codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNomeTransacao() {
        return nomeTransacao;
    }

    public void setNomeTransacao(String nomeTransacao) {
        this.nomeTransacao = nomeTransacao;
    }

    public float getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(float valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
