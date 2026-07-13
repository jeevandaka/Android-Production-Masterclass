package com.dailyrounds.quizapp.di;

import com.dailyrounds.quizapp.data.remote.QuizApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NetworkModule_ProvideQuizApiServiceFactory implements Factory<QuizApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideQuizApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public QuizApiService get() {
    return provideQuizApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideQuizApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideQuizApiServiceFactory(retrofitProvider);
  }

  public static QuizApiService provideQuizApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideQuizApiService(retrofit));
  }
}
