package com.sikrinick.java_dagger_boilerplate.di.factories;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        this.creators = creators;
    }

    @NonNull
    @Override
    @SuppressWarnings({"unchecked", "TypeParameterHidesVisibleType"})
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<ViewModel> viewModelProvider = null;
        if (creators.containsKey(modelClass)) {
            viewModelProvider = creators.get(modelClass);
        } else {
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> creator : creators.entrySet()) {
                if (modelClass.isAssignableFrom(creator.getKey())) {
                    viewModelProvider = creators.get(modelClass);
                }
            }
        }
        if (viewModelProvider == null) {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }
        try {
            return (T) viewModelProvider.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
