package com.formichelli.dailycodingproblem.day1to10

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day7Test(private val result: Int, private val message: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(3, "111")
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals(String.format("%s can be decoded in %d ways", message, result), result, Day7.solution(message))
    }
}