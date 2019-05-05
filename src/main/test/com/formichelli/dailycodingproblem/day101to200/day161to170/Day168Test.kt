package com.formichelli.dailycodingproblem.day101to200.day161to170

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day168Test(private val result: Array<Array<Int>>, private val matrix: Array<Array<Int>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val threeByThreeMatrix = arrayOf(
                    arrayOf(1, 2, 3),
                    arrayOf(4, 5, 6),
                    arrayOf(7, 8, 9))
            val rotatedThreeByThreeMatrix = arrayOf(
                    arrayOf(7, 4, 1),
                    arrayOf(8, 5, 2),
                    arrayOf(9, 6, 3))
            val fourByFourMatrix = arrayOf(
                    arrayOf(1, 2, 3, 4),
                    arrayOf(5, 6, 7, 8),
                    arrayOf(9, 10, 11, 12),
                    arrayOf(3, 14, 15, 16))
            val rotatedFourByFourMatrix = arrayOf(
                    arrayOf(3, 9, 5, 1),
                    arrayOf(14, 10, 6, 2),
                    arrayOf(15, 11, 7, 3),
                    arrayOf(16, 12, 8, 4))

            return listOf(
                    arrayOf<Any>(rotatedThreeByThreeMatrix, threeByThreeMatrix),
                    arrayOf<Any>(rotatedFourByFourMatrix, fourByFourMatrix))
        }
    }

    @Test
    fun solution() {
        Assert.assertArrayEquals("Rotated ${Utils.prettyPrint(matrix)} is ${Utils.prettyPrint(result)}", result, Day168.solution(matrix))
    }
}