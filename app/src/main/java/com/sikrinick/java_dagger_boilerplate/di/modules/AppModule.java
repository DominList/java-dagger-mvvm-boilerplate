package com.sikrinick.java_dagger_boilerplate.di.modules;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {ViewModelModule.class, SchedulersModule.class})
public class AppModule {



}
