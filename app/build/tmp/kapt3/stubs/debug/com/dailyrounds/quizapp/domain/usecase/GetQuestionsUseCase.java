package com.dailyrounds.quizapp.domain.usecase;

/**
 * Thin use-case wrapper around the repository call.
 *
 * For a quiz th
 * is small, the ViewModel could call the repository directly --
 * but the JD explicitly lists "Clean Architecture" as a nice-to-have, and this
 * is the cheapest, most honest way to show that boundary: a single-purpose
 * class the ViewModel depends on instead of the data layer directly. If more
 * business rules show up later (e.g. shuffling questions, capping to N,
 * de-duplicating), they belong here, not in the ViewModel or repository.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086B\u00a2\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/dailyrounds/quizapp/domain/usecase/GetQuestionsUseCase;", "", "repository", "Lcom/dailyrounds/quizapp/data/repository/QuizRepository;", "(Lcom/dailyrounds/quizapp/data/repository/QuizRepository;)V", "invoke", "", "Lcom/dailyrounds/quizapp/data/model/Question;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetQuestionsUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.dailyrounds.quizapp.data.repository.QuizRepository repository = null;
    
    @javax.inject.Inject()
    public GetQuestionsUseCase(@org.jetbrains.annotations.NotNull()
    com.dailyrounds.quizapp.data.repository.QuizRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.dailyrounds.quizapp.data.model.Question>> $completion) {
        return null;
    }
}