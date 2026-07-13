# QuizApp

A modern Android Quiz Application built with Jetpack Compose, following Clean Architecture principles and utilizing the latest Android development practices.

## Features

- **Dynamic Quiz Flow**: Interactive 10-question quiz fetched from a remote source.
- **Real-time Feedback**: Instant visual feedback for correct and incorrect answers.
- **Streak System**: Tracks consecutive correct answers with a celebration milestone every 3 correct answers.
- **Progress Tracking**: Visual progress bar and status dots to keep track of the quiz journey.
- **Animations**: Smooth transitions using `AnimatedContent` and `animateColorAsState` for an engaging UI.
- **Results Summary**: Comprehensive end-of-quiz statistics including score, longest streak, and skipped questions.
- **Offline Support**: Robust fallback mechanism to local JSON assets if the network is unavailable.

## Tech Stack

- **UI**: [Jetpack Compose](https://developer.android.com/jetpack/compose) for a fully declarative UI.
- **Architecture**: MVVM (Model-View-ViewModel) combined with Clean Architecture (Domain, Data, and UI layers).
- **Dependency Injection**: [Hilt](https://dagger.dev/hilt/) for clean and scalable DI.
- **Networking**: [Retrofit](https://square.github.io/retrofit/) with [Moshi](https://github.com/square/moshi) for API communication and JSON parsing.
- **Coroutines & Flow**: [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) and `StateFlow` for asynchronous programming and reactive UI updates.
- **Lifecycle**: `collectAsStateWithLifecycle` for lifecycle-aware state collection in Compose.

## Project Structure

- `data/`: Contains the Repository implementation, Remote API service, and Local data source.
- `domain/`: Business logic layer containing the Use Cases and Domain models.
- `ui/`: UI layer containing Composables, ViewModels, and App Theme.
  - `components/`: Reusable UI elements (Buttons, Progress indicators, etc.).
  - `quiz/`: Main quiz screen and logic.
  - `results/`: Performance summary screen.
  - `theme/`: Material 3 design system implementation.
- `util/`: Constants and utility classes.

## Getting Started

1. Clone the repository.
2. Open the project in **Android Studio (Hedgehog or newer)**.
3. Sync the project with Gradle files.
4. Run the app on an emulator or a physical device (API 24+).

## Configuration

The app's behavior can be tweaked in `com.dailyrounds.quizapp.util.Constants.kt`:
- `QUESTIONS_JSON_URL`: The endpoint for fetching questions.
- `ANSWER_REVEAL_DELAY_MS`: Duration for showing the correct answer before auto-advancing (default: 2000ms).
- `STREAK_THRESHOLD`: The number of correct answers required for a streak celebration (default: 3).

## License

This project is licensed under the MIT License - see the LICENSE file for details.
