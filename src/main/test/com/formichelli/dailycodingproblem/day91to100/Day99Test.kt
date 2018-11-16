package com.formichelli.dailycodingproblem.day91to100

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day99Test(private val result: Int, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(4, intArrayOf(100, 4, 200, 1, 3, 2)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("The longest consecutive elements sequence of ${Utils.prettyPrint(numbers)} should be of length $result", result, Day99.solution(numbers))
    }
}