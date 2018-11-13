package com.formichelli.dailycodingproblem.day91to100

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day93Test(private val result: Int, private val root: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val binaryTree = TreeNode(5)
            binaryTree.left = TreeNode(3)
            binaryTree.left?.left = TreeNode(2)
            binaryTree.left?.right = TreeNode(4)
            binaryTree.right = TreeNode(7)
            binaryTree.right?.left = TreeNode(6)
            binaryTree.right?.right = TreeNode(8)

            val size3BinarySubTree = TreeNode(5)
            size3BinarySubTree.left = TreeNode(3)
            size3BinarySubTree.left?.left = TreeNode(2)
            size3BinarySubTree.left?.right = TreeNode(4)
            size3BinarySubTree.right = TreeNode(7)
            size3BinarySubTree.right?.left = TreeNode(6)
            size3BinarySubTree.right?.right = TreeNode(8)
            size3BinarySubTree.right?.right?.left = TreeNode(2)

            val size2BinarySubTree = TreeNode(5)
            size2BinarySubTree.left = TreeNode(3)
            size2BinarySubTree.left?.right = TreeNode(1)
            size2BinarySubTree.right = TreeNode(3)
            size2BinarySubTree.right?.left = TreeNode(1)

            val noBinarySubTree = TreeNode(5)
            noBinarySubTree.left = TreeNode(3)
            noBinarySubTree.left?.right = TreeNode(1)
            noBinarySubTree.right = TreeNode(3)
            noBinarySubTree.right?.left = TreeNode(10)

            return listOf(
                    arrayOf(7, binaryTree),
                    arrayOf(3, size3BinarySubTree),
                    arrayOf(2, size2BinarySubTree),
                    arrayOf(1, noBinarySubTree))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Biggest sub-BST of $root should be of size $result", result, Day93.solution(root))
    }
}