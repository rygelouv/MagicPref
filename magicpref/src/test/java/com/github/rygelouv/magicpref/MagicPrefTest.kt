package com.github.rygelouv.magicpref

import android.content.SharedPreferences
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Matchers.*
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


class MagicPrefUnitTest {

    private val KEY_NAME = "name"

    private val KEY_PHONE = "phone"

    private val TEST_NAME = "Nicole"

    private val TEST_PHONE = 761234567L


    @Mock
    var mockSharedPreferences: SharedPreferences? = null
    @Mock
    var mMockEditor: SharedPreferences.Editor? = null


    lateinit var numberPref: StringPref


    @Before
    fun initMocks() {
        MockitoAnnotations.initMocks(this)
        numberPref = createMockSharedPreference()
    }


    @Test
    fun stringPref_SaveAndReadValue() {
        class UserData {
            var name by numberPref
        }

        val userData = UserData()
        assertEquals(userData.name, TEST_NAME)
    }


    private fun createMockSharedPreference(): StringPref {
        // Mocking reading the SharedPreferences as if mockSharedPreferences was previously written
        // correctly.
        `when`(mockSharedPreferences?.getString(eq(KEY_NAME), anyString()))
            .thenReturn(TEST_NAME)
        `when`(mockSharedPreferences?.getLong(eq(KEY_PHONE), anyLong()))
            .thenReturn(TEST_PHONE)

        // Mocking a successful commit.
        `when`(mMockEditor?.commit()).thenReturn(true)

        // Return the MockEditor when requesting it.
        `when`(mockSharedPreferences?.edit()).thenReturn(mMockEditor)
        return StringPref(preferences = mockSharedPreferences)
    }
}
