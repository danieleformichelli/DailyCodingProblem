package com.formichelli.dailycodingproblem.day1to100.day81to90

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day88Test(private val result: Int, private val dividend: Int, private val divisor: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(2, 12, 6),
                    arrayOf(2, 17, 6))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$dividend / $divisor should result in $result", result, Day88.solution(dividend, divisor))
    }
}