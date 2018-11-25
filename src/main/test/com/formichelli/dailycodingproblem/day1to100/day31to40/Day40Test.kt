package com.formichelli.dailycodingproblem.day1to100.day31to40

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day40Test(private val result: Int, private val numbers: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(1, intArrayOf(6, 1, 3, 3, 3, 6, 6)),
                    arrayOf(19, intArrayOf(13, 19, 13, 13))
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$result appears only once in ${Utils.prettyPrint(numbers)}", result, Day40.solution(numbers))
    }
}