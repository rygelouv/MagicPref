package com.github.rygelouv.magicpref

import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * Created by rygelouv on 2019-12-13.
 * <p>
 * MagicPref
 * Copyright (c) 2019 Makeba Inc All rights reserved.
 */

class LongPref(
    val key: String? = null,
    val defaultValue: Long = 0L,
    val preferences: SharedPreferences = MagicPref.sharePrefInstance
): PrefProperty<Long>() {
    override fun getValueFromPref(property: KProperty<*>): Long {
        return preferences.getLong(key ?: property.name, defaultValue)
    }

    override fun setValueToPref(property: KProperty<*>, value: Long) {
        preferences.edit().putLong(key ?: property.name, value).apply()
    }
}

fun longPref(key: String? = null, defaultValue: Long = 0L): PrefProperty<Long> = LongPref(key, defaultValue)