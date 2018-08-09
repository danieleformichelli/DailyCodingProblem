package com.formichelli.dailycodingproblem

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day2Test(private val result: List<Int>, private val numbers: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(listOf(120, 60, 40, 30, 24), listOf(1, 2, 3, 4, 5)),
                    arrayOf<Any>(listOf(2, 3, 6), listOf(3, 2, 1))
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals(String.format("%s should map to %s", Utils.prettyPrint(numbers), Utils.prettyPrint(result)), result, Day2.solution(numbers))
    }
}