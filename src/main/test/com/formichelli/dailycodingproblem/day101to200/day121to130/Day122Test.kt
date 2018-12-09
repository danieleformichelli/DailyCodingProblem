package com.formichelli.dailycodingproblem.day101to200.day121to130

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day122Test(private val result: Int, private val coins: Array<IntArray>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(12, arrayOf(intArrayOf(0, 3, 1, 1), intArrayOf(2, 0, 0, 4), intArrayOf(1, 5, 3, 1))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("A maximum of $result coins can be collected from ${Utils.prettyPrint(coins)}", result, Day122.solution(coins))
    }
}