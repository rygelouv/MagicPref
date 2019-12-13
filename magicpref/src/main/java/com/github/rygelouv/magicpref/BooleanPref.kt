package com.github.rygelouv.magicpref

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by rygelouv on 2019-12-13.
 * <p>
 * MagicPref
 * Copyright (c) 2019 Makeba Inc All rights reserved.
 */


class BooleanPref(
    val key: String? = null,
    val defaultValue: Boolean = false,
    val preferences: SharedPreferences = MagicPref.sharePrefInstance
): PrefProperty<Boolean>() {
    override fun getValueFromPref(property: KProperty<*>): Boolean {
        return preferences.getBoolean(key, defaultValue)
    }

    override fun setValueToPref(property: KProperty<*>, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }
}

fun booleanPref(key: String? = null, defaultValue: Boolean = false): ReadWriteProperty<Any, Boolean> = BooleanPref(key, defaultValue)