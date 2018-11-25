package com.formichelli.dailycodingproblem.day1to100.day1to100.day71to80

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day74Test(private val result: Int, private val N: Int, private val X: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(4, 6, 12),
                    arrayOf(2, 6, 2),
                    arrayOf(1, 6, 36))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$X should appear $result times in a ${N}x$N multiplication matrix", result, Day74.solution(N, X))
    }
}