package com.formichelli.dailycodingproblem.day1to100.day1to100.day61to70

/*
Given a 2D matrix of characters and a target word, write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.

For example, given the following matrix:

[['F', 'A', 'C', 'I'],
 ['O', 'B', 'Q', 'P'],
 ['A', 'N', 'O', 'B'],
 ['M', 'A', 'S', 'S']]
and the target word 'FOAM', you should return true, since it's the leftmost column. Similarly, given the target word 'MASS', you should return true, since it's the last row.
*/
object Day63 {
    fun solution(characters: Array<CharArray>, targetWord: String): Boolean {
        for (row in 0 until characters.size) {
            for (column in 0 until characters.size) {
                if (findWordHorizontal(characters, row, column, targetWord) || findWordVertical(characters, row, column, targetWord)) {
                    return true
                }
            }
        }

        return false
    }

    private fun findWordHorizontal(characters: Array<CharArray>, row: Int, column: Int, targetWord: String): Boolean {
        if (column > characters[row].size - targetWord.length) {
            return false
        }

        for (i in 0 until targetWord.length) {
            if (characters[row][column + i] != targetWord[i]) {
                return false
            }
        }

        return true
    }

    private fun findWordVertical(characters: Array<CharArray>, row: Int, column: Int, targetWord: String): Boolean {
        if (row > characters.size - targetWord.length) {
            return false
        }

        for (i in 0 until targetWord.length) {
            if (characters[row + i][column] != targetWord[i]) {
                return false
            }
        }

        return true
    }
}
