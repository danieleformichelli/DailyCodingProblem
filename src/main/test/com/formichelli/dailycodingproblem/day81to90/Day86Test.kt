package com.formichelli.dailycodingproblem.day81to90

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day86Test(private val result: Int, private val parenthesis: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(2, ")("),
                    arrayOf(1, "()())()"),
                    arrayOf(2, ")()())()"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$parenthesis can be made valid by removing $result parenthesis", result, Day86.solution(parenthesis))
    }
}