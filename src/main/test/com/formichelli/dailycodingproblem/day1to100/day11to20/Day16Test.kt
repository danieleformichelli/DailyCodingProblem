package com.formichelli.dailycodingproblem.day1to100.day11to20

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day16Test(private val result: String, private val logSize: Int, private val orders: List<String>, private val i: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf("7", 5, listOf("1", "2", "3", "4", "5", "6", "7", "8", "9"), 3),
                    arrayOf("8", 5, listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), 3),
                    arrayOf("10", 20, listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), 1)
            )
        }
    }

    @Test
    fun solution() {
        val orderLog = Day16.OrderLog(logSize)
        orders.forEach { orderLog.record(it) }
        Assert.assertEquals("Returned value should be $result", result, orderLog.getLast(i))
    }
}