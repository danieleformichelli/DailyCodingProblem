package com.formichelli.dailycodingproblem.day1to100.day1to100.day61to70

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day67Test(private val results: List<Int?>, private val cacheSize: Int, private val operations: List<Pair<String, Int?>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            // -1 in operation value means get
            return listOf(
                    arrayOf(listOf(1), 5, listOf(Pair("1", 1), Pair("2", 2), Pair("3", 3), Pair("4", 4), Pair("5", 5), Pair("1", null))),
                    arrayOf(listOf(1, 1, null), 5, listOf(Pair("1", 1), Pair("2", 2), Pair("3", 3), Pair("4", 4), Pair("5", 5), Pair("1", null), Pair("6", 6), Pair("1", null), Pair("2", null))))
        }
    }

    @Test
    fun solution() {
        val cache = Day67.LFUCache<Int>(cacheSize)

        var resultsIndex = 0
        operations.forEach {
            if (it.second != null) {
                cache.set(it.first, it.second!!)
            } else {
                Assert.assertEquals("Get of ${it.first} should return ${results[resultsIndex]}", results[resultsIndex], cache.get(it.first))
                ++resultsIndex
            }
        }
    }
}