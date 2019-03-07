package com.sikrinick.java_dagger_boilerplate.di.components;

import android.app.Application;

import com.sikrinick.java_dagger_boilerplate.BoilerplateApplication;
import com.sikrinick.java_dagger_boilerplate.di.modules.AppModule;
import com.sikrinick.java_dagger_boilerplate.di.modules.MainActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(BoilerplateApplication application);

}
