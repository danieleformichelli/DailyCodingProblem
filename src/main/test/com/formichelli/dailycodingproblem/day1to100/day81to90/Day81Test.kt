package com.formichelli.dailycodingproblem.day1to100.day81to90

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day81Test(private val result: List<String>, private val mapping: Map<String, List<String>>, private val number: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val mapping = mapOf("2" to listOf("a", "b", "c"), "3" to listOf("d", "e", "f"), "4" to listOf("g", "h", "i"), "5" to listOf("j", "k", "l"), "6" to listOf("m", "n", "o"), "7" to listOf("p", "q", "r", "s"), "8" to listOf("t", "u", "v"), "9" to listOf("w", "x", "y", "z"))
            return listOf(
                    arrayOf(listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), mapping, "23"),
                    arrayOf(listOf("pw", "px", "py", "pz", "qw", "qx", "qy", "qz", "rw", "rx", "ry", "rz", "sw", "sx", "sy", "sz"), mapping, "79"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$number can map to $result", result, Day81.solution(number, mapping.toSortedMap()))
    }
}