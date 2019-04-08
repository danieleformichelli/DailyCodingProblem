package com.formichelli.dailycodingproblem.day101to200.day131to140

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day132Test(private val total: Int, private val rangeResult: Int, private val range: Pair<Int, Int>, private val hits: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(6, 3, Pair(4, 8), intArrayOf(1, 2, 4, 7, 8, 10)),
                    arrayOf<Any>(6, 1, Pair(3, 6), intArrayOf(1, 2, 4, 7, 8, 10)),
                    arrayOf<Any>(6, 6, Pair(0, 10), intArrayOf(1, 2, 4, 7, 8, 10)),
                    arrayOf<Any>(6, 3, Pair(4, 9), intArrayOf(1, 2, 4, 7, 8, 10)))
        }
    }

    @Test
    fun solution() {
        val hitCounter = Day132.HitCounter()
        hits.forEach { hitCounter.record(it) }
        Assert.assertEquals("Total value should be $total", total, hitCounter.total())
        Assert.assertEquals("Range value for $range should be $rangeResult", rangeResult, hitCounter.range(range.first, range.second))
    }
}