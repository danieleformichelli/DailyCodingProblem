package com.formichelli.dailycodingproblem.day101to200.day141to150

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day149Test(private val numbers: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(listOf(1, 2, 3, 4, 5)))
        }
    }

    @Test
    fun solution() {
        for (i in 0 until numbers.size) {
            for (j in i + 1..numbers.size) {
                val expectedSum = numbers.stream().skip(i.toLong()).limit((j - i).toLong()).mapToInt { it }.sum()
                Assert.assertEquals("Sum of $numbers from $i to $j is $expectedSum", expectedSum, Day149.solution(numbers, i, j))
            }
        }
    }
}