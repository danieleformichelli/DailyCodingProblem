package com.formichelli.dailycodingproblem.day_21_30

import com.formichelli.dailycodingproblem.day_21_30.Day27
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day27Test(private val result: Boolean, private val inputString: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(true, "([])[]({})"),
                    arrayOf(false, "([)]"),
                    arrayOf(false, "((()"),
                    arrayOf(true, ""))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$inputString ${if (result) "is" else "is not"} bracket balanced", result, Day27.solution(inputString))
    }
}