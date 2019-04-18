package com.formichelli.dailycodingproblem.day101to200.day141to150

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given a binary tree where all nodes are either 0 or 1, prune the tree so that subtrees containing all 0s are removed.

For example, given the following tree:

   0
  / \
 1   0
    / \
   1   0
  / \
 0   0
should be pruned to:

   0
  / \
 1   0
    /
   1
We do not remove the tree at the root or its left child because it still has a 1 as a descendant.
*/
object Day146 {
    fun <T> solution(root: TreeNode<T>): TreeNode<T> {
        solutionHelper(root)
        return root
    }

    private fun <T> solutionHelper(currentNode: TreeNode<T>?): Boolean {
        if (currentNode == null) return true
        val leftIsZero = solutionHelper(currentNode.left)
        val rightIsZero = solutionHelper(currentNode.right)
        if (currentNode.value == 0 && leftIsZero && rightIsZero) {
            // prune
            val parent = currentNode.parent
            when {
                parent == null -> return true
                currentNode == parent.left -> parent.left = null
                currentNode == parent.right -> parent.right = null
            }

            return true
        } else {
            return false
        }
    }
}