package com.formichelli.dailycodingproblem.day1to100.day1to100.day71to80

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day72Test(private val result: Int, private val letters: String, private val edgesList: List<Pair<Int, Int>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(3, "ABACA", listOf(Pair(0, 1), Pair(0, 2), Pair(2, 3), Pair(3, 4))),
                    arrayOf(-1, "A", listOf(Pair(0, 0))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Max value path of $letters with edges $edgesList should be $result", result, Day72.solution(letters, edgesList))
    }
}