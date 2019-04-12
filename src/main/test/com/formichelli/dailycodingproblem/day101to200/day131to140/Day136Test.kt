package com.formichelli.dailycodingproblem.day101to200.day131to140

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day136Test(private val result: Int, private val matrix: Array<IntArray>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val matrix1 = arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(1, 0, 1, 1),
                    intArrayOf(1, 0, 1, 1),
                    intArrayOf(0, 1, 0, 0))

            val matrix2 = arrayOf(
                    intArrayOf(0, 1, 1, 0),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 1, 1, 1))

            return listOf(
                    arrayOf<Any>(4, matrix1),
                    arrayOf<Any>(9, matrix2))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Biggest ones rectangle has size $result", result, Day136.solution(matrix))
    }
}