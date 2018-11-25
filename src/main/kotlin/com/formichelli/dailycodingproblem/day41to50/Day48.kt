package com.formichelli.dailycodingproblem.day41to50

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

For example, given the following preorder traversal:

[a, b, d, e, c, f, g]

And the following inorder traversal:

[d, b, e, a, f, c, g]

You should return the following tree:

    a
   / \
  b   c
 / \ / \
d  e f  g
*/
object Day48 {
    fun <T> solution(preOrder: List<T>, inOrder: List<T>): TreeNode<T> {
        return solutionHelper(preOrder, 0, preOrder.size - 1, inOrder, 0, inOrder.size - 1)
    }

    private fun <T> solutionHelper(preOrder: List<T>, preOrderFrom: Int, preOrderTo: Int, inOrder: List<T>, inOrderFrom: Int, inOrderTo: Int): TreeNode<T> {
        // split the problem in subproblems

        // the root of the tree is the first element of the preorder traversal
        val rootNode = TreeNode(preOrder[preOrderFrom])

        if (preOrderFrom == preOrderTo) {
            return rootNode
        }

        // the element of the left side of the tree in the inorder traversal will be the element up to the tree root
        val inOrderSplitIndex = inOrder.indexOf(rootNode.value)
        val leftSideSize = inOrderSplitIndex - inOrderFrom
        val rightSideSize = inOrderTo - inOrderSplitIndex

        // the element of the left side of the tree in the preorder will be the first leftSideSize after the first one
        val preOrderSplitIndex = preOrderFrom + leftSideSize + 1

        if (leftSideSize > 0) {
            rootNode.left = solutionHelper(preOrder, preOrderFrom + 1, preOrderSplitIndex - 1, inOrder, inOrderFrom, inOrderSplitIndex - 1)
        }

        if (rightSideSize > 0) {
            rootNode.right = solutionHelper(preOrder, preOrderSplitIndex, preOrderTo, inOrder, inOrderSplitIndex + 1, inOrderTo)
        }

        return rootNode
    }
}
