package com.formichelli.dailycodingproblem.day101to200.day131to140

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given a binary tree, find a minimum path sum from root to a leaf.

For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15.

  10
 /  \
5    5
 \     \
   2    1
       /
     -1
*/
object Day135 {
    fun solution(root: TreeNode<Int>): Int {
        return solutionHelper(root)
    }

    private fun solutionHelper(current: TreeNode<Int>?): Int {
        if (current == null) {
            return Int.MAX_VALUE
        }

        if (current.left == null && current.right == null) {
            return current.value
        }

        return current.value + Math.min(solutionHelper(current.left), solutionHelper(current.right))
    }
}