package com.github.rygelouv.magicpref

import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * Created by rygelouv on 2019-12-13.
 * <p>
 * MagicPref
 */

/**
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */


internal class FloatPref(
    private val key: String? = null,
    private val defaultValue: Float = 0F,
    private val preferences: SharedPreferences? = MagicPref.sharePrefInstance
) : PrefProperty<Float>() {
    override fun getValueFromPref(property: KProperty<*>): Float {
        return preferences?.getFloat(key ?: property.name, defaultValue)!!
    }

    override fun setValueToPref(property: KProperty<*>, value: Float) {
        preferences?.edit()?.putFloat(key ?: property.name, value)?.apply()
    }
}

fun floatPref(key: String? = null, defaultValue: Float = 0F): PrefProperty<Float> = FloatPref(key, defaultValue)