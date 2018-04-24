package br.com.caelum.casadocodigo.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Autor implements Serializable {
    @SerializedName("idAutor")
    private long id;
    @SerializedName("nomeAutor")
    private String nome;
    @SerializedName("detalhesAutor")
    private String biografia;
    @SerializedName("imagemAutor")
    private String urlFoto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
