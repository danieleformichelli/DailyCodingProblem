package com.formichelli.dailycodingproblem.day61to70

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day69Test(private val result: Int, private val numbers: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(500, listOf(-10, -10, 5, 2)),
                    arrayOf(50000, listOf(-10, -10, 500, 200)),
                    arrayOf(30000, listOf(-10, -9, 5, 300, 20)),
                    arrayOf(-6000, listOf(-10, -20, -30, -40)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Max product of three items of $numbers should be $result", result, Day69.solution(numbers))
    }
}