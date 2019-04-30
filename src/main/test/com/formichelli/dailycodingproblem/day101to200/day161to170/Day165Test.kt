package com.formichelli.dailycodingproblem.day101to200.day161to170

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day165Test(private val result: IntArray, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(intArrayOf(1, 1, 2, 1, 0), intArrayOf(3, 4, 9, 6, 1)))
        }
    }

    @Test
    fun solution() {
        Assert.assertArrayEquals("Array of smaller count for ${Utils.prettyPrint(numbers)} is ${Utils.prettyPrint(result)}", result, Day165.solution(numbers))
    }
}