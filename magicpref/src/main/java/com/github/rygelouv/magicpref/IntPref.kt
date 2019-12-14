package com.github.rygelouv.magicpref

import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * Created by rygelouv on 2019-12-13.
 * <p>
 * MagicPref
 * Copyright (c) 2019 Makeba Inc All rights reserved.
 */

class IntPref(
    val key: String? = null,
    val defaultValue: Int = 0,
    val preferences: SharedPreferences? = MagicPref.sharePrefInstance
): PrefProperty<Int>() {
    override fun getValueFromPref(property: KProperty<*>): Int {
        return preferences?.getInt(key ?: property.name, defaultValue)!!
    }

    override fun setValueToPref(property: KProperty<*>, value: Int) {
        preferences?.edit()?.putInt(key ?: property.name, value)?.apply()
    }
}

fun intPref(key: String? = null, defaultValue: Int = 0): PrefProperty<Int> = IntPref(key, defaultValue)