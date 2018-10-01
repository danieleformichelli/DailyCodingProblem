package com.formichelli.dailycodingproblem

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day42Test(private val result: List<Int>, private val numbers: List<Int>, private val targetSum: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf(12, 9, 2, 1), listOf(12, 1, 61, 5, 9, 2), 24))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Sublist of $numbers that sums up to $targetSum is $result", result, Day42.solution(numbers, targetSum))
    }
}