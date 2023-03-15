package com.example.tlo_par_navargs

import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class InstrumentedTest {


    @Test
    fun test1 ()  {
        val a = 20
        val task1  = Tlo()
        task1.s1()
        assertEquals("Wynik", 20, a)
    }
    @Test
    fun test2() {
        val task2 = Tlo()
        task2.s2()
    }
}