package com.example.tlo_par_navargs

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TloTest {
    @Test
    fun test1 ()  {
        val task1  = Tlo()
        task1.s1()
    }

    @Test
    fun test2() {
        val task2 = Tlo()
        task2.s2()
    }
}