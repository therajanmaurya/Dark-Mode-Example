package com.github.darkmode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.darkmode.SettingsFragment

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, SettingsFragment())
            .commit()
    }
}
