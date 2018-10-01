package com.formichelli.dailycodingproblem.day1to10

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day4Test(private val result: Int, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(2, intArrayOf(3, 4, -1, 1)),
                    arrayOf<Any>(3, intArrayOf(1, 2, 0)),
                    arrayOf<Any>(2, intArrayOf(1, 1, 1)),
                    arrayOf<Any>(1, intArrayOf(2, 3, 7, 6, 8, -1, -10, 15)),
                    arrayOf<Any>(4, intArrayOf(2, 3, -7, 6, 8, 1, -10, 15)),
                    arrayOf<Any>(2, intArrayOf(1, 1, 0, -1, -2))
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals(String.format("%s should map to %d", Utils.prettyPrint(numbers), result), result, Day4.solution(numbers))
    }
}