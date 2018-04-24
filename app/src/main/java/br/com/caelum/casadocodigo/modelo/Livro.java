package br.com.caelum.casadocodigo.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Livro implements Serializable{

    @SerializedName("id")
    private long id;

    @SerializedName("nomeLivro")
    private String nome;

    @SerializedName("descricaoLivro")
    private String descricao;

    @SerializedName("numeroPaginas")
    private int numPaginas;

    @SerializedName("dataPublicacao")
    private String dataPublicacao;

    @SerializedName("isbn")
    private String ISBN;

    @SerializedName("valorFisico")
    private double valorFisico;

    @SerializedName("valorVirtual")
    private double valorVirtual;

    @SerializedName("valorVirtualComFisico")
    private double valorDoisJuntos;

    @SerializedName("imagemUrl")
    private String urlFoto;

    @SerializedName("autores")
    private List<Autor> autores;


    private List<Livro> livros;

    public Livro() {}

    public Livro(String nome, String descricao, List<Autor> autores) {
        this.nome = nome;
        this.descricao = descricao;
        this.autores = autores;
    }
    public List<Livro> getLivros() {return livros;}

    public void setLivros(List<Livro> livros) {this.livros = livros;}
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getValorFisico() {
        return valorFisico;
    }

    public void setValorFisico(double valorFisico) {
        this.valorFisico = valorFisico;
    }

    public double getValorVirtual() {
        return valorVirtual;
    }

    public void setValorVirtual(double valorVirtual) {
        this.valorVirtual = valorVirtual;
    }

    public double getValorDoisJuntos() {
        return valorDoisJuntos;
    }

    public void setValorDoisJuntos(double valorDoisJuntos) {
        this.valorDoisJuntos = valorDoisJuntos;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
