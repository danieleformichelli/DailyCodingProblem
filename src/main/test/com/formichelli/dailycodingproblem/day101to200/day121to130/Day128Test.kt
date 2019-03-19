package com.formichelli.dailycodingproblem.day101to200.day121to130

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day128Test(private val result: List<Pair<Int, Int>>, private val n: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf<Array<Any?>>(
                    arrayOf(listOf(Pair(1, 3)), 1),
                    arrayOf(listOf(Pair(1, 2), Pair(1, 3), Pair(2, 3)), 2),
                    arrayOf(listOf(Pair(1, 3), Pair(1, 2), Pair(3, 2), Pair(1, 3), Pair(2, 1), Pair(2, 3), Pair(1, 3)), 3))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("An Hanoi tower of size $n can be soled with these moves $result", result, Day128.solution(n))
    }
}