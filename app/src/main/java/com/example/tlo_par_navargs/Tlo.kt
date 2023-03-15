package com.example.tlo_par_navargs

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class Tlo {
    fun s1() = runBlocking {
        println("s1 START")
        launch(Dispatchers.Default) {
            delay(2000L)
            println("s1: jeden")
        }
        val job1 = launch {
            delay(1000L)
            println("s2: dwa")
        }
        job1.join()
        println("s3: trzy")
        println("s1 STOP")
    }

    private suspend fun s10(a:Int):Int {
        var z = a
        for (i in 1..10) {
            z = i * a
            delay(10L)
        }
        return z
    }

    fun s2() = runBlocking {
        println("s2 START")
        val time = measureTimeMillis {
            val s2_a1 = async(start = CoroutineStart.LAZY) { s10(20) }
            val s2_a3 = async { s10(10) }
            val s2_a2 = async(start = CoroutineStart.LAZY) { s10(10) }
            val s2_a4 = async { s10(5) }
            s2_a1.start()
            s2_a2.start()

            val z3 = s2_a3.await()
            val z4 = s2_a4.await()

            println("a2: Odpowiedź jest ${s2_a1.await() + s2_a2.await()}")
            println("a2: Odpowiedź jest ${z3 + z4}")
        }
        println("s2: czas obliczeń = $time ms")
        println("s2 STOP")
    }

}