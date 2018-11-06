package com.formichelli.dailycodingproblem.day81to90

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Invert a binary tree.

For example, given the following tree:

    a
   / \
  b   c
 / \  /
d   e f
should become:

  a
 / \
 c  b
 \  / \
  f e  d
*/
object Day83 {
    fun <T> solution(root: TreeNode<T>?) {
        if (root == null) {
            return
        }

        val tmp = root.left
        root.left = root.right
        root.right = tmp
        solution(root.left)
        solution(root.right)
    }
}