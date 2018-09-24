package com.formichelli.dailycodingproblem

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day32Test(private val result: Boolean, private val exchangeRates: Array<DoubleArray>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    // not possible
                    arrayOf(false, arrayOf(doubleArrayOf(1.0, 1.0), doubleArrayOf(1.0, 1.0))),
                    // not possible
                    arrayOf(false, arrayOf(doubleArrayOf(1.0, 2.0, 3.0), doubleArrayOf(1.0, 2.0, 3.0), doubleArrayOf(1.0, 2.0, 3.0))),
                    // 1 -> 2 -> 1
                    arrayOf(true, arrayOf(doubleArrayOf(1.0, 1.9), doubleArrayOf(0.5, 1.0))),
                    // 1 -> 3 -> 2 -> 1
                    arrayOf(true, arrayOf(doubleArrayOf(1.0, 10000000.1, 100.0), doubleArrayOf(0.0001, 1.0, 3.0), doubleArrayOf(1.0, 10.0, 1.0))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Arbitrage ${if (result) "is" else "is not"} possible on the given exchange matrix", result, Day32.solution(exchangeRates))
    }
}