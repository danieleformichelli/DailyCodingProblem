package com.formichelli.dailycodingproblem.day81to90

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day87Test(private val result: Boolean, private val rules: List<String>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(false, listOf("A N B", "B NE C", "C N A")),
                    arrayOf(true, listOf("A NW B", "A N B")))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$rules ${if (result) "is" else "is not"} a valid list of rules", result, Day87.solution(rules))
    }
}