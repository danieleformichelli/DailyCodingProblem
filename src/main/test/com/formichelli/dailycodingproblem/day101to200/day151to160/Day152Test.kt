package com.formichelli.dailycodingproblem.day101to200.day151to160

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day152Test(private val numbers: List<Int>, private val probabilities: List<Double>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(listOf(1, 2, 3, 4), listOf(0.1, 0.5, 0.2, 0.2)))
        }
    }

    @Test
    fun solution() {
        val iterations = 100000
        val count = HashMap<Int, Int>()
        repeat(iterations) {
            val result = Day152.solution(numbers, probabilities)
            count[result] = (count[result] ?: 0) + 1
        }

        for (i in 0 until probabilities.size) {
            Assert.assertEquals("Number ${numbers[i]} should appear with ${probabilities[i]} probability", probabilities[i], (count[numbers[i]]
                    ?: 0) / iterations.toDouble(), 0.01)
        }
    }
}