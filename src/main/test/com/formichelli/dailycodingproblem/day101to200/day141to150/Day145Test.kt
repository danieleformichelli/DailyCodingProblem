package com.formichelli.dailycodingproblem.day101to200.day141to150

import com.formichelli.dailycodingproblem.util.ListNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day145Test(private val result: List<Int>, private val numbers: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(listOf(2, 1, 4, 3), listOf(1, 2, 3, 4)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Swapped list of $numbers is $result", result, Day145.solution(ListNode.fromList(numbers)).toList())
    }
}