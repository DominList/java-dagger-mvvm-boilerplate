package com.sikrinick.java_dagger_boilerplate.domain.usecase;

import com.sikrinick.java_dagger_boilerplate.Schedulers;
import com.sikrinick.java_dagger_boilerplate.data.repository.SomeRepository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class SomeUseCase {

    private final Schedulers schedulers;
    private final SomeRepository someRepository;

    @Inject
    public SomeUseCase(Schedulers schedulers, SomeRepository someRepository) {
        this.schedulers = schedulers;
        this.someRepository = someRepository;
    }

    public Single<String> execute() {
        return Single.fromCallable(someRepository::getHelloWorld)
                        .subscribeOn(schedulers.computation())
                        .observeOn(schedulers.ui());
    }

}
