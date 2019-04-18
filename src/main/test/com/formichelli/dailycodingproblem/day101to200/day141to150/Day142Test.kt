package com.formichelli.dailycodingproblem.day101to200.day141to150

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day142Test(private val result: Boolean, private val parenthesis: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(true, "(()*"),
                    arrayOf(true, "(*)"),
                    arrayOf(false, ")*("),
                    arrayOf(false, "((()*"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Parenthesis of $parenthesis ${if (result) "are" else "are not"} balanced", result, Day142.solution(parenthesis))
    }
}