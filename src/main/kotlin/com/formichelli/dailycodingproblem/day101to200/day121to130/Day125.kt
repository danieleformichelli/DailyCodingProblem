package com.formichelli.dailycodingproblem.day101to200.day121to130

import com.formichelli.dailycodingproblem.util.TreeNode
import com.formichelli.dailycodingproblem.util.Utils

/*
Given the root of a binary search tree, and a target K, return two nodes in the tree whose sum equals K.

For example, given the following tree and K of 20

    10
   /   \
 5      15
       /  \
     11    15
Return the nodes 5 and 15.
*/
object Day125 {
    fun solution(root: TreeNode<Int>, k: Int): Pair<Int, Int>? {
        return solutionHelper(root, k, root)
    }

    private fun solutionHelper(root: TreeNode<Int>, k: Int, currentNode: TreeNode<Int>?): Pair<Int, Int>? {
        if (currentNode == null) {
            return null
        }

        val complement = Utils.findComplementInBST(root, k, currentNode)
        if (complement != null) {
            return Pair(currentNode.value, complement.value)
        }

        val foundInLeft = solutionHelper(root, k, currentNode.left)
        if (foundInLeft != null) {
            return foundInLeft
        }

        val foundInRight = solutionHelper(root, k, currentNode.right)
        if (foundInRight != null) {
            return foundInRight
        }

        return null
    }
}