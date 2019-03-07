package com.sikrinick.java_dagger_boilerplate.presentation.ui.some;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sikrinick.java_dagger_boilerplate.R;
import com.sikrinick.java_dagger_boilerplate.di.Injectable;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SomeFragment extends Fragment implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    SomeViewModel viewModel;

    @BindView(R.id.hello_world_tv)
    TextView someTv;

    @OnClick(R.id.click_me)
    public void clickMe() {
        viewModel.onButtonClick();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_some, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SomeViewModel.class);

        viewModel.getData().observe(this, observer);
    }

    private Observer<SomeViewState> observer = someViewState -> {
        if (someViewState instanceof SomeViewState.Data) {
            someTv.setText(((SomeViewState.Data) someViewState).text);
        } else if (someViewState instanceof SomeViewState.Error) {
            new AlertDialog.Builder(getContext())
                    .setMessage(((SomeViewState.Error) someViewState).error.getMessage())
                    .show();
        }
    };
}
