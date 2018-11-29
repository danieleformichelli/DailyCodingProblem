package com.formichelli.dailycodingproblem.day101to200.day111to120

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day113Test(private val result: String, private val words: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf("here", "hello"),
                    arrayOf("world hello", "hello world"),
                    arrayOf("here world hello", "hello world here"),
                    arrayOf("are we here world hello", "hello world here we are"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Reversed word of $words should be $result", result, Day113.solution(words))
    }
}