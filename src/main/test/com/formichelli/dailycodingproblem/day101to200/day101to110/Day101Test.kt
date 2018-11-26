package com.formichelli.dailycodingproblem.day101to200.day101to110

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day101Test(private val result: Pair<Int, Int>, private val number: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(Pair(2, 2), 4),
                    arrayOf(Pair(3, 17), 20),
                    arrayOf(Pair(3, 97), 100))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$number can be obtained as the sum of ${result.first} and ${result.second}", result, Day101.solution(number))
    }
}