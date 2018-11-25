package com.formichelli.dailycodingproblem.day81to90

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Determine whether a tree is a valid binary search tree.

A binary search tree is a tree with two children, left and right, and satisfies the constraint that the key in the left child must be less than or equal to the root and the key in the right child must be greater than or equal to the root.
*/
object Day89 {
    fun solution(root: TreeNode<Int>): Boolean {
        return solutionHelper(root) != null
    }

    // return the minimum and maximum value of a binary search tree, null if the tree is not a binary search
    private fun solutionHelper(node: TreeNode<Int>): Pair<Int, Int>? {
        val min = when {
            node.left == null -> node.value
            else -> {
                val leftTreeMinMax = solutionHelper(node.left!!)
                if (leftTreeMinMax == null || leftTreeMinMax.second > node.value) {
                    // left is not a binary search tree or has elements bigger than current node
                    null
                } else {
                    leftTreeMinMax.first
                }
            }
        }

        val max = when {
            node.right == null -> node.value
            else -> {
                val rightTreeMinMax = solutionHelper(node.right!!)
                if (rightTreeMinMax == null || rightTreeMinMax.first < node.value) {
                    // right is not a binary search tree or has elements smaller than current node
                    null
                } else {
                    rightTreeMinMax.second
                }
            }
        }

        if (min == null || max == null) {
            return null
        }

        return Pair(min, max)
    }


}