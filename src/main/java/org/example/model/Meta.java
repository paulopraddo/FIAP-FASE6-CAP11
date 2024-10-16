package org.example.model;

public class Meta {

    private Integer codigoMeta;
    private Integer codigoUsuario;
    private String nomeMeta;
    private float valorMeta;
    private float valorPoupar;

    public Meta(Integer codigoMeta, Integer codigoUsuario, String nomeMeta, float valorMeta, float valorPoupar) {
        this.codigoMeta = codigoMeta;
        this.codigoUsuario = codigoUsuario;
        this.nomeMeta = nomeMeta;
        this.valorMeta = valorMeta;
        this.valorPoupar = valorPoupar;
    }

    public Integer getCodigoMeta() {
        return codigoMeta;
    }

    public void setCodigoMeta(Integer codigoMeta) {
        this.codigoMeta = codigoMeta;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNomeMeta() {
        return nomeMeta;
    }

    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }

    public float getValorMeta() {
        return valorMeta;
    }

    public void setValorMeta(float valorMeta) {
        this.valorMeta = valorMeta;
    }

    public float getValorPoupar() {
        return valorPoupar;
    }

    public void setValorPoupar(float valorPoupar) {
        this.valorPoupar = valorPoupar;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "cd_meta=" + codigoMeta +
                ", nm_meta='" + nomeMeta + '\'' +
                ", vl_meta=" + valorMeta +
                '}';
    }

}
