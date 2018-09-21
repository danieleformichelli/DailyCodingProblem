package com.formichelli.dailycodingproblem

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day28Test(private val result: List<String>, private val words: List<String>, private val lineLength: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf("the  quick brown", "fox  jumps  over", "the   lazy   dog"), listOf("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"), 16),
                    arrayOf(listOf("the     quickest", "brownfoxjumps   "), listOf("the", "quickest", "brownfoxjumps"), 16),
                    arrayOf(listOf("the     quickest", "brownfoxjumpsova"), listOf("the", "quickest", "brownfoxjumpsova"), 16))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals(result, Day28.solution(words, lineLength))
    }
}