package com.formichelli.dailycodingproblem.day101to200.day161to170

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day163Test(private val result: Int, private val expression: List<String>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(5, listOf("15", "7", "1", "1", "+", "-", "/", "3", "*", "2", "1", "1", "+", "+", "-")))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Result of $expression is $result", result, Day163.solution(expression))
    }
}