package com.formichelli.dailycodingproblem.day101to200.day151to160

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day153Test(private val result: Int, private val words: String, private val word1: String, private val word2: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(1, "dog cat hello cat dog dog hello cat world", "hello", "world"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Minimum words distance between $word1 and $word2 in $words is $result", result, Day153.solution(words, word1, word2))
    }
}