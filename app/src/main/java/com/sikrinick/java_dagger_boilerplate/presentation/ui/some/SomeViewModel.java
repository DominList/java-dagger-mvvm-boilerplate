package com.sikrinick.java_dagger_boilerplate.presentation.ui.some;

import com.sikrinick.java_dagger_boilerplate.domain.usecase.SomeUseCase;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class SomeViewModel extends ViewModel {

    private final MutableLiveData<SomeViewState> liveData = new MutableLiveData<>();

    private final CompositeDisposable disposables = new CompositeDisposable();

    private final SomeUseCase someUseCase;

    @Inject
    public SomeViewModel(SomeUseCase someUseCase) {
        this.someUseCase = someUseCase;
    }

    public void onButtonClick() {
        disposables.add(someUseCase.execute()
                .subscribe(
                        text -> liveData.setValue(new SomeViewState.Data(text)),
                        error -> liveData.setValue(new SomeViewState.Error(error))));
    }

    public LiveData<SomeViewState> getData() {
        return liveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.dispose();
    }
}
