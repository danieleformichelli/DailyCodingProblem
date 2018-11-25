package com.formichelli.dailycodingproblem.day1to100.day1to10

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day6Test(private val list: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(intArrayOf(1, 2, 3)),
                    arrayOf<Any>(intArrayOf(2, 3, 4)),
                    arrayOf<Any>(intArrayOf(-1, 10, 13))
            )
        }
    }

    @Test
    fun solution() {
        var head: Day6.XorNode<Int>? = null
        list.forEach {
            if (head == null)
                head = Day6.allocateNode(it, 0)
            else
                Day6.add(head!!, it)
        }

        list.forEachIndexed { index, value ->
            Assert.assertEquals(String.format("list[%d] should be %d", index, value), value, Day6.get(head!!, index))
        }
    }
}