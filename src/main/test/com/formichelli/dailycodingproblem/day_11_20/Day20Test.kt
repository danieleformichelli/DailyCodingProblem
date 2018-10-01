package com.formichelli.dailycodingproblem.day_11_20

import com.formichelli.dailycodingproblem.day_11_20.Day20
import com.formichelli.dailycodingproblem.util.ListNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day20Test(private val result: Int, private val listA: List<Int>, private val listB: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(arrayOf(8, listOf(3, 7, 8, 10), listOf(99, 1, 8, 10)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Intersection point of $listA and $listB should be $result", result, Day20.solution(ListNode.fromList(listA), ListNode.fromList(listB))!!.value)
    }

}