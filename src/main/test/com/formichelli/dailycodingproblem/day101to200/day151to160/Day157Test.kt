package com.formichelli.dailycodingproblem.day101to200.day151to160

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day157Test(private val result: Boolean, private val string: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(true, "carrace"),
                    arrayOf(true, "carcra"),
                    arrayOf(false, "carraced"),
                    arrayOf(false, "daily"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("${if (result) "A" else "No"} permutation of $string is a palindrome", result, Day157.solution(string))
    }
}