package com.formichelli.dailycodingproblem

import com.formichelli.dailycodingproblem.util.Node

/*
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

*/

// NOTE: this solution assumes the value of Node does not contain any ','. Otherwise, escaping is required

object Day3 {
    fun serializeTree(root: Node<String>?): String = if (root != null) String.format("%s,%s,%s", root.value, serializeTree(root.left), serializeTree(root.right)) else "null"

    fun deserializeTree(serialized: String): Node<String>? {
        return deserializeTree(serialized.split(','), 0)[0] as Node<String>?
    }

    private fun deserializeTree(serializedSplit: List<String>, index: Int): List<Any?> {
        val nodeValue = serializedSplit[index]
        if (nodeValue == "null") return listOf<Any?>(null, 1)
        val (leftNode, leftNodeSize) = deserializeTree(serializedSplit, index + 1)
        val (rightNode, rightNodeSize) = deserializeTree(serializedSplit, index + 1 + leftNodeSize as Int)
        return listOf(Node(nodeValue, leftNode as Node<String>?, rightNode as Node<String>?), leftNodeSize + 1 + rightNodeSize as Int)
    }

}
