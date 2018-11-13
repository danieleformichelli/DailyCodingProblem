package com.formichelli.dailycodingproblem.day91to100

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day92Test(private val result: List<String>, private val prerequisitesMap: Map<String, List<String>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf("CSC100", "CSC200", "CSC300"), mapOf(
                            "CSC300" to listOf("CSC100", "CSC200"),
                            "CSC200" to listOf("CSC100"),
                            "CSC100" to listOf())))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Ordering for $prerequisitesMap should be $result", result, Day92.solution(prerequisitesMap))
    }
}