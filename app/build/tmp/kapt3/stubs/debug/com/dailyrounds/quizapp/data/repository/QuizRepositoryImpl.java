package com.dailyrounds.quizapp.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/dailyrounds/quizapp/data/repository/QuizRepositoryImpl;", "Lcom/dailyrounds/quizapp/data/repository/QuizRepository;", "api", "Lcom/dailyrounds/quizapp/data/remote/QuizApiService;", "localSource", "Lcom/dailyrounds/quizapp/data/remote/LocalQuestionSource;", "(Lcom/dailyrounds/quizapp/data/remote/QuizApiService;Lcom/dailyrounds/quizapp/data/remote/LocalQuestionSource;)V", "getQuestions", "", "Lcom/dailyrounds/quizapp/data/model/Question;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class QuizRepositoryImpl implements com.dailyrounds.quizapp.data.repository.QuizRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.dailyrounds.quizapp.data.remote.QuizApiService api = null;
    @org.jetbrains.annotations.NotNull()
    private final com.dailyrounds.quizapp.data.remote.LocalQuestionSource localSource = null;
    
    @javax.inject.Inject()
    public QuizRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.dailyrounds.quizapp.data.remote.QuizApiService api, @org.jetbrains.annotations.NotNull()
    com.dailyrounds.quizapp.data.remote.LocalQuestionSource localSource) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getQuestions(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dailyrounds.quizapp.data.model.Question>> $completion) {
        return null;
    }
}