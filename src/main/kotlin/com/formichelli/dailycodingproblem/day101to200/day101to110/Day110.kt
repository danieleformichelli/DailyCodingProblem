package com.formichelli.dailycodingproblem.day101to200.day101to110

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given a binary tree, return all paths from the root to leaves.

For example, given the tree

   1
  / \
 2   3
    / \
   4   5
it should return [[1, 2], [1, 3, 4], [1, 3, 5]].
*/
object Day110 {
    fun <T> solution(root: TreeNode<T>): List<List<T>> {
        val pathsList = mutableListOf<MutableList<T>>(mutableListOf())
        solutionHelper(root, pathsList)
        return pathsList
    }

    private fun <T> solutionHelper(node: TreeNode<T>, pathsList: MutableList<MutableList<T>>) {
        pathsList.forEach { it.add(node.value) }
        if (node.left != null && node.right != null) {
            val copiedList = mutableListOf<MutableList<T>>()
            pathsList.forEach { copiedList.add(it.toMutableList()) }
            solutionHelper(node.left!!, pathsList)
            solutionHelper(node.right!!, copiedList)
            pathsList.addAll(copiedList)
        } else if (node.left != null) {
            solutionHelper(node.left!!, pathsList)
        } else if (node.right != null) {
            solutionHelper(node.right!!, pathsList)
        }
    }
}