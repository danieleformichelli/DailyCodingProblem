package com.formichelli.dailycodingproblem.day1to100.day1to100.day71to80

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day75Test(private val result: Int, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(6, intArrayOf(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("${Utils.prettyPrint(numbers)} longest increasing substring should have length $result", result, Day75.solution(numbers))
    }
}