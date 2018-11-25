package com.formichelli.dailycodingproblem.day1to100.day1to100.day61to70

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day66Test(private val biasThreshold: Double) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(0.1),
                    arrayOf(0.2),
                    arrayOf(0.3),
                    arrayOf(0.4),
                    arrayOf(0.5),
                    arrayOf(0.6),
                    arrayOf(0.7),
                    arrayOf(0.8),
                    arrayOf(0.9))
        }
    }

    @Test
    fun solution() {
        val tossCount = 10000
        var trueCount = 0
        var falseCount = 0
        for (i in 1..tossCount) {
            if (Day66.solution(biasThreshold)) {
                ++trueCount
            } else {
                ++falseCount
            }
        }

        Assert.assertTrue("Difference between toss results count should be less than 10%", Math.abs(trueCount - falseCount) < tossCount / 10)
    }
}