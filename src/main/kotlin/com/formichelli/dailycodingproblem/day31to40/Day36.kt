package com.formichelli.dailycodingproblem.day31to40

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given the root to a binary search tree, find the second largest node in the tree.
*/
object Day36 {
    fun solution(binaryTree: TreeNode<Int>): Int {
        return if (binaryTree.right == null) {
            // if no right branch, the largest element is the root and second largest element is the largest of the left branche
            findLargest(binaryTree.left)
        } else {
            findSecondLargest(binaryTree)
        }
    }

    private fun findLargest(node: TreeNode<Int>?): Int {
        var currentNode = node
        while (currentNode?.right != null) {
            currentNode = currentNode.right
        }

        return currentNode?.value ?: throw IllegalArgumentException("node cannot be null")
    }

    private fun findSecondLargest(node: TreeNode<Int>?): Int {
        var currentNode = node
        while (currentNode?.right?.right != null) {
            currentNode = currentNode.right
        }

        return currentNode?.value ?: throw IllegalArgumentException("node cannot be null")
    }
}
