package com.dailyrounds.quizapp.ui.splash;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u00a8\u0006\u0002"}, d2 = {"SplashScreen", "", "app_debug"})
public final class SplashScreenKt {
    
    /**
     * Brief loading state while the ViewModel fetches + parses questions
     * (remote-first, local-fallback -- see QuizRepositoryImpl). Kept intentionally
     * simple: a pulsing title + spinner, no fake artificial delay, since the real
     * network/parse work already provides a natural minimum duration.
     */
    @androidx.compose.runtime.Composable()
    public static final void SplashScreen() {
    }
}