package com.formichelli.dailycodingproblem.day101to200.day101to110

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day110Test(private val result: List<List<Int>>, private val root: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val root = TreeNode(1)
            root.left = TreeNode(2)
            root.right = TreeNode(3)
            root.right?.left = TreeNode(4)
            root.right?.right = TreeNode(5)

            return listOf(
                    arrayOf(listOf(listOf(1, 2), listOf(1, 3, 4), listOf(1, 3, 5)), root))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("All paths of $root should be $result", result, Day110.solution(root))
    }
}