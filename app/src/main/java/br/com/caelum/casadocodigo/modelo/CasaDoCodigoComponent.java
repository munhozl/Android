package br.com.caelum.casadocodigo.modelo;

import javax.inject.Singleton;

import br.com.caelum.casadocodigo.activity.CarrinhoActivity;
import br.com.caelum.casadocodigo.fragment.DetalhesLivroFragment;
import dagger.Component;

/**
 * Created by android7392 on 21/04/18.
 */

@Singleton
@Component(modules = CasaDoCodigoModule.class)
public interface CasaDoCodigoComponent {
    void inject(DetalhesLivroFragment fragment);
    void inject(CarrinhoActivity activity);
}
