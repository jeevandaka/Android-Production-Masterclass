package com.dailyrounds.quizapp.ui.components;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2 = {"StreakCelebration", "", "streak", "", "onFinished", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class StreakBadgeKt {
    
    /**
     * The "creative way to engage the user" the brief asks for at streak == 3(6, 9, ...):
     * a fire badge that pops in with an overshoot scale animation and a haptic-style
     * bounce, holds briefly, then calls back so the ViewModel can clear the
     * one-shot "showStreakCelebration" flag.
     *
     * Deliberately NOT a Snackbar/Toast: those interrupt the question flow. This
     * renders inline above the question so the streak text stays visible without
     * blocking the next tap.
     */
    @androidx.compose.runtime.Composable()
    public static final void StreakCelebration(int streak, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}