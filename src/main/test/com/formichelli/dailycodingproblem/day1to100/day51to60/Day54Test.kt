package com.formichelli.dailycodingproblem.day1to100.day51to60

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day54Test(private val result: Array<IntArray>, private val inputTable: Array<IntArray>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val input1 = arrayOf(
                    intArrayOf(0, 0, 0, 2, 6, 0, 7, 0, 1),
                    intArrayOf(6, 8, 0, 0, 7, 0, 0, 9, 0),
                    intArrayOf(1, 9, 0, 0, 0, 4, 5, 0, 0),
                    intArrayOf(8, 2, 0, 1, 0, 0, 0, 4, 0),
                    intArrayOf(0, 0, 4, 6, 0, 2, 9, 0, 0),
                    intArrayOf(0, 5, 0, 0, 0, 3, 0, 2, 8),
                    intArrayOf(0, 0, 9, 3, 0, 0, 0, 7, 4),
                    intArrayOf(0, 4, 0, 0, 5, 0, 0, 3, 6),
                    intArrayOf(7, 0, 3, 0, 1, 8, 0, 0, 0))

            val solution1 = arrayOf(
                    intArrayOf(4, 3, 5, 2, 6, 9, 7, 8, 1),
                    intArrayOf(6, 8, 2, 5, 7, 1, 4, 9, 3),
                    intArrayOf(1, 9, 7, 8, 3, 4, 5, 6, 2),
                    intArrayOf(8, 2, 6, 1, 9, 5, 3, 4, 7),
                    intArrayOf(3, 7, 4, 6, 8, 2, 9, 1, 5),
                    intArrayOf(9, 5, 1, 7, 4, 3, 6, 2, 8),
                    intArrayOf(5, 1, 9, 3, 2, 6, 8, 7, 4),
                    intArrayOf(2, 4, 8, 9, 5, 7, 1, 3, 6),
                    intArrayOf(7, 6, 3, 4, 1, 8, 2, 5, 9))

            val input2 = arrayOf(
                    intArrayOf(0, 2, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 6, 0, 0, 0, 0, 3),
                    intArrayOf(0, 7, 4, 0, 8, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 3, 0, 0, 2),
                    intArrayOf(0, 8, 0, 0, 4, 0, 0, 1, 0),
                    intArrayOf(6, 0, 0, 5, 0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 1, 0, 7, 8, 0),
                    intArrayOf(5, 0, 0, 0, 0, 9, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 4, 0))

            val solution2 = arrayOf(
                    intArrayOf(1, 2, 6, 4, 3, 7, 9, 5, 8),
                    intArrayOf(8, 9, 5, 6, 2, 1, 4, 7, 3),
                    intArrayOf(3, 7, 4, 9, 8, 5, 1, 2, 6),
                    intArrayOf(4, 5, 7, 1, 9, 3, 8, 6, 2),
                    intArrayOf(9, 8, 3, 2, 4, 6, 5, 1, 7),
                    intArrayOf(6, 1, 2, 5, 7, 8, 3, 9, 4),
                    intArrayOf(2, 6, 9, 3, 1, 4, 7, 8, 5),
                    intArrayOf(5, 4, 8, 7, 6, 9, 2, 3, 1),
                    intArrayOf(7, 3, 1, 8, 5, 2, 6, 4, 9))

            return listOf<Array<Any>>(
                    arrayOf(solution1, input1),
                    arrayOf(solution1, solution1),
                    arrayOf(solution2, input2))
        }
    }

    @Test
    fun solution() {
        Day54.solution(inputTable)
        for (i in 0 until result.size) {
            Assert.assertArrayEquals("Row ${i + 1} should be ${Utils.prettyPrint(result[i])}", result[i], inputTable[i])
        }
    }
}