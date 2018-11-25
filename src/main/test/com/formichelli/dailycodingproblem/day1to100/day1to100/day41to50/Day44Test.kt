package com.formichelli.dailycodingproblem.day1to100.day1to100.day41to50

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day44Test(private val result: Int, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            // Int.MIN_VALUE means pop
            return listOf<Array<Any>>(
                    arrayOf(3, intArrayOf(2, 4, 1, 3, 5)),
                    arrayOf(10, intArrayOf(5, 4, 3, 2, 1)),
                    arrayOf(0, intArrayOf(1, 2, 3, 4, 5)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("${Utils.prettyPrint(numbers)} has $result inversions", result, Day44.solution(numbers))
    }
}