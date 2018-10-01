package com.formichelli.dailycodingproblem.day11to20

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day18Test(private val result: IntArray, private val numbers: IntArray, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(arrayOf<Any>(intArrayOf(10, 7, 8), intArrayOf(10, 5, 2, 7, 8, 7), 3))
        }
    }

    @Test
    fun solution() {
        Assert.assertArrayEquals("Maximums of sub-arrays of $numbers of length $k should be $result", result, Day18.solution(numbers, k))
    }
}