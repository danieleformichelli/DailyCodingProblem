package com.formichelli.dailycodingproblem.day1to100.day41to50

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

Given the root to such a tree, write a function to evaluate it.

For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5
You should return 45, as it is (3 + 2) * (4 + 5).
*/
object Day50 {
    fun solution(expression: TreeNode<Char>): Int {
        return when (expression.value) {
            '+' -> solution(expression.left!!) + solution(expression.right!!)
            '-' -> solution(expression.left!!) - solution(expression.right!!)
            '*' -> solution(expression.left!!) * solution(expression.right!!)
            '/' -> solution(expression.left!!) / solution(expression.right!!)
            else -> expression.value - '0'
        }
    }
}
