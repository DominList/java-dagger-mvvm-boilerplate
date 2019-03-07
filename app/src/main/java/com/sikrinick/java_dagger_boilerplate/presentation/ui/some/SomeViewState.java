package com.sikrinick.java_dagger_boilerplate.presentation.ui.some;

public interface SomeViewState {

    class Data implements SomeViewState {
        public final String text;

        public Data(String text) {
            this.text = text;
        }
    }

    class Error implements SomeViewState {
        public final Throwable error;

        public Error(Throwable error) {
            this.error = error;
        }
    }

}
