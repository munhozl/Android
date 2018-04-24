package br.com.caelum.casadocodigo.delegate;

import br.com.caelum.casadocodigo.modelo.Livro;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Created by android7392 on 07/04/18.
 */

public interface LivrosDelegate {

    public void lidaComLivroSelecionado (Livro livro);
    // public void lidaComSucesso(List<Livro> livros);
    //public void lidaComErro(Throwable erro);


}
