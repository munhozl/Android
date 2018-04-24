package br.com.caelum.casadocodigo;

import android.app.Application;

import br.com.caelum.casadocodigo.modelo.CasaDoCodigoComponent;
import br.com.caelum.casadocodigo.modelo.DaggerCasaDoCodigoComponent;

/**
 * Created by android7392 on 21/04/18.
 */

public class CasaDoCodigoApplication extends Application {
    private CasaDoCodigoComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerCasaDoCodigoComponent.builder().build();
    }
    public CasaDoCodigoComponent getComponent() {
        return component;
    }
}
