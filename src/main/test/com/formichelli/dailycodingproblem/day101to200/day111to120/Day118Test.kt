package com.formichelli.dailycodingproblem.day101to200.day111to120

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day118Test(private val result: List<Int>, private val numbers: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(listOf(0, 4, 4, 9, 81), listOf(-9, -2, 0, 2, 3)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Ordered square of $numbers should be $result", result, Day118.solution(numbers))
    }
}