package com.formichelli.dailycodingproblem.day101to200.day131to140

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day138Test(private val result: Int, private val cents: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(3, 16))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$cents cents can be obtained using $result coins", result, Day138.solution(cents))
    }
}