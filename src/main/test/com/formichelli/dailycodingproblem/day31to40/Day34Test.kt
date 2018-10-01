package com.formichelli.dailycodingproblem.day31to40

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day34Test(private val result: String, private val inputString: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf("ecarace", "race"),
                    arrayOf("elgoogle", "google"),
                    arrayOf("itopinonavevanonipoti", "itopinonavevanonipoti"),
                    arrayOf("itopinonavezevanonipoti", "itopinonavezvanonipoti"),
                    arrayOf("itopinonavezevanonipoti", "itopinonavezanonipoti"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Shortest palindrome generated from $inputString should be $result", result, Day34.solution(inputString))
    }
}