package com.dailyrounds.quizapp.data.remote;

/**
 * Retrofit contract for fetching the quiz questions.
 *
 * The endpoint uses a full @Url instead of a fixed @GET("path") because the
 * source is a gist raw-content URL rather than a conventional REST endpoint --
 * Retrofit still needs *some* baseUrl to build against (see NetworkModule),
 * but the actual request goes wherever Constants.QUESTIONS_JSON_URL points.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/dailyrounds/quizapp/data/remote/QuizApiService;", "", "getQuestions", "", "Lcom/dailyrounds/quizapp/data/model/Question;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface QuizApiService {
    
    @retrofit2.http.GET()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getQuestions(@retrofit2.http.Url()
    @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dailyrounds.quizapp.data.model.Question>> $completion);
    
    /**
     * Retrofit contract for fetching the quiz questions.
     *
     * The endpoint uses a full @Url instead of a fixed @GET("path") because the
     * source is a gist raw-content URL rather than a conventional REST endpoint --
     * Retrofit still needs *some* baseUrl to build against (see NetworkModule),
     * but the actual request goes wherever Constants.QUESTIONS_JSON_URL points.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}