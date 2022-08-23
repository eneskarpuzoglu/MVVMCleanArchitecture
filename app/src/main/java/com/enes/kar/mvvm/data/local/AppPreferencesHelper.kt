package com.enes.kar.mvvm.data.local

import android.content.Context
import androidx.preference.PreferenceManager
import com.enes.kar.mvvm.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Created by M.Enes on 4.06.2022.
 */
class AppPreferencesHelper @Inject constructor(@ApplicationContext private val context: Context): PreferencesHelper {

    val mPrefs = PreferenceManager.getDefaultSharedPreferences(context)

    override fun isDarkTheme(): Boolean = mPrefs.getBoolean(context.getString(R.string.PREF_KEY_DARK_THEME),false)
    override fun setDarkTheme(boolean: Boolean) {
        mPrefs.edit().putBoolean(context.getString(R.string.PREF_KEY_DARK_THEME), boolean).apply()
    }
}