package com.formichelli.dailycodingproblem.day1to100.day1to100.day61to70

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day64Test(private val result: Int, private val N: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(1, 1),
                    arrayOf(0, 2),
                    arrayOf(0, 3),
                    arrayOf(0, 4),
                    arrayOf(1728, 5))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("In a $N by $N chessboard there ${if (result != 1) "are" else "is"} $result knights' tours", result, Day64.solution(N))
    }
}