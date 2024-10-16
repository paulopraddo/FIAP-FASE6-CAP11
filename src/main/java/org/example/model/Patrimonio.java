package org.example.model;

public class Patrimonio {
    private Integer codigoPatrimonio;  // PK
    private Integer codigoUsuario;  // F
    private String nomePatrimonio;
    private float valorPatrimonio;

    public Patrimonio(Integer codigoPatrimonio, Integer codigoUsuario, String nomePatrimonio, float valorPatrimonio) {
        this.codigoPatrimonio = codigoPatrimonio;
        this.codigoUsuario = codigoUsuario;
        this.nomePatrimonio = nomePatrimonio;
        this.valorPatrimonio = valorPatrimonio;
    }

    // Getters e Setters
    public Integer getCodigoPatrimonio() {
        return codigoPatrimonio;
    }

    public void setCodigoPatrimonio(Integer codigoPatrimonio) {
        this.codigoPatrimonio = codigoPatrimonio;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNomePatrimonio() {
        return nomePatrimonio;
    }

    public void setNomePatrimonio(String nomePatrimonio) {
        this.nomePatrimonio = nomePatrimonio;
    }

    public float getValorPatrimonio() {
        return valorPatrimonio;
    }

    public void setValorPatrimonio(float valorPatrimonio) {
        this.valorPatrimonio = valorPatrimonio;
    }
}

