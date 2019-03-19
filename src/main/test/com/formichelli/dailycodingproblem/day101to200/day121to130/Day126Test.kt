package com.formichelli.dailycodingproblem.day101to200.day121to130

import com.formichelli.dailycodingproblem.util.ListNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day126Test(private val result: List<Int>, private val numbers: List<Int>, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            return listOf<Array<Any?>>(
                    arrayOf(listOf(3, 4, 5, 6, 1, 2), listOf(1, 2, 3, 4, 5, 6), 2),
                    arrayOf(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), 6))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$result is obtained by rotating $numbers by $k", result, Day126.solution(ListNode.fromList(numbers), k).toList())
    }
}