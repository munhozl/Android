package br.com.caelum.casadocodigo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.Serializable;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.delegate.LivrosDelegate;
import br.com.caelum.casadocodigo.fragment.DetalhesLivroFragment;
import br.com.caelum.casadocodigo.fragment.ListaLivrosFragment;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.event.LivroEvent;
import br.com.caelum.casadocodigo.server.WebClient;

public class MainActivity extends AppCompatActivity implements LivrosDelegate {

    private	ListaLivrosFragment	listaLivrosFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        listaLivrosFragment = new ListaLivrosFragment();
        transaction.replace(R.id.frame_principal, listaLivrosFragment);
        transaction.commit();
        new WebClient().getLivros(0, 10);
        EventBus.getDefault().register(this);
    }


// PROBLEMA COM CAST DE SERIALIZAÇÃO
    @Override
    public void lidaComLivroSelecionado(Livro livro) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        DetalhesLivroFragment detalhesLivroFragment = criaDetalhesCom(livro);
        transaction.replace(R.id.frame_principal, detalhesLivroFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        //Toast.makeText(this,"Teste",Toast.LENGTH_LONG).show();
    }



    private DetalhesLivroFragment criaDetalhesCom(Livro livro) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("livro", (Serializable) livro);
        DetalhesLivroFragment detalhesLivroFragment = new DetalhesLivroFragment();
        detalhesLivroFragment.setArguments(bundle);
        return detalhesLivroFragment;

    }
    /*@Override
    public void lidaComSucesso(List<Livro> livros) {
        listaLivrosFragment.populaListaCom(livros);
    }*/
 @Subscribe
    public void lidaComSucesso(LivroEvent livroEvent) {
        listaLivrosFragment.populaListaCom(livroEvent.getLivros());
    }

    /*@Override
    public void lidaComErro(Throwable erro) {
        Toast.makeText(this, "Não foi possível carregar os livros...", Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.vai_para_carrinho) {
            Intent vaiParaCarrinho = new Intent(this, CarrinhoActivity.class);
            startActivity(vaiParaCarrinho);
            return  false;
        }else if (item.getItemId() == R.id.deslogar) {
            FirebaseAuth.getInstance().signOut();
            Intent vaiParaLogin = new Intent(this, LoginActivity.class);
            startActivity(vaiParaLogin);
            return  false;
        }
        return true;
    }




    @Subscribe
    public void lidaComErro(Throwable erro) {
        Toast.makeText(this, "Não foi possível carregar os livros...", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
