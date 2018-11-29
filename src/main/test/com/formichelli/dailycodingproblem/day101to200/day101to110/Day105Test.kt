package com.formichelli.dailycodingproblem.day101to200.day101to110

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

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
        var callsCount = -1
        val f: () -> Any = {
            ++callsCount
        }
        val debounced = Day105.solution(f, N)
        val intervals = intArrayOf(1, N / 4, N / 3, N / 2, 2 * N, 3 * N, 1, 2 * N)
        debounced()
        intervals.forEach { interval ->
            val callsCountBefore = callsCount
            val expectedCallsCountAfter = if (interval > N) callsCountBefore + 1 else callsCountBefore
            Thread.sleep(interval.toLong())
            debounced()
            Assert.assertEquals("Function should be called if the interval is $interval", expectedCallsCountAfter, callsCount)
        }
    }
}