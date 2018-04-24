package br.com.caelum.casadocodigo.modelo;

public class Item {

    private Livro livro;
    private TipoDeCompra tipoDeCompra;

    public Item(Livro livro, TipoDeCompra tipoDeCompra) {
        this.setLivro(livro);
        this.setTipoDeCompra(tipoDeCompra);
    }

    public Livro getLivro() {
        return livro;
    }

    public TipoDeCompra getTipoDeCompra() {
        return tipoDeCompra;
    }

    public double getValor() {
        switch (getTipoDeCompra()) {
            case FISICO:
                return getLivro().getValorFisico();

            case VIRTUAL:
                return getLivro().getValorVirtual();

            default:
                return getLivro().getValorDoisJuntos();

        }
    }


    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setTipoDeCompra(TipoDeCompra tipoDeCompra) {
        this.tipoDeCompra = tipoDeCompra;
    }
}