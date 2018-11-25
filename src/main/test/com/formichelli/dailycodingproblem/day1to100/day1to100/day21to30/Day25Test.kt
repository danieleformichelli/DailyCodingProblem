package com.formichelli.dailycodingproblem.day1to100.day1to100.day21to30

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day25Test(private val result: Boolean, private val regex: String, private val string: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(true, "ra.", "ray"),
                    arrayOf(true, "ra.*", "ray"),
                    arrayOf(false, "ra.", "raymond"),
                    arrayOf(false, "ra.*", "ra"),
                    arrayOf(true, "ra.*", "raymond"),
                    arrayOf(true, ".*at", "cat"),
                    arrayOf(true, ".*at", "chat"),
                    arrayOf(false, ".*at", "chats"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$string ${if (result) "should" else "should not"} match $regex", result, Day25.solution(regex, string))
    }
}