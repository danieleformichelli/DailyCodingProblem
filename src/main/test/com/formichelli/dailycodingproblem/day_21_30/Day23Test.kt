package com.formichelli.dailycodingproblem.day_21_30

import com.formichelli.dailycodingproblem.day_21_30.Day23
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day23Test(private val result: Int, private val board: Array<BooleanArray>, private val start: Pair<Int, Int>, private val end: Pair<Int, Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(7, arrayOf(booleanArrayOf(false, false, false, false), booleanArrayOf(true, true, false, true), booleanArrayOf(false, false, false, false), booleanArrayOf(false, false, false, false)), Pair(3, 0), Pair(0, 0)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Shortest part should be $result", result, Day23.solution(board, start, end))
    }
}