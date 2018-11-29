package com.formichelli.dailycodingproblem.day101to200.day111to120

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day113Test(private val result: String, private val words: CharArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf("hello", "hello".toCharArray()),
                    arrayOf("world hello", "hello world".toCharArray()),
                    arrayOf("here world hello", "hello world here".toCharArray()),
                    arrayOf("are we here world hello", "hello world here we are".toCharArray()))
        }
    }

    @Test
    fun solution() {
        val msg = "Reversed word of ${String(words)} should be $result"
        Day113.solution(words)
        Assert.assertEquals(msg, result, String(words))
    }
}