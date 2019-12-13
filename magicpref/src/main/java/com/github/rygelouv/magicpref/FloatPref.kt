package com.github.rygelouv.magicpref

import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * Created by rygelouv on 2019-12-13.
 * <p>
 * MagicPref
 * Copyright (c) 2019 Makeba Inc All rights reserved.
 */

class FloatPref(
    val key: String? = null,
    val defaultValue: Float = 0F,
    val preferences: SharedPreferences? = MagicPref.sharePrefInstance
) : PrefProperty<Float>() {
    override fun getValueFromPref(property: KProperty<*>): Float {
        return preferences?.getFloat(key ?: property.name, defaultValue)!!
    }

    override fun setValueToPref(property: KProperty<*>, value: Float) {
        preferences?.edit()?.putFloat(key ?: property.name, value)?.apply()
    }
}

fun floatPref(key: String? = null, defaultValue: Float = 0F): PrefProperty<Float> = FloatPref(key, defaultValue)