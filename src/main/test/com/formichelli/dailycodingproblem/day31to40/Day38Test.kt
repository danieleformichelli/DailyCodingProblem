package com.formichelli.dailycodingproblem.day31to40

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day38Test(private val result: Int, private val boardSize: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(1, 1),
                    arrayOf(0, 2),
                    arrayOf(0, 3),
                    arrayOf(2, 4),
                    arrayOf(10, 5),
                    arrayOf(4, 6),
                    arrayOf(40, 7),
                    arrayOf(92, 8),
                    arrayOf(352, 9),
                    arrayOf(724, 10))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("On a board ${boardSize}x$boardSize there are $result ways of placing $boardSize queens without threatening each other", result, Day38.solution(boardSize))
    }
}