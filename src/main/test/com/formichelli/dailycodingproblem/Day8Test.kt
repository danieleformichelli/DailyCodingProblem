package com.formichelli.dailycodingproblem

import com.formichelli.dailycodingproblem.util.Node
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day8Test(private val result: Int, private val head: Node<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(5, Node(0, Node(1), Node(0, Node(1, Node(1), Node(1)), Node(0)))),
                    arrayOf(6, Node(0, Node(1), Node(0, Node(1, Node(1), Node(1)), Node(0, Node(0), Node(1))))),
                    arrayOf(7, Node(0, Node(1), Node(0, Node(1, Node(1), Node(1)), Node(0, Node(0), Node(0)))))
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals(String.format("%s contains %d unival trees", Day3.serializeTree(head), result), result, Day8.solution(head))
    }
}