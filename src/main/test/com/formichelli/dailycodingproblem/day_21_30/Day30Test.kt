package com.formichelli.dailycodingproblem.day_21_30

import com.formichelli.dailycodingproblem.day_21_30.Day30
import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day30Test(private val result: Int, private val walls: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(1, intArrayOf(2, 1, 2)),
                    arrayOf(8, intArrayOf(3, 0, 1, 3, 0, 5)),
                    arrayOf(13, intArrayOf(3, 0, 1, 3, 0, 5, 1, 5, 3, 4)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("${Utils.prettyPrint(walls)} walls can trap $result unit of water", result, Day30.solution(walls))
    }
}