package br.com.caelum.casadocodigo.server;

import org.greenrobot.eventbus.EventBus;

import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.event.LivroEvent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by android7392 on 14/04/18.
 */

public class WebClient {
    private static final String SERVER_URL = "http://cdcmob.herokuapp.com";

    public void getLivros(int indicePrimeiroLivro, int qtdLivros) {
        Retrofit client = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LivrosService service = client.create(LivrosService.class);
        Call<Livro> call = service.listaLivros(indicePrimeiroLivro, qtdLivros);
        //call.enqueue(???);
        call.enqueue(new Callback<Livro>() {
            @Override
            public void onResponse(Call<Livro> call, Response<Livro> response) {
                EventBus.getDefault().post(new LivroEvent(response.body().getLivros()));
            }
            @Override
            public void onFailure(Call<Livro> call, Throwable t) {
                EventBus.getDefault().post(t);
            }
        });


    }




}


