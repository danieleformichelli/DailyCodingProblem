package com.formichelli.dailycodingproblem

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day9Test(private val result: Int, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(13, intArrayOf(2, 4, 6, 2, 5)),
                    arrayOf<Any>(10, intArrayOf(5, 1, 1, 5))
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals(String.format("%s max non-adjacent sum should be %d", Utils.prettyPrint(numbers), result), result, Day9.solution(numbers))
    }
}