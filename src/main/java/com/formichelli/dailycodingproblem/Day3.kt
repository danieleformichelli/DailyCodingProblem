package com.formichelli.dailycodingproblem

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following TreeNode class

class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = TreeNode('root', TreeNode('left', TreeNode('left.left')), TreeNode('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

*/

// NOTE: this solution assumes the value of TreeNode does not contain any ','. Otherwise, escaping is required

object Day3 {
    fun <T> serializeTree(root: TreeNode<T>?): String = if (root != null) String.format("%s,%s,%s", root.value.toString(), serializeTree(root.left), serializeTree(root.right)) else "null"

    fun deserializeTree(serialized: String): TreeNode<String>? {
        return deserializeTree(serialized.split(','), 0)[0] as TreeNode<String>?
    }

    private fun deserializeTree(serializedSplit: List<String>, index: Int): List<Any?> {
        val nodeValue = serializedSplit[index]
        if (nodeValue == "null") return listOf<Any?>(null, 1)
        val (leftNode, leftNodeSize) = deserializeTree(serializedSplit, index + 1)
        val (rightNode, rightNodeSize) = deserializeTree(serializedSplit, index + 1 + leftNodeSize as Int)
        return listOf(TreeNode(nodeValue, leftNode as TreeNode<String>?, rightNode as TreeNode<String>?), leftNodeSize + 1 + rightNodeSize as Int)
    }

}
