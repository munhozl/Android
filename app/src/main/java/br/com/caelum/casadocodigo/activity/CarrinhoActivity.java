package br.com.caelum.casadocodigo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

import javax.inject.Inject;

import br.com.caelum.casadocodigo.CasaDoCodigoApplication;
import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.ItensAdapter;
import br.com.caelum.casadocodigo.modelo.Carrinho;
import br.com.caelum.casadocodigo.modelo.Item;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by android7392 on 21/04/18.
 */

public class CarrinhoActivity extends AppCompatActivity {

    @BindView(R.id.lista_itens_carrinho)
    RecyclerView listaItens;
    @BindView(R.id.valor_carrinho)
    TextView valorTotal;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Inject
    Carrinho carrinho;
    //private Carrinho carrinho = new Carrinho();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);
        ButterKnife.bind(this);

        CasaDoCodigoApplication	app	= (CasaDoCodigoApplication)	getApplication();
        app.getComponent().inject(this);
    }



    public void carregaLista() {
        listaItens.setAdapter(new ItensAdapter(carrinho.getItens(), this));
        listaItens.setLayoutManager(new LinearLayoutManager(this));
        double total = 0;
        for (Item item : carrinho.getItens()) {
            total += item.getValor();
        }
        valorTotal.setText("R$ " + total);


    }
    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }
}
