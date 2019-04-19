package com.formichelli.dailycodingproblem.day101to200.day141to150

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day147Test(private val result: List<Int>, private val numbers: MutableList<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(listOf(1, 2, 3, 4), mutableListOf(2, 1, 4, 3)),
                    arrayOf<Any>(listOf(1, 2, 3, 4), mutableListOf(4, 3, 2, 1)),
                    arrayOf<Any>(listOf(1, 2, 3, 4), mutableListOf(1, 2, 3, 4)),
                    arrayOf<Any>(listOf(1, 2, 3, 4, 5), mutableListOf(2, 1, 4, 3, 5)),
                    arrayOf<Any>(listOf(2), mutableListOf(2)))
        }
    }

    @Test
    fun solution() {
        Day147.solution(numbers)
        Assert.assertEquals("$numbers sorted is $result", result, numbers)
    }
}