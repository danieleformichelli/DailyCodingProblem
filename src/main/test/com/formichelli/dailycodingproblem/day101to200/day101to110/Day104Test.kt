package com.formichelli.dailycodingproblem.day101to200.day101to110

import com.formichelli.dailycodingproblem.util.ListNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day104Test(private val result: Boolean, private val list: ListNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(true, ListNode.fromList(listOf(1, 3, 4, 3, 1))),
                    arrayOf(true, ListNode.fromList(listOf(1, 3, 4, 4, 3, 1))),
                    arrayOf(false, ListNode.fromList(listOf(1, 3, 4, 5, 3, 1))),
                    arrayOf(false, ListNode.fromList(listOf(1, 3, 4, 2, 1))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$list ${if (result) "is" else "is not"} palindrome", result, Day104.solution(list))
    }
}