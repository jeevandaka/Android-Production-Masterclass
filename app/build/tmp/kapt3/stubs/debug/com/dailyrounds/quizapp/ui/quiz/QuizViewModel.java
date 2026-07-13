package com.dailyrounds.quizapp.ui.quiz;

/**
 * Owns all quiz state and every rule from the brief:
 * - load questions, show loading
 * - reveal answer on tap, auto-advance after 2s
 * - Skip advances immediately (only while unanswered)
 * - streak counting + reset on wrong answer, celebration at 3
 * - transition to Results after question 10, with Restart support
 *
 * All mutation happens through a single MutableStateFlow<QuizUiState> so the
 * screen is always rendering one consistent snapshot -- no partial-update
 * races between "which question" and "is the answer revealed".
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\u0013H\u0014J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/dailyrounds/quizapp/ui/quiz/QuizViewModel;", "Landroidx/lifecycle/ViewModel;", "getQuestionsUseCase", "Lcom/dailyrounds/quizapp/domain/usecase/GetQuestionsUseCase;", "(Lcom/dailyrounds/quizapp/domain/usecase/GetQuestionsUseCase;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState;", "autoAdvanceJob", "Lkotlinx/coroutines/Job;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "buildResults", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Results;", "state", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Quiz;", "goToNextOrFinish", "", "loadQuestions", "onCleared", "onOptionSelected", "optionIndex", "", "onSkipClicked", "onStreakCelebrationShown", "onSwipeToNext", "restartQuiz", "scheduleAutoAdvance", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class QuizViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.dailyrounds.quizapp.domain.usecase.GetQuestionsUseCase getQuestionsUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.dailyrounds.quizapp.ui.quiz.QuizUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.dailyrounds.quizapp.ui.quiz.QuizUiState> uiState = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job autoAdvanceJob;
    
    @javax.inject.Inject()
    public QuizViewModel(@org.jetbrains.annotations.NotNull()
    com.dailyrounds.quizapp.domain.usecase.GetQuestionsUseCase getQuestionsUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.dailyrounds.quizapp.ui.quiz.QuizUiState> getUiState() {
        return null;
    }
    
    public final void loadQuestions() {
    }
    
    /**
     * User tapped one of the four options. No-op if already revealed (prevents double taps).
     */
    public final void onOptionSelected(int optionIndex) {
    }
    
    /**
     * "Skip" button -- only actionable before an answer is revealed; advances immediately.
     */
    public final void onSkipClicked() {
    }
    
    /**
     * Called by the UI once the streak-celebration animation has played out.
     */
    public final void onStreakCelebrationShown() {
    }
    
    /**
     * Swipe-left gesture on the question card behaves exactly like Skip.
     */
    public final void onSwipeToNext() {
    }
    
    public final void restartQuiz() {
    }
    
    private final void scheduleAutoAdvance() {
    }
    
    private final void goToNextOrFinish(com.dailyrounds.quizapp.ui.quiz.QuizUiState.Quiz state) {
    }
    
    private final com.dailyrounds.quizapp.ui.quiz.QuizUiState.Results buildResults(com.dailyrounds.quizapp.ui.quiz.QuizUiState.Quiz state) {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}