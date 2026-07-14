package com.dailyrounds.quizapp.core

import com.google.firebase.crashlytics.FirebaseCrashlytics

object CrashLogger {
    private val crashlytics = FirebaseCrashlytics.getInstance()

    fun log(message: String) {
        crashlytics.log(message)
    }

    fun recordException(exception: Throwable) {
        crashlytics.recordException(exception)
    }

    fun setUserId(userId: String) {
        crashlytics.setUserId(userId)
    }

    fun setCustomKey(key: String, value: String) {
        crashlytics.setCustomKey(key, value)
    }
}