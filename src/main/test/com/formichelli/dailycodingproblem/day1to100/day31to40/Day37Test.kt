package com.formichelli.dailycodingproblem.day1to100.day31to40

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day37Test(private val result: Set<Set<Int>>, private val inputSet: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(setOf(setOf(), setOf(1), setOf(2), setOf(3), setOf(1, 2), setOf(1, 3), setOf(2, 3), setOf(1, 2, 3)), listOf(1, 2, 3)))
        }
    }

    @Test
    fun solution() {
        val superSet = Day37.solution(inputSet)
        Assert.assertEquals("Superset of $inputSet should be $result", result, superSet)
    }
}