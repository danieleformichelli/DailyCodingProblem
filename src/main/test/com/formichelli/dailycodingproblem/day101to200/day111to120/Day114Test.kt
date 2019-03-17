package com.formichelli.dailycodingproblem.day101to200.day111to120

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day114Test(private val result: String, private val words: String, private val delimiters: Set<Char>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf("here/world:hello", "hello/world:here", setOf('/', ':')),
                    arrayOf("/here:world/hello", "hello/world:here/", setOf('/', ':')),
                    arrayOf("here/world/:hello", "hello//world:here", setOf('/', ':')),
                    arrayOf("here/world/:hello/", "/hello/:world/here", setOf('/', ':')))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Reversed word of $words with delimiters $delimiters should be", result, Day114.solution(words, delimiters))
    }
}