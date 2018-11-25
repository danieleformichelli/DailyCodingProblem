package com.formichelli.dailycodingproblem.day1to100.day1to100.day81to90

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day84Test(private val result: Int, private val matrix: Array<BooleanArray>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(arrayOf(4,
                    arrayOf(
                            booleanArrayOf(true, false, false, false, false),
                            booleanArrayOf(false, false, true, true, false),
                            booleanArrayOf(false, true, true, false, false),
                            booleanArrayOf(false, false, false, false, false),
                            booleanArrayOf(true, true, false, false, true),
                            booleanArrayOf(true, true, false, false, true))),
                    arrayOf(3, arrayOf(
                            booleanArrayOf(true, false, false, false, false),
                            booleanArrayOf(false, true, true, true, false),
                            booleanArrayOf(false, true, true, false, false),
                            booleanArrayOf(false, false, false, false, false),
                            booleanArrayOf(true, true, false, false, true),
                            booleanArrayOf(true, true, false, false, true))),
                    arrayOf(4, arrayOf(
                            booleanArrayOf(true, false, false, false, false),
                            booleanArrayOf(false, false, true, true, false),
                            booleanArrayOf(false, true, true, false, true),
                            booleanArrayOf(false, false, false, false, false),
                            booleanArrayOf(true, true, false, false, true),
                            booleanArrayOf(true, true, false, false, true)))
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Matrix should contain $result islands", result, Day84.solution(matrix))
    }
}