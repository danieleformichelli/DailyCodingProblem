package com.formichelli.dailycodingproblem.day101to200.day151to160

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day159Test(private val result: Char?, private val string: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf(
                    arrayOf<Any?>('b', "acbbac"),
                    arrayOf<Any?>(null, "abcdef"),
                    arrayOf<Any?>('b', "abcdefb"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("The first repeating elemnt of $string is $result", result, Day159.solution(string))
    }
}