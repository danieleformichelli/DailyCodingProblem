package com.formichelli.dailycodingproblem.day1to100.day1to100.day61to70

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day65Test(private val result: List<Int>, private val matrix: Array<IntArray>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf(1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12),
                            arrayOf(intArrayOf(1, 2, 3, 4, 5),
                                    intArrayOf(6, 7, 8, 9, 10),
                                    intArrayOf(11, 12, 13, 14, 15),
                                    intArrayOf(16, 17, 18, 19, 20))),
                    arrayOf(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25),
                            arrayOf(intArrayOf(1, 2, 3, 4, 5),
                                    intArrayOf(16, 17, 18, 19, 6),
                                    intArrayOf(15, 24, 25, 20, 7),
                                    intArrayOf(14, 23, 22, 21, 8),
                                    intArrayOf(13, 12, 11, 10, 9))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Spiral print of the matrix should be $result", result, Day65.solution(matrix))
    }
}