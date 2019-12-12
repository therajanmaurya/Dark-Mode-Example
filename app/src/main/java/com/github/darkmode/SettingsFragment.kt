package com.github.darkmode

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager


class SettingsFragment : PreferenceFragmentCompat() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var listPreference: ListPreference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
        listPreference = findPreference(getString(R.string.pref_key_night)) as ListPreference
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        setThemeTitle()
        listPreference.setOnPreferenceChangeListener { _, newValue ->
            updateTheme(NightMode.values()[listPreference.findIndexOfValue(newValue.toString())].value)
            true
        }

    }

    private fun updateTheme(nightMode: Int): Boolean {
        AppCompatDelegate.setDefaultNightMode(nightMode)
        requireActivity().recreate()
        return true
    }

    private fun setThemeTitle() {
        sharedPreferences.getString(
            getString(R.string.pref_key_night),
            getString(R.string.pref_night_auto)
        ).apply {
            when (this) {
                getString(R.string.pref_night_on) -> {
                    listPreference.title = getString(R.string.pref_night_title)
                }
                getString(R.string.pref_night_off) -> {
                    listPreference.title = getString(R.string.pref_day_title)
                }
                getString(R.string.pref_night_auto) -> {
                    listPreference.title = getString(R.string.pref_automatic_title)
                }
            }
        }
    }
}
