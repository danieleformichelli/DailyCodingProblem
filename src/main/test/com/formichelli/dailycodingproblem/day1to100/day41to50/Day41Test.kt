package com.formichelli.dailycodingproblem.day1to100.day41to50

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day41Test(private val result: List<Pair<String, String>>, private val flights: List<Pair<String, String>>, private val startAirport: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf("YUL", "YYZ", "SFO", "HKO", "ORD"), listOf(Pair("SFO", "HKO"), Pair("YYZ", "SFO"), Pair("YUL", "YYZ"), Pair("HKO", "ORD")), "YUL"),
                    arrayOf(listOf("A", "B", "C", "A", "C"), listOf(Pair("A", "B"), Pair("A", "C"), Pair("B", "C"), Pair("C", "A")), "A"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Itinerary for $flights starting from $startAirport should be $result", result, Day41.solution(flights, startAirport))
    }
}