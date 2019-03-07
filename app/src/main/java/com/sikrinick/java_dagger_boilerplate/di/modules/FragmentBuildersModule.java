package com.sikrinick.java_dagger_boilerplate.di.modules;

import com.sikrinick.java_dagger_boilerplate.presentation.ui.some.SomeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentBuildersModule {

    //EXAMPLE
    @ContributesAndroidInjector
    abstract SomeFragment contributeSomeFragment();

}
