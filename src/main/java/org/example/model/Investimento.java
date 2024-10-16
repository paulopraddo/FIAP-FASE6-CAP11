package org.example.model;

import java.util.Date;

public class Investimento {
    private Integer codigoInvestimento;
    private Integer codigoUsuario;
    private Date dataCompra;
    private String nomeDoAtivo;
    private float valorPreco;
    private String classe;
    private float valorTaxa;
    private Date dataDeVencimento;

    @Override
    public String toString() {
        return "Investimento{" +
                "cd_investimento=" + codigoInvestimento +
                ", nm_ativo='" + nomeDoAtivo + '\'' +
                ", vl_preco=" + valorPreco +
                '}';
    }

    public Investimento(Integer codigoInvestimento, Integer codigoUsuario, Date dt_compra, String nm_ativo, float vl_preco, String classe, float vl_taxa, Date dt_vencimento) {
        this.codigoInvestimento = codigoInvestimento;
        this.codigoUsuario = codigoUsuario;
        this.dataCompra = dt_compra;
        this.nomeDoAtivo = nm_ativo;
        this.valorPreco = vl_preco;
        this.classe = classe;
        this.valorTaxa = vl_taxa;
        this.dataDeVencimento = dt_vencimento;
    }

    // Getters e Setters
    public Integer getCd_investimento() {
        return codigoInvestimento;
    }

    public void setCd_investimento(Integer cd_investimento) {
        this.codigoInvestimento = cd_investimento;
    }

    public Integer getCd_usuario() {
        return codigoUsuario;
    }

    public void setCd_usuario(Integer cd_usuario) {
        this.codigoUsuario = cd_usuario;
    }

    public Date getDt_compra() {
        return dataCompra;
    }

    public void setDt_compra(Date dt_compra) {
        this.dataCompra = dt_compra;
    }

    public String getNm_ativo() {
        return nomeDoAtivo;
    }

    public void setNm_ativo(String nm_ativo) {
        this.nomeDoAtivo = nm_ativo;
    }

    public float getVl_preco() {
        return valorPreco;
    }

    public void setVl_preco(float vl_preco) {
        this.valorPreco = vl_preco;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public float getVl_taxa() {
        return valorTaxa;
    }

    public void setVl_taxa(float vl_taxa) {
        this.valorTaxa = vl_taxa;
    }

    public Date getDt_vencimento() {
        return dataDeVencimento;
    }

    public void setDt_vencimento(Date dt_vencimento) {
        this.dataDeVencimento = dt_vencimento;
    }
}

