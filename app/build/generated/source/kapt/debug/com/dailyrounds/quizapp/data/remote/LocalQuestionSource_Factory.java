package com.dailyrounds.quizapp.data.remote;

import android.content.Context;
import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class LocalQuestionSource_Factory implements Factory<LocalQuestionSource> {
  private final Provider<Context> contextProvider;

  private final Provider<Moshi> moshiProvider;

  public LocalQuestionSource_Factory(Provider<Context> contextProvider,
      Provider<Moshi> moshiProvider) {
    this.contextProvider = contextProvider;
    this.moshiProvider = moshiProvider;
  }

  @Override
  public LocalQuestionSource get() {
    return newInstance(contextProvider.get(), moshiProvider.get());
  }

  public static LocalQuestionSource_Factory create(Provider<Context> contextProvider,
      Provider<Moshi> moshiProvider) {
    return new LocalQuestionSource_Factory(contextProvider, moshiProvider);
  }

  public static LocalQuestionSource newInstance(Context context, Moshi moshi) {
    return new LocalQuestionSource(context, moshi);
  }
}
