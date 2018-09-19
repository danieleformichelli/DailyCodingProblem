package com.formichelli.dailycodingproblem

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*

@RunWith(Parameterized::class)
class Day21Test(private val result: Int, private val timeIntervals: Array<Pair<Int, Int>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(arrayOf(2, arrayOf(Pair(30, 75), Pair(0, 50), Pair(60, 150))),
                    arrayOf(3, arrayOf(Pair(30, 75), Pair(0, 50), Pair(60, 150), Pair(0, 200))),
                    arrayOf(2, arrayOf(Pair(30, 75), Pair(0, 50), Pair(60, 150), Pair(150, 200))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$result rooms are required for timetable ${Arrays.toString(timeIntervals)}", result, Day21.solution(timeIntervals))
    }
}