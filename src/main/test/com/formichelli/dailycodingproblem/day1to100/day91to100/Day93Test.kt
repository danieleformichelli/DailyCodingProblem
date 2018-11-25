package com.formichelli.dailycodingproblem.day1to100.day91to100

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
            val binarySearchTree = TreeNode(5)
            binarySearchTree.left = TreeNode(3)
            binarySearchTree.left?.left = TreeNode(2)
            binarySearchTree.left?.right = TreeNode(4)
            binarySearchTree.right = TreeNode(7)
            binarySearchTree.right?.left = TreeNode(6)
            binarySearchTree.right?.right = TreeNode(8)

            val size3BinarySearchSubTree = TreeNode(5)
            size3BinarySearchSubTree.left = TreeNode(3)
            size3BinarySearchSubTree.left?.left = TreeNode(2)
            size3BinarySearchSubTree.left?.right = TreeNode(4)
            size3BinarySearchSubTree.right = TreeNode(7)
            size3BinarySearchSubTree.right?.left = TreeNode(6)
            size3BinarySearchSubTree.right?.right = TreeNode(8)
            size3BinarySearchSubTree.right?.right?.left = TreeNode(2)

            val size2BinarySearchSubTree = TreeNode(5)
            size2BinarySearchSubTree.left = TreeNode(3)
            size2BinarySearchSubTree.left?.right = TreeNode(1)
            size2BinarySearchSubTree.right = TreeNode(3)
            size2BinarySearchSubTree.right?.left = TreeNode(1)

            val noBinarySearchSubTree = TreeNode(5)
            noBinarySearchSubTree.left = TreeNode(3)
            noBinarySearchSubTree.left?.right = TreeNode(1)
            noBinarySearchSubTree.right = TreeNode(3)
            noBinarySearchSubTree.right?.left = TreeNode(10)

            return listOf(
                    arrayOf(7, binarySearchTree),
                    arrayOf(3, size3BinarySearchSubTree),
                    arrayOf(2, size2BinarySearchSubTree),
                    arrayOf(1, noBinarySearchSubTree))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Biggest sub-BST of $root should be of size $result", result, Day93.solution(root))
    }
}