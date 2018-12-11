package com.formichelli.dailycodingproblem.day101to200.day121to130

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day123Test(private val result: Boolean, private val numberStr: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(true, "10"),
                    arrayOf(true, "-10"),
                    arrayOf(true, "10.1"),
                    arrayOf(true, "-10.1"),
                    arrayOf(true, "1e5"),
                    arrayOf(false, "a"),
                    arrayOf(false, "x 1"),
                    arrayOf(false, "a -2"),
                    arrayOf(false, "-"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$numberStr ${if (result) "is" else "is not"} a number", result, Day123.solution(numberStr))
    }
}