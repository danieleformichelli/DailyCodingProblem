package com.formichelli.dailycodingproblem.day_11_20

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*

@RunWith(Parameterized::class)
class Day11Test(private val result: Set<String>, private val query: String, private val querySet: Set<String>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(setOf("deer", "deal"), "de", setOf("dog", "deer", "deal")),
                    arrayOf(setOf("deer", "dog", "deal"), "d", setOf("dog", "deer", "deal")),
                    arrayOf(Collections.emptySet<String>(), "f", setOf("dog", "deer", "deal")),
                    arrayOf(setOf("de", "deer", "deal", "dealing"), "de", setOf("ade", "dog", "de", "deer", "deal", "dealing"))
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals(String.format("Prefix set of %s should be %s", query, result.toString()), result, Day11.solution(query, querySet))
    }
}