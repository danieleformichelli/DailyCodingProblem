package com.formichelli.dailycodingproblem.day1to100.day91to100

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day91Test(private val result: List<Int>, private val n: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf((1..10).toList(), 10),
                    arrayOf((1..20).toList(), 20))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Range for n=$n should be $result", result, Day91.solution(n))
    }
}