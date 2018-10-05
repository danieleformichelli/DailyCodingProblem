package com.formichelli.dailycodingproblem.day51to60

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day53Test(private val result: IntArray, private val operations: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    // -1 means pop
                    arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5, -1, -1, -1, -1, -1)),
                    arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, -1, 2, -1, 3, -1, 4, -1, 5, -1)),
                    arrayOf(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, -1, 4, -1, 5, -1, -1, -1)))
        }
    }

    @Test
    fun solution() {
        val queue = Day53.Queue<Int>()

        var checkResultIndex = 0
        operations.forEach {
            when (it) {
                -1 -> Assert.assertEquals("Pop should return ${result[checkResultIndex]}", result[checkResultIndex++], queue.dequeue())
                else -> queue.enqueue(it)
            }
        }
    }
}