package com.formichelli.dailycodingproblem.day_31_40

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day33Test(private val result: List<Double>, private val numbers: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    // not possible
                    arrayOf(listOf(2.0, 1.5, 2.0, 3.5, 2.0, 2.0, 2.0), listOf(2, 1, 5, 7, 2, 0, 5)))
        }
    }

    @Test
    fun solution() {
        Assert.assertArrayEquals("Running medians of $numbers should be $result", result.toDoubleArray(), Day33.solution(numbers).toDoubleArray(), 0.1)
    }
}