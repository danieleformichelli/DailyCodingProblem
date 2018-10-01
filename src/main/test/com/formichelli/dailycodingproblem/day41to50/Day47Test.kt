package com.formichelli.dailycodingproblem.day41to50

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day47Test(private val result: Int, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(5, intArrayOf(9, 11, 8, 5, 7, 10)),
                    arrayOf(4, intArrayOf(1, 2, 3, 4, 5)),
                    arrayOf(5, intArrayOf(3, 2, 4, 1, 6)),
                    arrayOf(6, intArrayOf(3, 2, 8, 1, 6)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Maximum profit for prices $numbers should be $result", result, Day47.solution(numbers))
    }
}