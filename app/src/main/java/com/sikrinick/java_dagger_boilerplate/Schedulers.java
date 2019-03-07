package com.sikrinick.java_dagger_boilerplate;

import androidx.core.util.Supplier;
import io.reactivex.Scheduler;

public class Schedulers {

    private final Supplier<Scheduler> ui;
    private final Supplier<Scheduler> io;
    private final Supplier<Scheduler> computation;
    private final Supplier<Scheduler> trampoline;
    private final Supplier<Scheduler> newThread;

    public Schedulers(Supplier<Scheduler> ui,
                      Supplier<Scheduler> io,
                      Supplier<Scheduler> computation,
                      Supplier<Scheduler> trampoline,
                      Supplier<Scheduler> newThread) {
        this.ui = ui;
        this.io = io;
        this.computation = computation;
        this.trampoline = trampoline;
        this.newThread = newThread;
    }

    public Scheduler ui() {
        return ui.get();
    }

    public Scheduler io() {
        return io.get();
    }

    public Scheduler computation() {
        return computation.get();
    }

    public Scheduler trampoline() {
        return ui.get();
    }

    public Scheduler newThread() {
        return newThread.get();
    }
}
