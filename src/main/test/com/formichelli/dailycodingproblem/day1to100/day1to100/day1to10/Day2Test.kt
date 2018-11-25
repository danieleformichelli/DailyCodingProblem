package com.formichelli.dailycodingproblem.day1to100.day1to100.day1to10

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day2Test(private val result: IntArray, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(intArrayOf(120, 60, 40, 30, 24), intArrayOf(1, 2, 3, 4, 5)),
                    arrayOf<Any>(intArrayOf(2, 3, 6), intArrayOf(3, 2, 1))
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertArrayEquals(String.format("%s should map to %s", Utils.prettyPrint(numbers), Utils.prettyPrint(result)), result, Day2.solution(numbers))
    }

    @Test
    fun solutionWithoutDivision() {
        Assert.assertArrayEquals(String.format("%s should map to %s", Utils.prettyPrint(numbers), Utils.prettyPrint(result)), result, Day2.solutionWithoutDivision(numbers))
    }
}