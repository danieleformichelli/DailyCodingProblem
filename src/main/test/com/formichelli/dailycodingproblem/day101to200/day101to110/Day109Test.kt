package com.formichelli.dailycodingproblem.day101to200.day101to110

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day109Test(private val result: Int, private val number: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(0b01010101, 0b10101010),
                    arrayOf(0b11010001, 0b11100010))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Swapped $number should be $result", result, Day109.solution(result))
    }
}