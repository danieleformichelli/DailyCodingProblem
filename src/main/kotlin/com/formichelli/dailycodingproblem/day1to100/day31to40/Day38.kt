package com.formichelli.dailycodingproblem.day1to100.day31to40

/*
You have an N by N board. Write a function that, given N, returns the number of possible arrangements of the board where N queens can be placed on the board without threatening each other, i.e. no two queens share the same row, column, or diagonal.
*/
object Day38 {
    fun solution(N: Int): Int {
        return solutionHelper(Array(N) { IntArray(N) }, 0)
    }

    private fun solutionHelper(board: Array<IntArray>, currentRow: Int): Int {
        if (currentRow == board.size) {
            return 1
        }

        var solutionCount = 0

        for (currentColumn in 0 until board[currentRow].size) {
            if (board[currentRow][currentColumn] == 0) {
                putOrRemoveQueen(board, currentRow, currentColumn, true)
                solutionCount += solutionHelper(board, currentRow + 1)
                putOrRemoveQueen(board, currentRow, currentColumn, false)
            }
        }

        return solutionCount
    }

    private fun putOrRemoveQueen(board: Array<IntArray>, currentRow: Int, currentColumn: Int, putOrRemove: Boolean) {
        val increment = if (putOrRemove) 1 else -1
        board[currentRow][currentColumn] = if (putOrRemove) 1 else 0
        for (i in currentRow + 1 until board.size) {
            // occupy vertical line
            board[i][currentColumn] += increment
        }
        for (i in 1 until Math.min(board.size - currentRow, board[currentRow].size - currentColumn)) {
            // occupy down-right diagonal
            board[currentRow + i][currentColumn + i] += increment
        }
        for (i in 1 until Math.min(board.size - currentRow, currentColumn + 1)) {
            // occupy down-left diagonal
            board[currentRow + i][currentColumn - i] += increment
        }
    }
}
