package com.formichelli.dailycodingproblem.day1to100.day1to100.day91to100

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day95Test(private val result: List<Int>, private val number: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(listOf(1, 3, 2), listOf(1, 2, 3)),
                    arrayOf(listOf(2, 1, 3), listOf(1, 3, 2)),
                    arrayOf(listOf(1, 2, 3), listOf(3, 2, 1)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Next greater permutation of $number should be $result", result, Day95.solution(number))
    }
}