package com.formichelli.dailycodingproblem.day1to100.day1to100.day81to90

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day90Test(private val n: Int, private val l: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(10, listOf(0)),
                    arrayOf(10, listOf(0, 2, 4, 6, 8)),
                    arrayOf(10, listOf(0, 1, 2, 3, 4, 5, 6, 7, 8)))
        }
    }

    @Test
    fun solution() {
        val numberOfSamples = 10000
        val frequencyCount = IntArray(n) { 0 }
        for (i in 0 until numberOfSamples) {
            val solution = Day90.solution(n, l)
            ++frequencyCount[solution]
        }

        // we assume that all numbers of l are distinct and in (0..n-1)
        val expectedCount = numberOfSamples / (n - l.size)
        val expectedCountMax = (expectedCount * 1.1).toInt()
        val expectedCountMin = (expectedCount * 0.9).toInt()
        frequencyCount.forEachIndexed { index, value ->
            if (l.contains(index)) {
                Assert.assertEquals("Frequency of $index should be 0", 0, value)
            } else {
                Assert.assertTrue("Frequency of $index should be in [$expectedCountMin,$expectedCountMax] but it is $value", value in expectedCountMin..expectedCountMax)
            }
        }
    }
}