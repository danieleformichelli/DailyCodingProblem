package com.formichelli.dailycodingproblem.day1to100.day1to100.day91to100

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day94Test(private val result: Int, private val root: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val binaryTree1 = TreeNode(5)
            binaryTree1.left = TreeNode(3)
            binaryTree1.left?.left = TreeNode(2)
            binaryTree1.left?.right = TreeNode(4)
            binaryTree1.right = TreeNode(7)
            binaryTree1.right?.left = TreeNode(6)
            binaryTree1.right?.right = TreeNode(8)

            val binaryTree2 = TreeNode(5)
            binaryTree2.left = TreeNode(3)
            binaryTree2.left?.left = TreeNode(2)
            binaryTree2.left?.right = TreeNode(4)
            binaryTree2.right = TreeNode(7)
            binaryTree2.right?.left = TreeNode(6)
            binaryTree2.right?.right = TreeNode(8)
            binaryTree2.right?.right?.left = TreeNode(2)

            val binaryTree3 = TreeNode(5)
            binaryTree3.left = TreeNode(3)
            binaryTree3.left?.right = TreeNode(1)
            binaryTree3.right = TreeNode(3)
            binaryTree3.right?.left = TreeNode(1)

            val binaryTree4 = TreeNode(5)
            binaryTree4.left = TreeNode(3)
            binaryTree4.left?.right = TreeNode(1)
            binaryTree4.right = TreeNode(3)
            binaryTree4.right?.left = TreeNode(10)

            val binaryTree5 = TreeNode(5)
            binaryTree5.left = TreeNode(3)
            binaryTree5.left?.left = TreeNode(2)
            binaryTree5.left?.right = TreeNode(4)
            binaryTree5.right = TreeNode(10)
            binaryTree5.right?.left = TreeNode(-6)
            binaryTree5.right?.right = TreeNode(-3)
            binaryTree5.right?.right?.left = TreeNode(2)

            return listOf(
                    arrayOf(20, binaryTree1),
                    arrayOf(22, binaryTree2),
                    arrayOf(9, binaryTree3),
                    arrayOf(18, binaryTree4),
                    arrayOf(15, binaryTree5))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Biggest path sum of $root should be $result", result, Day94.solution(root))
    }
}