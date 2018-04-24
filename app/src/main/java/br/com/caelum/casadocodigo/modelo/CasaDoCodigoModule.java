package br.com.caelum.casadocodigo.modelo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by android7392 on 21/04/18.
 */

@Module
public class CasaDoCodigoModule {
    @Provides
    @Singleton
    public Carrinho getCarrinho() {
        return new Carrinho();
    }
}
