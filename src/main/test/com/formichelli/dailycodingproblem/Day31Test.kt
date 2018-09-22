package com.formichelli.dailycodingproblem

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day31Test(private val result: Int, private val stringA: String, private val stringB: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(arrayOf(3, "kitten", "sitting"), arrayOf(3, "a", "kkk"), arrayOf(6, "industry", "interest"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Edit distance from $stringA to $stringB should be $result", result, Day31.solution(stringA, stringB))
    }
}