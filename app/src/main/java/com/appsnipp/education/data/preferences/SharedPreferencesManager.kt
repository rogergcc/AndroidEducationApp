/*
 * Copyright (c) 2024. rogergcc
 */

package com.appsnipp.education.data.preferences

import android.content.Context
import android.content.SharedPreferences


/**
 * Created on mayo.
 * year 2024 .
 */
class SharedPreferencesManager(context: Context) {
    private val storage: SharedPreferences

    init {
        storage = context.getSharedPreferences(STORAGE, Context.MODE_PRIVATE)
    }

    fun isRated(itemId: Int): Boolean {
        return storage.getBoolean(itemId.toString(), false)
    }

    fun setRated(itemId: Int, isRated: Boolean) {
        storage.edit().putBoolean(itemId.toString(), isRated).apply()
    }

    companion object {
        private const val STORAGE = "shop"
    }
}