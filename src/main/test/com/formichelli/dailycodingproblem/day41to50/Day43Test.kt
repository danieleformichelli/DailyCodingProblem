package com.formichelli.dailycodingproblem.day41to50

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day43Test(private val result: Int, private val numbers: List<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            // Int.MIN_VALUE means pop
            return listOf(
                    arrayOf(61, listOf(12, 1, 61, 5, 9, 2)),
                    arrayOf(12, listOf(12, 1, 61, 5, Int.MIN_VALUE, Int.MIN_VALUE, 9, 2)))
        }
    }

    @Test
    fun solution() {
        val maxStack = Day43.MaxStack()
        numbers.forEach {
            if (it != Int.MIN_VALUE) {
                maxStack.push(it)
            } else {
                maxStack.pop()
            }
        }

        Assert.assertEquals("Max after $numbers should be $result", result, maxStack.max())
    }
}