package com.formichelli.dailycodingproblem.day101to200.day141to150

import com.formichelli.dailycodingproblem.util.ListNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day143Test(private val result: List<Int>, private val numbers: ListNode<Int>, private val x: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf(9, 3, 5, 10, 10, 12, 14), ListNode.fromList(listOf(9, 12, 3, 5, 14, 10, 10)), 10))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Partition ordering of $numbers is $result", result.toList(), Day143.solution(numbers, x).toList())
    }
}