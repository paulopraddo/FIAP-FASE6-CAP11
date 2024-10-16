package org.example.model;

public class Patrimonio {

    private Integer codigoPatrimonio;
    private Integer codigoUsuario;
    private String nomePatrimonio;
    private float valorPatrimonio;

    public Patrimonio(Integer codigoPatrimonio, Integer codigoUsuario, String nomePatrimonio, float valorPatrimonio) {
        this.codigoPatrimonio = codigoPatrimonio;
        this.codigoUsuario = codigoUsuario;
        this.nomePatrimonio = nomePatrimonio;
        this.valorPatrimonio = valorPatrimonio;
    }

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

    @Override
    public String toString() {
        return "Patrimonio{" +
                "cd_patrimonio=" + codigoPatrimonio +
                ", nm_patrimonio='" + nomePatrimonio + '\'' +
                ", vl_patrimonio=" + valorPatrimonio +
                '}';
    }

}