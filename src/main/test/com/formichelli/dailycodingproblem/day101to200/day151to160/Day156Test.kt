package com.formichelli.dailycodingproblem.day101to200.day151to160

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day156Test(private val result: Int, private val n: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(2, 13),
                    arrayOf<Any>(3, 27),
                    arrayOf<Any>(4, 28))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$n can be obtained summing $result squares", result, Day156.solution(n))
    }
}