package com.formichelli.dailycodingproblem.day1to100.day1to100.day41to50

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day42Test(private val result: List<Int>?, private val numbers: List<Int>, private val targetSum: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf<Array<Any?>>(
                    arrayOf(listOf(12, 9, 2, 1), listOf(12, 1, 61, 5, 9, 2), 24),
                    arrayOf(null, listOf(12, 1, 61, 5, 9, 2), 36),
                    arrayOf(listOf(12, 12, 9, 2, 1), listOf(12, 1, 61, 5, 9, 2, 12), 36),
                    arrayOf(listOf(61, 12, 9, 5, 2), listOf(12, 1, 61, 5, 9, 2), 89))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Sublist of $numbers that sums up to $targetSum is $result", result, Day42.solution(numbers, targetSum))
    }
}