package com.formichelli.dailycodingproblem.day1to100.day91to100

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given a tree, find the largest tree/subtree that is a BST.

Given a tree, return the size of the largest tree/subtree that is a BST.
*/
object Day93 {
    fun solution(root: TreeNode<Int>): Int {
        return solutionHelper(root).biggestBinarySubTreeSize
    }

    private data class BinaryTreeInfo(val biggestBinarySubTreeSize: Int, val isBinaryTree: Boolean, val min: Int, val max: Int)

    // return a pair containing a boolean indicating if the tree is a BST, and the size of the biggest sub-BST
    private fun solutionHelper(node: TreeNode<Int>?): BinaryTreeInfo {
        if (node == null) {
            return BinaryTreeInfo(0, true, 0, 0)
        }

        val leftTreeBinaryTreeInfo = solutionHelper(node.left)
        val rightTreeBinaryTreeInfo = solutionHelper(node.right)
        if (!(leftTreeBinaryTreeInfo.isBinaryTree && rightTreeBinaryTreeInfo.isBinaryTree)) {
            return BinaryTreeInfo(Math.max(leftTreeBinaryTreeInfo.biggestBinarySubTreeSize, rightTreeBinaryTreeInfo.biggestBinarySubTreeSize), false, 0, 0)
        }

        val min = when {
            leftTreeBinaryTreeInfo.biggestBinarySubTreeSize == 0 -> node.value
            leftTreeBinaryTreeInfo.max <= node.value -> leftTreeBinaryTreeInfo.min
            else -> Int.MIN_VALUE
        }

        val max = when {
            rightTreeBinaryTreeInfo.biggestBinarySubTreeSize == 0 -> node.value
            rightTreeBinaryTreeInfo.min >= node.value -> rightTreeBinaryTreeInfo.max
            else -> Int.MAX_VALUE
        }

        return if (min == Int.MIN_VALUE || max == Int.MAX_VALUE) {
            BinaryTreeInfo(Math.max(leftTreeBinaryTreeInfo.biggestBinarySubTreeSize, rightTreeBinaryTreeInfo.biggestBinarySubTreeSize), false, 0, 0)
        } else {
            BinaryTreeInfo(leftTreeBinaryTreeInfo.biggestBinarySubTreeSize + rightTreeBinaryTreeInfo.biggestBinarySubTreeSize + 1, true, min, max)
        }
    }
}
