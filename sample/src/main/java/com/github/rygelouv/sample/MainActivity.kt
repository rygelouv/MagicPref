package com.github.rygelouv.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.rygelouv.magicpref.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MagicPref.init(this)
        val user = UserInfo().apply {
            name = "Bernard Mamadou Diop"
            amount = 345.50.toFloat()
            code = 12
            isAdmin = true
            phoneNumber = 771234567
        }
    }
}


class UserInfo {
    var code: Int by intPref(key = "id")
    var name by stringPref()
    var amount by floatPref(defaultValue = 19.0F)
    var phoneNumber by longPref()
    var isAdmin by booleanPref()
}
