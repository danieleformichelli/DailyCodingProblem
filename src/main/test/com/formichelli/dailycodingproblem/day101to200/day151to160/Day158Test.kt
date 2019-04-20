package com.formichelli.dailycodingproblem.day101to200.day151to160

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day158Test(private val result: Int, private val matrix: Array<IntArray>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val matrix1 = arrayOf(
                    intArrayOf(0, 0, 1),
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 0, 0))
            val matrix2 = arrayOf(
                    intArrayOf(0, 0, 1),
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 0, 0))

            return listOf(
                    arrayOf<Any>(2, matrix1),
                    arrayOf<Any>(5, matrix2))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("There are $result ways to move from origin to end of ${Utils.prettyPrint(matrix)}", result, Day158.solution(matrix))
    }
}