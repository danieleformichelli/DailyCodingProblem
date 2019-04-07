package com.formichelli.dailycodingproblem.day101to200.day121to130

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day130Test(private val result: Int, private val prices: IntArray, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf<Array<Any?>>(
                    arrayOf(3, intArrayOf(5, 2, 4, 0, 1), 2),
                    arrayOf(38, intArrayOf(5, 10, 2, 25, 27, 35), 2),
                    arrayOf(33, intArrayOf(20, 10, 2, 25, 27, 35), 2))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("The maximum profit of $k transaction given prices ${prices.joinToString(", ", "[", "]")} is $result", result, Day130.solution(prices, k))
    }
}