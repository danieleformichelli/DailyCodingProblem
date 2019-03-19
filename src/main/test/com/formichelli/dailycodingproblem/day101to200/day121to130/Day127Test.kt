package com.formichelli.dailycodingproblem.day101to200.day121to130

import com.formichelli.dailycodingproblem.util.ListNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day127Test(private val result: ListNode<Int>, private val a: ListNode<Int>, private val b: ListNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            val list99 = ListNode.fromList(listOf(9, 9))
            val list25 = ListNode.fromList(listOf(5, 2))
            val list124 = ListNode.fromList(listOf(4, 2, 1))
            val list1001 = ListNode.fromList(listOf(1, 0, 0, 1))
            val list1100 = ListNode.fromList(listOf(0, 0, 1, 1))

            return listOf<Array<Any?>>(
                    arrayOf(list124, list99, list25),
                    arrayOf(list1100, list99, list1001))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("${a.toList().reversed()} plus ${b.toList().reversed()} should be ${result.toList().reversed()}", result.toList(), Day127.solution(a, b).toList())
    }
}