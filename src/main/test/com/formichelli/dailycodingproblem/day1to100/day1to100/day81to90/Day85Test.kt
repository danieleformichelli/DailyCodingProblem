package com.formichelli.dailycodingproblem.day1to100.day1to100.day81to90

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day85Test(private val result: Int, private val x: Int, private val y: Int, private val b: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(arrayOf(13, 13, 27, 1), arrayOf(27, 13, 27, 0))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Function should return $result", result, Day85.solution(x, y, b))
    }
}