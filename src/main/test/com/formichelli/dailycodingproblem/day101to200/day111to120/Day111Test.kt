package com.formichelli.dailycodingproblem.day101to200.day111to120

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day111Test(private val result: List<Int>, private val W: String, private val S: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf(0, 3, 4), "ab", "abxaba"),
                    arrayOf(listOf(0, 1), "abx", "abxaba"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Anagrams of $W can be found at indices $result of $S", result, Day111.solution(W, S))
    }
}