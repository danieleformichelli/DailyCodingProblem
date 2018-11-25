package com.formichelli.dailycodingproblem.day1to100.day51to60

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day60Test(private val result: Boolean, private val numbers: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(true, listOf(15, 5, 20, 10, 35, 15, 10)),
                    arrayOf(false, listOf(15, 5, 20, 10, 35)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$numbers ${if (result) "can" else "cannot"} be split in sets with equal sum", result, Day60.solution(numbers))
    }
}