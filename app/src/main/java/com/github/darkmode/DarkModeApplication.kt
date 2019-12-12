package com.github.darkmode

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import java.util.Locale

class DarkModeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val preferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        preferences.getString(
            getString(R.string.pref_key_night),
            getString(R.string.pref_night_auto)
        )?.apply {
            val mode = NightMode.valueOf(this.toUpperCase(Locale.US))
            AppCompatDelegate.setDefaultNightMode(mode.value)
        }
    }
}