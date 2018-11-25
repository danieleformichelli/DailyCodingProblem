package com.formichelli.dailycodingproblem.day1to100.day1to100.day71to80

import com.formichelli.dailycodingproblem.day71to80.Day77
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day77Test(private val result: List<Pair<Int, Int>>, private val intervals: List<Pair<Int, Int>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(listOf(Pair(1, 3), Pair(4, 10), Pair(20, 25)), listOf(Pair(1, 3), Pair(5, 8), Pair(4, 10), Pair(20, 25))),
                    arrayOf(listOf(Pair(1, 3), Pair(4, 25)), listOf(Pair(1, 3), Pair(5, 8), Pair(4, 10), Pair(10, 25))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Merging intervals of $intervals should result in $result", result, Day77.solution(intervals))
    }
}