package com.formichelli.dailycodingproblem.day101to200.day141to150

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day150Test(private val result: List<Pair<Int, Int>>, private val points: List<Pair<Int, Int>>, private val center: Pair<Int, Int>, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf(Pair(0, 0), Pair(3, 1)), listOf(Pair(0, 0), Pair(5, 4), Pair(3, 1)), Pair(1, 2), 2))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Nearest $k point of $center among $points are $result", result.toSet(), Day150.solution(points, center, k).toSet())
    }
}