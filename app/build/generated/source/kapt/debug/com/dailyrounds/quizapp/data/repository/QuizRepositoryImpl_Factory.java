package com.dailyrounds.quizapp.data.repository;

import com.dailyrounds.quizapp.data.remote.LocalQuestionSource;
import com.dailyrounds.quizapp.data.remote.QuizApiService;
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
public final class QuizRepositoryImpl_Factory implements Factory<QuizRepositoryImpl> {
  private final Provider<QuizApiService> apiProvider;

  private final Provider<LocalQuestionSource> localSourceProvider;

  public QuizRepositoryImpl_Factory(Provider<QuizApiService> apiProvider,
      Provider<LocalQuestionSource> localSourceProvider) {
    this.apiProvider = apiProvider;
    this.localSourceProvider = localSourceProvider;
  }

  @Override
  public QuizRepositoryImpl get() {
    return newInstance(apiProvider.get(), localSourceProvider.get());
  }

  public static QuizRepositoryImpl_Factory create(Provider<QuizApiService> apiProvider,
      Provider<LocalQuestionSource> localSourceProvider) {
    return new QuizRepositoryImpl_Factory(apiProvider, localSourceProvider);
  }

  public static QuizRepositoryImpl newInstance(QuizApiService api,
      LocalQuestionSource localSource) {
    return new QuizRepositoryImpl(api, localSource);
  }
}
