package com.dailyrounds.quizapp.ui.quiz;

import com.dailyrounds.quizapp.domain.usecase.GetQuestionsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class QuizViewModel_Factory implements Factory<QuizViewModel> {
  private final Provider<GetQuestionsUseCase> getQuestionsUseCaseProvider;

  public QuizViewModel_Factory(Provider<GetQuestionsUseCase> getQuestionsUseCaseProvider) {
    this.getQuestionsUseCaseProvider = getQuestionsUseCaseProvider;
  }

  @Override
  public QuizViewModel get() {
    return newInstance(getQuestionsUseCaseProvider.get());
  }

  public static QuizViewModel_Factory create(
      Provider<GetQuestionsUseCase> getQuestionsUseCaseProvider) {
    return new QuizViewModel_Factory(getQuestionsUseCaseProvider);
  }

  public static QuizViewModel newInstance(GetQuestionsUseCase getQuestionsUseCase) {
    return new QuizViewModel(getQuestionsUseCase);
  }
}
