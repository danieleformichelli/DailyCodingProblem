package com.formichelli.dailycodingproblem.day101to200.day111to120

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given a binary tree, return the level of the tree with minimum sum.
*/
object Day117 {
    fun solution(root: TreeNode<Int>): Int {
        var currentLevel = ArrayList<TreeNode<Int>>()
        var currentLevelIndex = 0
        var minimumSum = Integer.MAX_VALUE
        var minimumSumLevelIndex = -1
        currentLevel.add(root)
        while (!currentLevel.isEmpty()) {
            val levelSum = currentLevel.sumBy { it.value }
            if (levelSum < minimumSum) {
                minimumSum = levelSum
                minimumSumLevelIndex = currentLevelIndex
            }

            currentLevel = getNextLevel(currentLevel)
            ++currentLevelIndex
        }

        return minimumSumLevelIndex
    }

    private fun getNextLevel(currentLevel: ArrayList<TreeNode<Int>>): ArrayList<TreeNode<Int>> {
        val nextLevel = ArrayList<TreeNode<Int>>()
        currentLevel.forEach {
            if (it.left != null) {
                nextLevel.add(it.left!!)
            }
            if (it.right != null) {
                nextLevel.add(it.right!!)
            }
        }

        return nextLevel
    }
}