package com.dailyrounds.quizapp.ui.quiz;

/**
 * Single sealed state the QuizScreen renders from. Modeled as one state
 * machine (Loading -> Quiz -> Results, with Error as a side branch) rather
 * than scattered booleans, so the UI can never render an invalid combination
 * (e.g. "loading" and "showing question 7" at once).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState;", "", "Error", "Loading", "Quiz", "Results", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Error;", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Loading;", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Quiz;", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Results;", "app_debug"})
public abstract interface QuizUiState {
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Error;", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Error implements com.dailyrounds.quizapp.ui.quiz.QuizUiState {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public Error(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dailyrounds.quizapp.ui.quiz.QuizUiState.Error copy(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Loading;", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Loading implements com.dailyrounds.quizapp.ui.quiz.QuizUiState {
        @org.jetbrains.annotations.NotNull()
        public static final com.dailyrounds.quizapp.ui.quiz.QuizUiState.Loading INSTANCE = null;
        
        private Loading() {
            super();
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u00a2\u0006\u0002\u0010\u000fJ\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\t\u0010\'\u001a\u00020\tH\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003J\t\u0010)\u001a\u00020\u0006H\u00c6\u0003J\t\u0010*\u001a\u00020\tH\u00c6\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u00c6\u0003Jl\u0010,\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u000100H\u00d6\u0003J\t\u00101\u001a\u00020\u0006H\u00d6\u0001J\t\u00102\u001a\u000203H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\"\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0011\u00a8\u00064"}, d2 = {"Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Quiz;", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState;", "questions", "", "Lcom/dailyrounds/quizapp/data/model/Question;", "currentIndex", "", "selectedOptionIndex", "isAnswerRevealed", "", "currentStreak", "longestStreak", "showStreakCelebration", "outcomes", "Lcom/dailyrounds/quizapp/ui/quiz/QuestionOutcome;", "(Ljava/util/List;ILjava/lang/Integer;ZIIZLjava/util/List;)V", "getCurrentIndex", "()I", "currentQuestion", "getCurrentQuestion", "()Lcom/dailyrounds/quizapp/data/model/Question;", "getCurrentStreak", "()Z", "isLastQuestion", "getLongestStreak", "getOutcomes", "()Ljava/util/List;", "questionNumber", "getQuestionNumber", "getQuestions", "getSelectedOptionIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowStreakCelebration", "totalQuestions", "getTotalQuestions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/util/List;ILjava/lang/Integer;ZIIZLjava/util/List;)Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Quiz;", "equals", "other", "", "hashCode", "toString", "", "app_debug"})
    public static final class Quiz implements com.dailyrounds.quizapp.ui.quiz.QuizUiState {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.dailyrounds.quizapp.data.model.Question> questions = null;
        private final int currentIndex = 0;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Integer selectedOptionIndex = null;
        private final boolean isAnswerRevealed = false;
        private final int currentStreak = 0;
        private final int longestStreak = 0;
        private final boolean showStreakCelebration = false;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.dailyrounds.quizapp.ui.quiz.QuestionOutcome> outcomes = null;
        
        public Quiz(@org.jetbrains.annotations.NotNull()
        java.util.List<com.dailyrounds.quizapp.data.model.Question> questions, int currentIndex, @org.jetbrains.annotations.Nullable()
        java.lang.Integer selectedOptionIndex, boolean isAnswerRevealed, int currentStreak, int longestStreak, boolean showStreakCelebration, @org.jetbrains.annotations.NotNull()
        java.util.List<? extends com.dailyrounds.quizapp.ui.quiz.QuestionOutcome> outcomes) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dailyrounds.quizapp.data.model.Question> getQuestions() {
            return null;
        }
        
        public final int getCurrentIndex() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getSelectedOptionIndex() {
            return null;
        }
        
        public final boolean isAnswerRevealed() {
            return false;
        }
        
        public final int getCurrentStreak() {
            return 0;
        }
        
        public final int getLongestStreak() {
            return 0;
        }
        
        public final boolean getShowStreakCelebration() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dailyrounds.quizapp.ui.quiz.QuestionOutcome> getOutcomes() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dailyrounds.quizapp.data.model.Question getCurrentQuestion() {
            return null;
        }
        
        public final int getQuestionNumber() {
            return 0;
        }
        
        public final int getTotalQuestions() {
            return 0;
        }
        
        public final boolean isLastQuestion() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dailyrounds.quizapp.data.model.Question> component1() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer component3() {
            return null;
        }
        
        public final boolean component4() {
            return false;
        }
        
        public final int component5() {
            return 0;
        }
        
        public final int component6() {
            return 0;
        }
        
        public final boolean component7() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.dailyrounds.quizapp.ui.quiz.QuestionOutcome> component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dailyrounds.quizapp.ui.quiz.QuizUiState.Quiz copy(@org.jetbrains.annotations.NotNull()
        java.util.List<com.dailyrounds.quizapp.data.model.Question> questions, int currentIndex, @org.jetbrains.annotations.Nullable()
        java.lang.Integer selectedOptionIndex, boolean isAnswerRevealed, int currentStreak, int longestStreak, boolean showStreakCelebration, @org.jetbrains.annotations.NotNull()
        java.util.List<? extends com.dailyrounds.quizapp.ui.quiz.QuestionOutcome> outcomes) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState$Results;", "Lcom/dailyrounds/quizapp/ui/quiz/QuizUiState;", "total", "", "correct", "skipped", "longestStreak", "(IIII)V", "getCorrect", "()I", "getLongestStreak", "getSkipped", "getTotal", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
    public static final class Results implements com.dailyrounds.quizapp.ui.quiz.QuizUiState {
        private final int total = 0;
        private final int correct = 0;
        private final int skipped = 0;
        private final int longestStreak = 0;
        
        public Results(int total, int correct, int skipped, int longestStreak) {
            super();
        }
        
        public final int getTotal() {
            return 0;
        }
        
        public final int getCorrect() {
            return 0;
        }
        
        public final int getSkipped() {
            return 0;
        }
        
        public final int getLongestStreak() {
            return 0;
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int component4() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dailyrounds.quizapp.ui.quiz.QuizUiState.Results copy(int total, int correct, int skipped, int longestStreak) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}