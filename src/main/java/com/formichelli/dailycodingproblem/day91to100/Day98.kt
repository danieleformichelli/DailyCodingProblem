package com.formichelli.dailycodingproblem.day91to100

/*
Given a 2D board of characters and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example, given the following board:

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
exists(board, "ABCCED") returns true, exists(board, "SEE") returns true, exists(board, "ABCB") returns false.
*/
object Day98 {
    fun solution(board: Array<CharArray>, word: String): Boolean {
        val visited = Array(board.size) { BooleanArray(board[0].size) }
        for (row in 0 until board.size) {
            for (col in 0 until board[row].size) {
                val wordFound = solutionHelper(board, visited, row, col, word, 0)
                if (wordFound) {
                    return true
                }
            }
        }

        return false
    }

    private fun solutionHelper(board: Array<CharArray>, visited: Array<BooleanArray>, row: Int, col: Int, word: String, index: Int): Boolean {
        return when {
            index == word.length -> true
            row < 0 || row >= board.size -> false
            col < 0 || col >= board[row].size -> false
            visited[row][col] || board[row][col] != word[index] -> false
            else -> {
                visited[row][col] = true
                val solutionFound = solutionHelper(board, visited, row - 1, col, word, index + 1) ||
                        solutionHelper(board, visited, row + 1, col, word, index + 1) ||
                        solutionHelper(board, visited, row, col - 1, word, index + 1) ||
                        solutionHelper(board, visited, row, col + 1, word, index + 1)
                visited[row][col] = false
                solutionFound
            }
        }
    }
}