package org.example.model;

public class Meta {
    private Integer codigoMeta;  // PK
    private Integer codigoUsuario;  // F
    private String nomeMeta;
    private float valorMeta;
    private float valorPopular;

    public Meta(Integer cd_metas, Integer codigoUsuario, String nomeMeta, float vl_meta, float vl_popular) {
        this.codigoMeta = cd_metas;
        this.codigoUsuario = codigoUsuario;
        this.nomeMeta = nomeMeta;
        this.valorMeta = vl_meta;
        this.valorPopular = vl_popular;
    }

    // Getters e Setters
    public Integer getCd_metas() {
        return codigoMeta;
    }

    public void setCd_metas(Integer cd_metas) {
        this.codigoMeta = cd_metas;
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

    public float getVl_meta() {
        return valorMeta;
    }

    public void setVl_meta(float vl_meta) {
        this.valorMeta = vl_meta;
    }

    public float getVl_popular() {
        return valorPopular;
    }

    public void setVl_popular(float vl_popular) {
        this.valorPopular = vl_popular;
    }
}
