package com.formichelli.dailycodingproblem.day1to100.day51to60

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day57Test(private val result: List<String>?, private val inputString: String, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf<Array<Any?>>(
                    arrayOf(null, "the quick brown fox jumps over the lazy dog", 4),
                    arrayOf(listOf("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"), "the quick brown fox jumps over the lazy dog", 5),
                    arrayOf(listOf("the", "quick", "brown", "fox", "jumps", "over the", "lazy dog"), "the quick brown fox jumps over the lazy dog", 8),
                    arrayOf(listOf("the quick", "brown fox", "jumps over", "the lazy", "dog"), "the quick brown fox jumps over the lazy dog", 10))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("String $inputString should breakdown to $result splitting at length $k", result, Day57.solution(inputString, k))
    }
}