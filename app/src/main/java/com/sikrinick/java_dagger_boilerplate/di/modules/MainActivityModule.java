package com.sikrinick.java_dagger_boilerplate.di.modules;

import com.sikrinick.java_dagger_boilerplate.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class})
    public abstract MainActivity contributeMainActivity();
}
