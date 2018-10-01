package com.formichelli.dailycodingproblem.day11to20

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day13Test(private val result: String, private val string: String, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf("a", "abcba", 1),
                    arrayOf("bcb", "abcba", 2),
                    arrayOf("abcba", "abcba", 3),
                    arrayOf("abcbad", "abcbad", 4)
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Longest substring of $string with at most $k distinct characters is $result", result, Day13.solution(k, string))
    }
}