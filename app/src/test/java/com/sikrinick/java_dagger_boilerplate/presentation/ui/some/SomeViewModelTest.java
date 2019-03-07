package com.sikrinick.java_dagger_boilerplate.presentation.ui.some;

import com.sikrinick.java_dagger_boilerplate.domain.usecase.SomeUseCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import io.reactivex.Single;
import kotlin.jvm.Throws;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class SomeViewModelTest {

    @Rule
    public final TestRule instantExecutorRule = new InstantTaskExecutorRule();

    public final Observer<SomeViewState> mockedObserver = mock(Observer.class);

    private SomeUseCase someUseCase = mock(SomeUseCase.class);
    private final SomeViewModel someViewModel = new SomeViewModel(someUseCase);

    @Before
    public void beforeAll() {
        assertThat(someViewModel.getData(), notNullValue());
        someViewModel.getData().observeForever(mockedObserver);
    }

    @Test
    public void onButtonClick_success() {
        String testStr = "Test";
        when(someUseCase.execute()).then(invocation -> Single.just(testStr));
        someViewModel.onButtonClick();
        assertThat(someViewModel.getData().getValue(), instanceOf(SomeViewState.Data.class));
        assertEquals(((SomeViewState.Data) someViewModel.getData().getValue()).text, testStr);
    }

    @Test
    public void onButtonClick_error() {
        RuntimeException testExc = new RuntimeException("Test exception");
        when(someUseCase.execute()).then(invocation -> Single.error(testExc));
        someViewModel.onButtonClick();
        assertThat(someViewModel.getData().getValue(), instanceOf(SomeViewState.Error.class));
        assertEquals(((SomeViewState.Error) someViewModel.getData().getValue()).error, testExc);
    }
}