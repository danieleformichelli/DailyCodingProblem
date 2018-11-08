package com.formichelli.dailycodingproblem.day81to90

/*
Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to make the string valid (i.e. each open parenthesis is eventually closed).

For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2, since we must remove all of them.
*/
object Day86 {
    fun solution(parentheses: String): Int {
        return solutionHelper(parentheses, 0, 0)
    }

    private fun solutionHelper(parentheses: String, index: Int, openParenthesisCount: Int): Int {
        if (index == parentheses.length) {
            return if (openParenthesisCount == 0) 0 else parentheses.length
        }

        return when (parentheses[index]) {
            '(' -> {
                val resultRemovingParenthesis = 1 + solutionHelper(parentheses, index + 1, openParenthesisCount)
                val resultKeepingParenthesis = solutionHelper(parentheses, index + 1, openParenthesisCount + 1)
                Math.min(resultRemovingParenthesis, resultKeepingParenthesis)
            }
            ')' -> {
                val resultRemovingParenthesis = 1 + solutionHelper(parentheses, index + 1, openParenthesisCount)
                val resultKeepingParenthesis = if (openParenthesisCount > 0) solutionHelper(parentheses, index + 1, openParenthesisCount - 1) else parentheses.length
                Math.min(resultRemovingParenthesis, resultKeepingParenthesis)
            }
            else -> throw IllegalArgumentException("Only ( or ) are allowed")
        }
    }
}