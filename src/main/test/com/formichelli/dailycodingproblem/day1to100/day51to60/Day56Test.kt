package com.formichelli.dailycodingproblem.day1to100.day51to60

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day56Test(private val result: Boolean, private val graph: Array<BooleanArray>, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val graph = arrayOf(
                    booleanArrayOf(false, true, true, true, true),
                    booleanArrayOf(true, false, false, true, true),
                    booleanArrayOf(true, false, false, false, true),
                    booleanArrayOf(true, false, false, true, true),
                    booleanArrayOf(true, true, false, false, false)
            )

            return listOf<Array<Any>>(
                    arrayOf(false, graph, 0),
                    arrayOf(false, graph, 1),
                    arrayOf(false, graph, 2),
                    arrayOf(true, graph, 3),
                    arrayOf(true, graph, 4),
                    arrayOf(true, graph, 5),
                    arrayOf(true, graph, 100))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Graph ${if (result) "can" else "cannot"} be colored using $k colors", result, Day56.solution(graph, k))
    }
}