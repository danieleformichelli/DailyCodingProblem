package com.formichelli.dailycodingproblem.day81to90

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day89Test(private val result: Boolean, private val root: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val binarySearchTree = TreeNode(3)
            binarySearchTree.left = TreeNode(3)
            binarySearchTree.left?.left = TreeNode(1)
            binarySearchTree.right = TreeNode(3)
            binarySearchTree.right?.right = TreeNode(5)
            binarySearchTree.right?.right?.left = TreeNode(4)
            binarySearchTree.right?.right?.right = TreeNode(6)


            val notBinarySearchTree = TreeNode(3)
            notBinarySearchTree.left = TreeNode(3)
            notBinarySearchTree.left?.left = TreeNode(1)
            notBinarySearchTree.right = TreeNode(3)
            notBinarySearchTree.right?.right = TreeNode(5)
            notBinarySearchTree.right?.left = TreeNode(2)

            return listOf(
                    arrayOf(true, binarySearchTree),
                    arrayOf(false, notBinarySearchTree))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$root ${if (result) "is" else "is not"} a binary search tree", result, Day89.solution(root))
    }
}