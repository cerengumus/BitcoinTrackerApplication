package com.cerengumus.bitcointrackerapp.data.repository.settings

import com.cerengumus.bitcointrackerapp.data.local.prefs.PreferenceStorage

/**
 * [SettingsRepository] is to manage preference for dark mode option
 */
class SettingsRepository(private val preferenceStorage: PreferenceStorage) {

    fun isDarkModeEnabled(): Boolean {
        return preferenceStorage.isDarkMode
    }

    fun setThemeMode(isDarkMode: Boolean) {
        preferenceStorage.isDarkMode = isDarkMode
    }
}