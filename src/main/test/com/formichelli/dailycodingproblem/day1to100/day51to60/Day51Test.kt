package com.formichelli.dailycodingproblem.day1to100.day51to60

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day51Test(private val deckSize: Int, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(52, 3),
                    arrayOf(52, 10),
                    arrayOf(52, 100))
        }
    }

    @Test
    fun solution() {
        val samples = 100000
        // for each position count the frequency of each card
        val frequency = Array(deckSize) { IntArray(deckSize) }

        for (i in 1..samples) {
            val deck = IntArray(deckSize) { it }
            Day51.solution(deck, k)
            for (j in 0 until deckSize) {
                ++frequency[j][deck[j]]
            }
        }

        for (i in 0 until deckSize) {
            for (j in 0 until deckSize) {
                Assert.assertEquals("Frequency of $i in position $j should be around ${1 / samples}", 1 / deckSize.toDouble(), frequency[i][j] / samples.toDouble(), 0.01)
            }
        }
    }
}