package com.formichelli.dailycodingproblem.day1to100.day1to100.day11to20

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day12Test(private val result: Int, private val stepsCounts: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(1, 1),
                    arrayOf<Any>(2, 2),
                    arrayOf<Any>(3, 3),
                    arrayOf<Any>(5, 4),
                    arrayOf<Any>(8, 5)
            )
        }
    }

    @Test
    fun solutionRecursive() {
        Assert.assertEquals("A $stepsCounts steps stair case has $result ways to be climbed", result, Day12.solutionRecursive(stepsCounts))
    }

    @Test
    fun solutionIterative() {
        Assert.assertEquals("A $stepsCounts steps stair case has $result ways to be climbed", result, Day12.solutionIterative(stepsCounts))
    }
}