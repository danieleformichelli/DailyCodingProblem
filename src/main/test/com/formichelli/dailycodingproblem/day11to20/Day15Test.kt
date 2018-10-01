package com.formichelli.dailycodingproblem.day11to20

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*

@RunWith(Parameterized::class)
class Day15Test(private val streamSize: Int, private val numberOfSamples: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(100, 100000)
            )
        }
    }

    @Test
    fun solution() {
        val streamArray = IntArray(streamSize) { it }
        val frequencyCount = IntArray(streamSize) { 0 }
        for (i in 0 until numberOfSamples) {
            val solution = Day15.solution(Arrays.stream(streamArray))
            ++frequencyCount[solution]
        }

        val expectedCount = numberOfSamples / streamSize
        val expectedCountMax = (expectedCount * 1.1).toInt()
        val expectedCountMin = (expectedCount * 0.9).toInt()
        frequencyCount.forEachIndexed { index, value ->
            Assert.assertTrue("Count of element at index $index should be in [$expectedCountMin,$expectedCountMax]", value in expectedCountMin..expectedCountMax)
        }
    }
}