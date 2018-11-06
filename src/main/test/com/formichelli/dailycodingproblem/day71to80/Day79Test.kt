package com.formichelli.dailycodingproblem.day71to80

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day79Test(private val result: Boolean, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(true, intArrayOf(10, 5, 7)),
                    arrayOf(true, intArrayOf(10, 11, 10, 20)),
                    arrayOf(true, intArrayOf(10, 11, 10)),
                    arrayOf(false, intArrayOf(10, 7, 5)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$numbers ${if (result) "can" else "cannot"} become non-decreasing by modifying at most 1 element", result, Day79.solution(numbers))
    }
}