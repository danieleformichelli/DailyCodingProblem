package com.formichelli.dailycodingproblem.day101to200.day131to140

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given a node in a binary tree, return the next bigger element, also known as the inorder successor.

For example, the inorder successor of 22 is 30.

   10
  /  \
 5    30
     /  \
   22    35
You can assume each node has a parent pointer.
*/
object Day133 {
    fun solution(node: TreeNode<Int>?): Int? {
        // assuming the tree is a BST
        if (node == null) {
            return null
        }

        when {
            node.right != null -> {
                // node has right subtree, get the smallest element of the subtree
                return smallest(node.right!!)
            }

            node == node.parent?.left -> {
                // root has no right subtree and is left child. Next element is the parent
                return node.parent?.value
            }

            else -> {
                // root has no right subtree and is right child. Navigate the tree until we are a left child, then the parent is the next element
                var current = node
                while (current != current?.parent?.left) {
                    current = current?.parent
                }

                return current?.parent?.value
            }
        }
    }

    private fun smallest(node: TreeNode<Int>): Int {
        return if (node.left == null) {
            node.value
        } else {
            smallest(node.left!!)
        }
    }
}