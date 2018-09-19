package com.formichelli.dailycodingproblem

import com.formichelli.dailycodingproblem.util.ListNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day20Test(private val result: Int, private val listA: List<Int>, private val listB: List<Int>) {
    private val nodesMap = HashMap<Int, ListNode<Int>>()

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(arrayOf(8, listOf(3, 7, 8, 10), listOf(99, 1, 8, 10)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Intersection point should be $result", result, Day20.solution(listNodeFromList(listA), listNodeFromList(listB))!!.value)
    }

    private fun listNodeFromList(list: List<Int>): ListNode<Int> {
        val listNodeHead = createListNode(list[0])
        var listNodeTail = listNodeHead
        list.stream().skip(1).forEach {
            listNodeTail.next = createListNode(it)
            listNodeTail = listNodeTail.next!!
        }

        return listNodeHead
    }

    private fun createListNode(value: Int) = nodesMap.computeIfAbsent(value) { ListNode(value) }
}