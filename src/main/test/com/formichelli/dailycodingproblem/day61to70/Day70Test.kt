package com.formichelli.dailycodingproblem.day61to70

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day70Test(private val result: Int, private val n: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(19, 1),
                    arrayOf(28, 2),
                    arrayOf(37, 3),
                    arrayOf(46, 4),
                    arrayOf(55, 5),
                    arrayOf(64, 6),
                    arrayOf(73, 7),
                    arrayOf(82, 8),
                    arrayOf(91, 9),
                    arrayOf(109, 10))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("${n}th perfect number should be $result", result, Day70.solution(n))
    }
}