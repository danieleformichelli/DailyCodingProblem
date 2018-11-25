package com.formichelli.dailycodingproblem.day1to100.day11to20

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day19Test(private val result: Int, private val costsMatrix: Array<IntArray>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(arrayOf<Any>(11 /*10+1*/, arrayOf(intArrayOf(1, 10), intArrayOf(1, 100))),
                    arrayOf<Any>(4 /*1+2+1*/, arrayOf(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3), intArrayOf(1, 2, 3))),
                    arrayOf<Any>(12 /*10+1+1*/, arrayOf(intArrayOf(1, 10, 10), intArrayOf(1, 100, 100), intArrayOf(1, 1, 1))),
                    arrayOf<Any>(4 /*1+0+1+2*/, arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(1, 2, 1, 0), intArrayOf(6, 1, 1, 5), intArrayOf(2, 3, 5, 5))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Minimum cost should be $result", result, Day19.solution(costsMatrix))
    }
}