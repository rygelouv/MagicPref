package com.github.rygelouv.magicpref

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by rygelouv on 2019-12-13.
 * <p>
 * MagicPref
 * Copyright (c) 2019 Makeba Inc All rights reserved.
 */

object MagicPref {
    lateinit var sharePrefInstance: SharedPreferences
    private var mode = Context.MODE_PRIVATE
    private var prefFileName = javaClass.simpleName

    fun init(context: Context) {
        sharePrefInstance = SharedPreferenceFactory.newInstance(context, prefFileName, mode)
    }
}
