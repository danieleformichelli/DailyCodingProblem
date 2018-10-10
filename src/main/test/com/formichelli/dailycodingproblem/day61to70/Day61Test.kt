package com.formichelli.dailycodingproblem.day61to70

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day61Test(private val result: Int, private val base: Int, private val exponent: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(1024, 2, 10),
                    arrayOf(27, 3, 3),
                    arrayOf(20736, 12, 4),
                    arrayOf(248832, 12, 5),
                    arrayOf(10000000, 10, 7))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("pow($base,$exponent) should be $result", result, Day61.solution(base, exponent))
    }
}