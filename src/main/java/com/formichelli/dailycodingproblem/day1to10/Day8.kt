package com.formichelli.dailycodingproblem.day1to10

import com.formichelli.dailycodingproblem.util.TreeNode

/*
A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
*/
object Day8 {
    fun solution(head: TreeNode<Int>): Int {
        return univalTreeCount(head)[1]!!
    }

    private fun univalTreeCount(head: TreeNode<Int>?): List<Int?> {
        if (head == null)
            return listOf(null, 0)

        if (head.left == null && head.right == null)
            return listOf(head.value, 1)

        val (leftUnivalTreeValue, leftUnivalTreeCount) = univalTreeCount(head.left)
        val (rightUnivalTreeValue, rightUnivalTreeCount) = univalTreeCount(head.right)

        var univalTreeCount = leftUnivalTreeCount!! + rightUnivalTreeCount!!
        if (head.value == leftUnivalTreeValue && head.value == rightUnivalTreeValue)
        {
            return listOf(head.value, univalTreeCount + 1)
        }
        else
        {
            return listOf(null, univalTreeCount)
        }
    }
}