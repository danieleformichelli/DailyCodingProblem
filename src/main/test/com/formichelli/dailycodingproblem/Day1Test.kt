package com.formichelli.dailycodingproblem

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day1Test(private val result: Boolean, private val k: Int, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(true, 17, intArrayOf(10, 15, 3, 7)),
                    arrayOf<Any>(false, 14, intArrayOf(10, 15, 3, 7))
            )
        }
    }

    @Test
    fun sumTo() {
        Assert.assertEquals(String.format("%s %s to %d", Utils.prettyPrint(numbers), if (result) "sum up" else "does not sum up", k), result, Day1.solution(k, numbers))
    }
}