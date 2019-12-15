# MagicPref

[![Build Status](https://travis-ci.org/rygelouv/MagicPref.svg?branch=master)](https://travis-ci.org/rygelouv/MagicPref)
[![](https://jitpack.io/v/rygelouv/magicpref.svg)](https://jitpack.io/#rygelouv/magicpref)

MagicPref is an Android library that uses the power of Kotlin delegation to simplify
the use of Android Shared Preferences. It also make use of the brand new EncryptedSharedPreferences (still in alpha) from the AndroidX security library
If the library is used on Android M or higher it uses EncryptSharedPreferences otherwise it falls back to the default SharedPreferences

**MagicPref is a simpler version of [KotPref](https://github.com/chibatching/Kotpref) a very powerfull library that has the same goal except for the EncryptedSharedPreferences**


## Install it
Add it to your build.gradle with:
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
and:

```gradle
dependencies {
    implementation 'com.github.rygelouv:magicpref:0.0.1-alpha'
}
```


## Use it

It's simple, really. Just like using a lazy delegate

```java
    class UserInfo {
        var code: Int by intPref(key = "id")
        var name by stringPref()
        var amount by floatPref(defaultValue = 19.0F)
        var phoneNumber by longPref()
        var isAdmin by booleanPref()
    }

    val user = UserInfo().apply {
                name = "Bernard Mamadou Diop"
                amount = 345.50.toFloat()
                code = 12
                isAdmin = true
                phoneNumber = 771234567
            }
```

## TODO
- Make MagicPref.sharePrefInstance private and wrap it in a clean form
- Run on release mode to check proguard issues
- Maybe more test


License
--------


    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.