package com.formichelli.dailycodingproblem.day101to200.day161to170

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day164Test(private val result: Int, private val numbers: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(5, listOf(1, 2, 3, 4, 5, 5)),
                    arrayOf(1, listOf(1, 4, 5, 1, 2, 3)),
                    arrayOf(4, listOf(3, 5, 1, 4, 2, 4)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Missing number in $numbers is $result", result, Day164.solution(numbers))
    }
}