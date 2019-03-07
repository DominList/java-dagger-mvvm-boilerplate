package com.sikrinick.java_dagger_boilerplate.di.modules;

import com.sikrinick.java_dagger_boilerplate.di.annotations.ViewModelKey;
import com.sikrinick.java_dagger_boilerplate.di.factories.ViewModelFactory;
import com.sikrinick.java_dagger_boilerplate.presentation.ui.some.SomeViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

    //Example
    @Binds
    @IntoMap
    @ViewModelKey(SomeViewModel.class)
    abstract ViewModel bindSomeViewModel(SomeViewModel userViewModel);

}