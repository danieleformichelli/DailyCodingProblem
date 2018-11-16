package com.formichelli.dailycodingproblem.day91to100

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day100Test(private val result: Int, private val points: List<Pair<Int, Int>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(2, listOf(Pair(0, 0), Pair(1, 1), Pair(2, 2))),
                    arrayOf(6, listOf(Pair(-1, 0), Pair(1, 1), Pair(-2, -3))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("The number of steps required for path through $points should be $result", result, Day100.solution(points))
    }
}