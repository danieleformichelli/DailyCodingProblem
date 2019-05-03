package com.formichelli.dailycodingproblem.day101to200.day161to170

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day167Test(private val result: Set<Pair<Int, Int>>, private val words: List<String>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(setOf(Pair(0, 1), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 5)), listOf("code", "edoc", "edo", "edoca", "da", "d")))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Palindrome pairs of $words are $result", result, Day167.solution(words))
    }
}