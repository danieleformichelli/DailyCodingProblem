package com.formichelli.dailycodingproblem.day101to200.day101to110

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day106Test(private val result: Boolean, private val list: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(true, listOf(2, 0, 1, 0)),
                    arrayOf(false, listOf(1, 1, 0, 1)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$list should return $result", result, Day106.solution(list))
    }
}