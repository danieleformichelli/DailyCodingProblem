package com.formichelli.dailycodingproblem.day101to200.day101to110

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day107Test(private val result: List<Int>, private val root: TreeNode<Int>) {
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
                    arrayOf(listOf(1, 2, 3, 4, 5), root))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Level-wise print of $root should be $result", result, Day107.solution(root))
    }
}