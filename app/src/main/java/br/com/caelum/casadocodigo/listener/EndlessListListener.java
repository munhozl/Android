package br.com.caelum.casadocodigo.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Leandro on 18/04/2018.
 */

public abstract class EndlessListListener extends RecyclerView.OnScrollListener {

    public abstract void carregaMaisItens();
    private int quantidadeTotalItens;
    private int primeiroItemVisivel;
    private int quantidadeItensVisiveis;
    private boolean carregando = true;
    private int totalAnterior = 0;

    @Override
    public void onScrolled(RecyclerView recyclerView, int qtdScrollHorizontal, int qtdScrollVertical) {
        super.onScrolled(recyclerView, qtdScrollHorizontal, qtdScrollVertical);
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager()
                ;
        quantidadeTotalItens = layoutManager.getItemCount();
        primeiroItemVisivel = layoutManager.findFirstVisibleItemPosition();
        quantidadeItensVisiveis = recyclerView.getChildCount();
        int limiteLimiteParaCarregar = quantidadeTotalItens - quantidadeItensVisiveis - 5;
        if (carregando) {
            if (quantidadeTotalItens > totalAnterior) {
                totalAnterior = quantidadeTotalItens;
                carregando = false;
            }
        }
        if (!carregando && primeiroItemVisivel >= limiteLimiteParaCarregar) {
            carregaMaisItens();
            carregando = true;
        }
    }
}
