package com.formichelli.dailycodingproblem.day1to100.day71to80

import com.formichelli.dailycodingproblem.util.ListNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day73Test(private val result: List<Int>, private val head: ListNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(listOf(1, 2, 3, 4, 5), ListNode(5, ListNode(4, ListNode(3, ListNode(2, ListNode(1)))))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Reverted ${head.toList()} should be $result", result, Day73.solution(head).toList())
    }
}