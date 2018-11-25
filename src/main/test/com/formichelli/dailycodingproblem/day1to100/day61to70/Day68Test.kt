package com.formichelli.dailycodingproblem.day1to100.day61to70

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day68Test(private val result: Int, private val M: Int, private val bishops: List<Pair<Int, Int>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            // -1 in operation value means get
            return listOf(
                    arrayOf(2, 5, listOf(Pair(0, 0), Pair(1, 2), Pair(2, 2), Pair(4, 0))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("On the chessboard there are $result bishops pairs that can attack each others", result, Day68.solution(M, bishops))
    }
}