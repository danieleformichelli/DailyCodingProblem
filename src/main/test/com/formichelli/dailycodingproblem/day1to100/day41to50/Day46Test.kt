package com.formichelli.dailycodingproblem.day1to100.day41to50

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day46Test(private val result: String, private val inputString: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf("bcdcb", "aabcdcb"),
                    arrayOf("anana", "bananas"),
                    arrayOf("anaana", "banaanas"),
                    arrayOf("anaana", "banaana"),
                    arrayOf("banaanab", "banaanab"),
                    arrayOf("banab", "banaba"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Longest palindromic substring of $inputString should be $result", result, Day46.solution(inputString))
    }
}