package com.formichelli.dailycodingproblem.day101to200.day101to110

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

@RunWith(Parameterized::class)
class Day105Test(private val N: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(10))
        }
    }

    @Test
    fun solution() {
        val lastCallTime = AtomicLong(System.nanoTime())
        val callsCount = AtomicInteger(0)
        val nanoInterval = N * TimeUnit.MILLISECONDS.toNanos(1)
        val f: () -> Any = {
            val currentTime = System.nanoTime()
            val timeDifference = Math.abs(currentTime - lastCallTime.getAndSet(currentTime))
            callsCount.incrementAndGet()
            Assert.assertTrue("Interval should not be further than 10% from N", timeDifference < 0.1 * nanoInterval)
        }
        Day105.solution(f, N)
        for (i in 0..10) {
            f()
        }

        while (callsCount.get() < 10) {
            // wait
        }
    }
}