package com.formichelli.dailycodingproblem.day1to100.day81to90

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day82Test(private val result: List<String>, private val n: Int, private val fileContent: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf("Hello w", "orld", ""), 7, "Hello world"),
                    arrayOf(listOf("Hel", "lo ", "wor", "ld", ""), 3, "Hello world"),
                    arrayOf(listOf("Hello world", ""), 20, "Hello world"))
        }
    }

    @Test
    fun solution() {
        val fileReader = Day82.FileReader(Day82.FileReader7(fileContent))
        for (read in result) {
            Assert.assertEquals("Read should return $read", read, fileReader.readN(n))
        }
    }
}