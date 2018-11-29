package com.formichelli.dailycodingproblem.day101to200.day111to120

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. Assume that each node in the tree also has a pointer to its parent.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).
*/
object Day112 {
    fun <T> solution(nodeA: TreeNode<T>, nodeB: TreeNode<T>): TreeNode<T>? {
        val nodeALevel = getNodeLevel(nodeA)
        val nodeBLevel = getNodeLevel(nodeB)

        var nodeAAncestor: TreeNode<T>? = nodeA
        var nodeBAncestor: TreeNode<T>? = nodeB
        if (nodeALevel > nodeBLevel) {
            for (i in nodeBLevel until nodeALevel) {
                nodeAAncestor = nodeAAncestor?.parent!!
            }
        } else if (nodeBLevel > nodeALevel) {
            for (i in nodeALevel until nodeBLevel) {
                nodeBAncestor = nodeBAncestor?.parent!!
            }
        }

        while (nodeAAncestor != nodeBAncestor) {
            nodeAAncestor = nodeAAncestor?.parent
            nodeBAncestor = nodeBAncestor?.parent
        }

        return nodeAAncestor
    }

    private fun <T> getNodeLevel(node: TreeNode<T>?): Int {
        if (node == null) {
            return 0
        }
        return 1 + getNodeLevel(node.parent)
    }
}