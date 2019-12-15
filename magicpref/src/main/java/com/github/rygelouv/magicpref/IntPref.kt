package com.github.rygelouv.magicpref

import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * Created by rygelouv on 2019-12-13.
 * <p>
 * MagicPref
 */

internal class IntPref(
    private val key: String? = null,
    private val defaultValue: Int = 0,
    private val preferences: SharedPreferences? = MagicPref.sharePrefInstance
): PrefProperty<Int>() {
    override fun getValueFromPref(property: KProperty<*>): Int {
        return preferences?.getInt(key ?: property.name, defaultValue)!!
    }

    override fun setValueToPref(property: KProperty<*>, value: Int) {
        preferences?.edit()?.putInt(key ?: property.name, value)?.apply()
    }
}

fun intPref(key: String? = null, defaultValue: Int = 0): PrefProperty<Int> = IntPref(key, defaultValue)