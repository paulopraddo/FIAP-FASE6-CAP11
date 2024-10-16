package org.example.model;

import java.util.Date;

public class Investimento {

    private Integer codigoInvestimento;
    private Usuario codigoUsuarioFK;
    private Date dataCompra;
    private String nomeAtivo;
    private float valorPreco;
    private String classe;
    private float valorTaxa;
    private Date dataVencimento;

    public Investimento(Integer codigoInvestimento, Usuario codigoUsuario, Date dataCompra, String nomeAtivo, float valorPreco, String classe, float valorTaxa, Date dataVencimento) {
        this.codigoInvestimento = codigoInvestimento;
        this.codigoUsuarioFK = codigoUsuario;
        this.dataCompra = dataCompra;
        this.nomeAtivo = nomeAtivo;
        this.valorPreco = valorPreco;
        this.classe = classe;
        this.valorTaxa = valorTaxa;
        this.dataVencimento = dataVencimento;
    }

    public Integer getCodigoInvestimento() {
        return codigoInvestimento;
    }

    public void setCodigoInvestimento(Integer codigoInvestimento) {
        this.codigoInvestimento = codigoInvestimento;
    }

    public Usuario getCodigoUsuarioFK() {
        return codigoUsuarioFK;
    }

    public void setCodigoUsuarioFK(Usuario codigoUsuarioFK) {
        this.codigoUsuarioFK = codigoUsuarioFK;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getNomeAtivo() {
        return nomeAtivo;
    }

    public void setNomeAtivo(String nomeAtivo) {
        this.nomeAtivo = nomeAtivo;
    }

    public float getValorPreco() {
        return valorPreco;
    }

    public void setValorPreco(float valorPreco) {
        this.valorPreco = valorPreco;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public float getValorTaxa() {
        return valorTaxa;
    }

    public void setValorTaxa(float valorTaxa) {
        this.valorTaxa = valorTaxa;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public String toString() {
        return "Investimento{" +
                "cd_investimento=" + codigoInvestimento +
                ", nm_ativo='" + nomeAtivo + '\'' +
                ", vl_preco=" + valorPreco +
                '}';
    }

}

