package com.formichelli.dailycodingproblem.day1to100.day1to100.day91to100

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given a binary tree of integers, find the maximum path sum between two nodes. The path must go through at least one node, and does not need to go through the root.
*/
object Day94 {
    fun solution(root: TreeNode<Int>): Int {
        return solutionHelper(root).second
    }

    fun solutionHelper(node: TreeNode<Int>?): Pair<Int, Int> {
        if (node == null) {
            return Pair(0, 0)
        }

        val maximumPathFromLeft = solutionHelper(node.right)
        val maximumPathFromRight = solutionHelper(node.left)

        val maximumIncludingNode = Math.max(Math.max(maximumPathFromLeft.first, maximumPathFromRight.first), 0) + node.value
        val maximumOfSubTree = Math.max(maximumIncludingNode, Math.max(maximumPathFromLeft.second, maximumPathFromRight.second))
        return Pair(maximumIncludingNode, maximumOfSubTree)
    }
}