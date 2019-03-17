package com.formichelli.dailycodingproblem.day101to200.day111to120

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
*/
object Day115 {
    fun <T> solution(s: TreeNode<T>?, t: TreeNode<T>?): Boolean {
        if (s == null) {
            return false
        }

        return isSameStructureAndValue(s, t) || solution(s.left, t) || solution(s.right, t)
    }

    private fun <T> isSameStructureAndValue(s: TreeNode<T>?, t: TreeNode<T>?): Boolean {
        return when {
            s != null && t != null -> s.value == t.value && isSameStructureAndValue(s.left, t.left) && isSameStructureAndValue(s.right, t.right)
            s == null && t == null -> true
            else -> false
        }
    }
}