package com.formichelli.dailycodingproblem.day1to100.day1to100.day91to100

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day96Test(private val result: Set<List<Int>>, private val number: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(setOf(listOf(1, 2, 3), listOf(1, 3, 2), listOf(2, 1, 3), listOf(2, 3, 1), listOf(3, 2, 1), listOf(3, 1, 2)), listOf(1, 2, 3)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("All permutatinos of $number should be $result", result, Day96.solution(number))
    }
}