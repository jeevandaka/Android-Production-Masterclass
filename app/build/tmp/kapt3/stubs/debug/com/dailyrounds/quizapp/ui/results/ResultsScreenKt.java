package com.dailyrounds.quizapp.ui.results;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007\u001a\"\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0003\u00a8\u0006\u000f"}, d2 = {"ResultsScreen", "", "correct", "", "total", "skipped", "longestStreak", "onRestart", "Lkotlin/Function0;", "StatCard", "label", "", "value", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class ResultsScreenKt {
    
    /**
     * End-of-quiz summary: correct/total, skipped, longest streak, and Restart.
     * A tiny entrance animation (scale + fade via graphicsLayer) is the "delight"
     * moment the brief asks the results screen to deliver, without pulling in a
     * confetti library for something this scoped.
     */
    @androidx.compose.runtime.Composable()
    public static final void ResultsScreen(int correct, int total, int skipped, int longestStreak, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRestart) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void StatCard(java.lang.String label, java.lang.String value, androidx.compose.ui.Modifier modifier) {
    }
}