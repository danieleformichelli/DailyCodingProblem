package com.formichelli.dailycodingproblem.day1to100.day1to100.day61to70

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day62Test(private val result: Int, private val N: Int, private val M: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(2, 2, 2),
                    arrayOf(3, 2, 3),
                    arrayOf(6, 3, 3),
                    arrayOf(70, 5, 5))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("In an $N by $M matrix there $result way to reach the bottom-right corner", result, Day62.solution(N, M))
    }
}