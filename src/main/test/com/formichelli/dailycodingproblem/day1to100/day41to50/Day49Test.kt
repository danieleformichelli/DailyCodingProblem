package com.formichelli.dailycodingproblem.day1to100.day41to50

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day49Test(private val result: Int, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(0, intArrayOf(-1, -2, -3, -4, -5)),
                    arrayOf(137, intArrayOf(34, -50, 42, 14, -5, 86)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Maximum sum of subarray for array $numbers should be $result", result, Day49.solution(numbers))
    }
}