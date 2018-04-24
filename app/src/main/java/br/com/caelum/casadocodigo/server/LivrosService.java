package br.com.caelum.casadocodigo.server;

import br.com.caelum.casadocodigo.modelo.Livro;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by android7392 on 14/04/18.
 */

public interface LivrosService {


    @GET("listarLivros")
    Call<Livro>listaLivros(@Query("indicePrimeiroLivro") int indicePrimeiroLivro,
                            @Query("qtdLivros") int qtdLivro);
}
