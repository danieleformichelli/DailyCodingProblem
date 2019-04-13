package com.formichelli.dailycodingproblem.day101to200.day131to140

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day140Test(private val result: Pair<Int, Int>, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(Pair(4, 8), intArrayOf(2, 4, 6, 8, 10, 2, 6, 10)))
        }
    }

    @Test
    fun solution() {
        val resultPair = Day140.solution(numbers)
        Assert.assertEquals("Distinct elements should be ${result.first} and ${result.second}", setOf(result.first, result.second), setOf(resultPair.first, resultPair.second))
    }
}