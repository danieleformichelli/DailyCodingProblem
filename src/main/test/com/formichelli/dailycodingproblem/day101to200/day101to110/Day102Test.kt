package com.formichelli.dailycodingproblem.day101to200.day101to110

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day102Test(private val result: List<Int>, private val numbers: List<Int>, private val K: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf(2, 3, 4), listOf(1, 2, 3, 4, 5), 9),
                    arrayOf(listOf(1, 2), listOf(1, 2, 3, 4, 5), 3),
                    arrayOf(listOf(1, 2, 3, 4, 5), listOf(1, 2, 3, 4, 5), 15),
                    arrayOf(listOf(2, 3, 4, 5), listOf(1, 2, 3, 4, 5), 14))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$result is the subsequence of $numbers that sums to $K", result, Day102.solution(numbers, K))
    }
}