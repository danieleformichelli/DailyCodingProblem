package com.formichelli.dailycodingproblem.day101to200.day111to120

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day112Test(private val result: TreeNode<Int>?, private val nodeA: TreeNode<Int>, private val nodeB: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            val root = TreeNode(1)
            root.left = TreeNode(2)
            root.right = TreeNode(3)
            root.right?.left = TreeNode(4)
            root.right?.right = TreeNode(5)
            root.right?.right?.right = TreeNode(6)
            root.right?.right?.right?.left = TreeNode(7)

            return listOf<Array<Any?>>(
                    arrayOf(root.right!!, root.right?.right?.right?.left!!, root.right?.left!!),
                    arrayOf(root, root.right?.right?.right?.left!!, root.left!!),
                    arrayOf(null, root.right?.right?.right?.left!!, TreeNode(0)))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Lowest common ancestor of ${nodeA.value} and ${nodeB.value} should be ${result?.value}", result, Day112.solution(nodeA, nodeB))
    }
}