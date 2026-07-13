package com.dailyrounds.quizapp.ui.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u00a8\u0006\u0002"}, d2 = {"QuizNavGraph", "", "app_debug"})
public final class QuizNavGraphKt {
    
    /**
     * A NavHost with a single destination today, kept as scaffolding rather than
     * removed entirely: it's the natural place to add e.g. a settings screen, a
     * question-count picker, or a review screen later without restructuring
     * MainActivity. QuizRoute internally handles loading/quiz/results via its own
     * state machine (see QuizViewModel + QuizUiState) since those aren't really
     * separate back-stack destinations -- see the comment on QuizRoute.
     */
    @androidx.compose.runtime.Composable()
    public static final void QuizNavGraph() {
    }
}