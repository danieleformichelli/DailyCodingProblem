package com.formichelli.dailycodingproblem.day101to200.day141to150

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day146Test(private val result: TreeNode<Int>, private val root: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            /* 0
              / \
             1   0
                / \
               1   0
              / \
             0   0
             */
            val root = TreeNode(0)
            root.left = TreeNode(1)
            root.right = TreeNode(0)
            root.right?.left = TreeNode(1)
            root.right?.right = TreeNode(0)
            root.right?.left?.left = TreeNode(0)
            root.right?.left?.right = TreeNode(0)

            /*
               0
              / \
             1   0
                /
               1
             */
            val prunedRoot = TreeNode(0)
            prunedRoot.left = TreeNode(1)
            prunedRoot.right = TreeNode(0)
            prunedRoot.right?.left = TreeNode(1)

            return listOf(
                    arrayOf<Any?>(prunedRoot, root))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Pruned version of $root is $result", result, Day146.solution(root))
    }
}