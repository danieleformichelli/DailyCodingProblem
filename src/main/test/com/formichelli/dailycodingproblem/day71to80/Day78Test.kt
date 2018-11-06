package com.formichelli.dailycodingproblem.day71to80

import com.formichelli.dailycodingproblem.util.ListNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day78Test(private val result: ListNode<Int>, private val lists: List<ListNode<Int>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(ListNode.fromList(listOf(1, 2, 3, 4, 5, 6, 7)), listOf(ListNode.fromList(listOf(7)), ListNode.fromList(listOf(1, 4, 6)), ListNode.fromList(listOf(2, 3, 5)))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Merged sorted list should be", result.toList(), Day78.solution(lists)!!.toList())
    }
}