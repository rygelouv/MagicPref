package com.github.rygelouv.magicpref

import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * Created by rygelouv on 2019-12-13.
 * <p>
 * MagicPref
 * Copyright (c) 2019 Makeba Inc All rights reserved.
 */

class StringPref(
    val key: String? = null,
    val defaultValue: String? = "",
    val preferences: SharedPreferences? = MagicPref.sharePrefInstance
): PrefProperty<String?>() {
    override fun getValueFromPref(property: KProperty<*>): String? {
        return preferences?.getString(key ?: property.name, defaultValue)
    }

    override fun setValueToPref(property: KProperty<*>, value: String?) {
        preferences?.edit()?.putString(key ?: property.name, value)?.apply()
    }
}


fun stringPref(key: String? = null, defaultValue: String? = ""): PrefProperty<String?> = StringPref(key, defaultValue)