package com.formichelli.dailycodingproblem.day101to200.day161to170

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day162Test(private val result: List<String>, private val words: List<String>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(listOf("d", "c", "app", "apr", "f"), listOf("dog", "cat", "apple", "apricot", "fish")))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Unique prefixes of $words are $result", result, Day162.solution(words))
    }
}