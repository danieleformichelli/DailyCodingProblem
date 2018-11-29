package com.formichelli.dailycodingproblem.day101to200.day101to110

import com.formichelli.dailycodingproblem.util.TreeNode
import java.util.*

/*
Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.

  1
 / \
2   3
   / \
  4   5
*/
object Day107 {
    fun solution(root: TreeNode<Int>): List<Int> {
        return solutionHelper(mutableListOf(root)).map { it.value }.toList()
    }

    private fun solutionHelper(nodesAtLevel: MutableList<TreeNode<Int>>): List<TreeNode<Int>> {
        if (nodesAtLevel.isEmpty()) {
            return Collections.emptyList()
        }

        val nodesAtNextLevel = ArrayList<TreeNode<Int>>()
        nodesAtLevel.forEach {
            if (it.left != null)
                nodesAtNextLevel.add(it.left!!)
            if (it.right != null)
                nodesAtNextLevel.add(it.right!!)
        }

        nodesAtLevel.addAll(solutionHelper(nodesAtNextLevel))
        return nodesAtLevel
    }
}