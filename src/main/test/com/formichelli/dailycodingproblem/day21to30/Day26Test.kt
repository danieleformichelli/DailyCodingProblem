package com.formichelli.dailycodingproblem.day21to30

import com.formichelli.dailycodingproblem.util.ListNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day26Test(private val result: ListNode<Int>, private val inputList: ListNode<Int>, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(ListNode.fromList(listOf(1, 2, 3, 4)), ListNode.fromList(listOf(1, 2, 3, 4, 5)), 1),
                    arrayOf(ListNode.fromList(listOf(1, 2, 3, 5)), ListNode.fromList(listOf(1, 2, 3, 4, 5)), 2),
                    arrayOf(ListNode.fromList(listOf(1, 2, 4, 5)), ListNode.fromList(listOf(1, 2, 3, 4, 5)), 3),
                    arrayOf(ListNode.fromList(listOf(1, 3, 4, 5)), ListNode.fromList(listOf(1, 2, 3, 4, 5)), 4),
                    arrayOf(ListNode.fromList(listOf(2, 3, 4, 5)), ListNode.fromList(listOf(1, 2, 3, 4, 5)), 5))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("${inputList.toList()} removing ${k}th last character should be ${result.toList()}", result.toList(), Day26.solution(inputList, k).toList())
    }
}