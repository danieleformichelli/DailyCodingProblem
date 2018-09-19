package com.formichelli.dailycodingproblem

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day8Test(private val result: Int, private val head: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(5, TreeNode(0, TreeNode(1), TreeNode(0, TreeNode(1, TreeNode(1), TreeNode(1)), TreeNode(0)))),
                    arrayOf(6, TreeNode(0, TreeNode(1), TreeNode(0, TreeNode(1, TreeNode(1), TreeNode(1)), TreeNode(0, TreeNode(0), TreeNode(1))))),
                    arrayOf(7, TreeNode(0, TreeNode(1), TreeNode(0, TreeNode(1, TreeNode(1), TreeNode(1)), TreeNode(0, TreeNode(0), TreeNode(0)))))
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals(String.format("%s contains %d unival trees", Day3.serializeTree(head), result), result, Day8.solution(head))
    }
}