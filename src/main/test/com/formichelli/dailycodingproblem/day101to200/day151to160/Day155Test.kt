package com.formichelli.dailycodingproblem.day101to200.day151to160

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day155Test(private val result: Int?, private val numbers: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf(
                    arrayOf<Any?>(null, listOf(1, 2, 1, 1, 3, 4, 0)),
                    arrayOf<Any?>(1, listOf(1, 2, 1, 1, 3, 4, 1)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Majority element in $numbers is $result", result, Day155.solution(numbers))
    }
}