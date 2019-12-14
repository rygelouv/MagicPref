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

    @Mock
    var mockSharedPreferences: SharedPreferences? = null
    @Mock
    var mMockEditor: SharedPreferences.Editor? = null

    lateinit var textPref: StringPref
    lateinit var numberPref: IntPref
    lateinit var floatNumberPref: FloatPref


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        textPref = createMockSharedPreferenceForStringPref()
        numberPref = createMockSharedPreferenceForIntPref()
        floatNumberPref = createMockSharedPreferenceForFloatPref()
    }


    @Test
    fun stringPref_SaveAndReadValue() {
        class UserData {
            var name by textPref
        }

        val userData = UserData()
        assertEquals(userData.name, TEST_NAME)
    }


    @Test
    fun intPref_SaveAndReadValue() {
        class UserData {
            var id by numberPref
        }

        val userData = UserData()
        assertEquals(userData.id, TEST_ID)
    }


    @Test
    fun floatPref_SaveAndReadValue() {
        class UserData {
            var amount by floatNumberPref
        }

        val userData = UserData()
        assertEquals(userData.amount, TEST_AMOUNT)
    }


    private fun createMockSharedPreferenceForStringPref(): StringPref {
        // Mocking reading the SharedPreferences as if mockSharedPreferences was previously written
        // correctly.
        `when`(mockSharedPreferences?.getString(eq(KEY_NAME), anyString()))
            .thenReturn(TEST_NAME)

        // Mocking a successful commit.
        `when`(mMockEditor?.commit()).thenReturn(true)

        // Return the MockEditor when requesting it.
        `when`(mockSharedPreferences?.edit()).thenReturn(mMockEditor)
        return StringPref(preferences = mockSharedPreferences)
    }

    private fun createMockSharedPreferenceForIntPref(): IntPref {
        `when`(mockSharedPreferences?.getInt(eq(KEY_ID), anyInt()))
            .thenReturn(TEST_ID)
        /*`when`(mockSharedPreferences?.getLong(eq(KEY_PHONE), anyLong()))
            .thenReturn(TEST_PHONE)*/

        `when`(mMockEditor?.commit()).thenReturn(true)

        `when`(mockSharedPreferences?.edit()).thenReturn(mMockEditor)
        return IntPref(preferences = mockSharedPreferences)
    }

    private fun createMockSharedPreferenceForFloatPref(): FloatPref {
        `when`(mockSharedPreferences?.getFloat(eq(KEY_AMOUNT), anyFloat()))
            .thenReturn(TEST_AMOUNT)

        `when`(mMockEditor?.commit()).thenReturn(true)

        `when`(mockSharedPreferences?.edit()).thenReturn(mMockEditor)
        return FloatPref(preferences = mockSharedPreferences)
    }
}
