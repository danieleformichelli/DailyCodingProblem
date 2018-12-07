package com.formichelli.dailycodingproblem.day101to200.day111to120

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day119Test(private val result: Set<Int>, private val intervals: Set<Pair<Int, Int>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(setOf(3, 6), setOf(Pair(0, 3), Pair(2, 6), Pair(3, 4), Pair(6, 9))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Minimum set of numbers covering all the intervals should be $result", result, Day119.solution(intervals))
    }
}