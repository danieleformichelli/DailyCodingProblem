package com.formichelli.dailycodingproblem.day71to80

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.

    a
   / \
  b   c
 /
d
*/
object Day80 {
    fun <T> solution(root: TreeNode<T>): T {
        return solutionHelper(root).second!!
    }

    private fun <T> solutionHelper(root: TreeNode<T>?): Pair<Int, T?> {
        if (root == null) {
            return Pair(0, null)
        }

        val deepestLeftNode = solutionHelper(root.left)
        val deepestRightNode = solutionHelper(root.right)

        return if (deepestLeftNode.second == null && deepestRightNode.second == null) {
            Pair(1, root.value)
        } else if (deepestLeftNode.first >= deepestRightNode.first) {
            Pair(deepestLeftNode.first + 1, deepestLeftNode.second)
        } else {
            Pair(deepestRightNode.first + 1, deepestRightNode.second)
        }
    }
}
