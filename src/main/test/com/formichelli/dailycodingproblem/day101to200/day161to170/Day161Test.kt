package com.formichelli.dailycodingproblem.day101to200.day161to170

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day161Test(private val result: Int, private val number: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(0b11110000111100001111000011110000.toInt(), 0b00001111000011110000111100001111.toInt()))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Inverted $number is $result", result, Day161.solution(number))
    }
}