package com.github.rygelouv.magicpref

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by rygelouv on 2019-12-09.
 * <p>
 * Makeba Applications
 * Copyright (c) 2019 Makeba Inc All rights reserved.
 */

abstract class PrefProperty<T> : ReadWriteProperty<Any, T> {

    override operator fun getValue(thisRef: Any, property: KProperty<*>): T = getValueFromPref(property)
    override operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        setValueToPref(property, value)
    }

    abstract fun getValueFromPref(property: KProperty<*>): T
    abstract fun setValueToPref(property: KProperty<*>, value: T)
}

