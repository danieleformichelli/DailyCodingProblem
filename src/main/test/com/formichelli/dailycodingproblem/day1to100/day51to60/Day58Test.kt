package com.formichelli.dailycodingproblem.day1to100.day51to60

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day58Test(private val result: Int, private val numbers: IntArray, private val element: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(-1, intArrayOf(13, 18, 25, 2, 8, 10), 1),
                    arrayOf(0, intArrayOf(13, 18, 25, 2, 8, 10), 13),
                    arrayOf(1, intArrayOf(13, 18, 25, 2, 8, 10), 18),
                    arrayOf(2, intArrayOf(13, 18, 25, 2, 8, 10), 25),
                    arrayOf(3, intArrayOf(13, 18, 25, 2, 8, 10), 2),
                    arrayOf(4, intArrayOf(13, 18, 25, 2, 8, 10), 8),
                    arrayOf(5, intArrayOf(13, 18, 25, 2, 8, 10), 10),
                    arrayOf(-1, intArrayOf(13, 18, 25, 2, 8, 10), 30))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Index of $element in ${Utils.prettyPrint(numbers)} should be $result", result, Day58.solution(numbers, element))
    }
}