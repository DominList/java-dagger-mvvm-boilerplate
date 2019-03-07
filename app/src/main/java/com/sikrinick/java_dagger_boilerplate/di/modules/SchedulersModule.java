package com.sikrinick.java_dagger_boilerplate.di.modules;

import com.sikrinick.java_dagger_boilerplate.Schedulers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Module
public class SchedulersModule {

    @Provides
    @Singleton
    public Schedulers provideSchedulers() {
        return new Schedulers(
                AndroidSchedulers::mainThread,
                io.reactivex.schedulers.Schedulers::io,
                io.reactivex.schedulers.Schedulers::computation,
                io.reactivex.schedulers.Schedulers::trampoline,
                io.reactivex.schedulers.Schedulers::newThread
        );
    }

}
