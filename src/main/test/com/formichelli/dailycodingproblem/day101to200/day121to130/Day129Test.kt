package com.formichelli.dailycodingproblem.day101to200.day121to130

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day129Test(private val result: Int, private val n: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf<Array<Any?>>(
                    arrayOf(1, 1),
                    arrayOf(2, 4),
                    arrayOf(3, 9),
                    arrayOf(4, 16),
                    arrayOf(5, 25),
                    arrayOf(6, 36),
                    arrayOf(7, 49),
                    arrayOf(8, 64),
                    arrayOf(9, 81),
                    arrayOf(10, 100),
                    arrayOf(-1, 101))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("The square root of $n is $result", result, Day129.solution(n))
    }
}