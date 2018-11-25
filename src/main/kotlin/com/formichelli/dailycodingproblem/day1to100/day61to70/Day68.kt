package com.formichelli.dailycodingproblem.day1to100.day61to70

/*
On our special chessboard, two bishops attack each other if they share the same diagonal. This includes bishops that have another bishop located between them, i.e. bishops can attack through pieces.

You are given N bishops, represented as (row, column) tuples on a M by M chessboard. Write a function to count the number of pairs of bishops that attack each other. The ordering of the pair doesn't matter: (1, 2) is considered the same as (2, 1).

For example, given M = 5 and the list of bishops:

(0, 0)
(1, 2)
(2, 2)
(4, 0)
The board would look like this:

[b 0 0 0 0]
[0 0 b 0 0]
[0 0 b 0 0]
[0 0 0 0 0]
[b 0 0 0 0]
You should return 2, since bishops 1 and 3 attack each other, as well as bishops 3 and 4.
*/
object Day68 {
    fun solution(M: Int, bishops: List<Pair<Int, Int>>): Int {
        val chessBoard = Array(M) { BooleanArray(M) }
        bishops.forEach {
            chessBoard[it.first][it.second] = true
        }
        var attackableBishopsPairsCount = 0

        for (i in 0 until M) {
            attackableBishopsPairsCount += countToAttackablePairsCount(countOnRightDiagonal(chessBoard, i, 0))
            attackableBishopsPairsCount += countToAttackablePairsCount(countOnRightDiagonal(chessBoard, 0, i))
            attackableBishopsPairsCount += countToAttackablePairsCount(countOnLeftDiagonal(chessBoard, i, 0))
            attackableBishopsPairsCount += countToAttackablePairsCount(countOnLeftDiagonal(chessBoard, M - 1, i))
        }

        return attackableBishopsPairsCount
    }

    // if there are N bishops on a diagonal, there are (N-1) + (N-2) + ... + 1 pairs that can attack each other
    private fun countToAttackablePairsCount(countOnRightDiagonal: Int) = countOnRightDiagonal * (countOnRightDiagonal - 1) / 2

    private fun countOnLeftDiagonal(chessBoard: Array<BooleanArray>, row: Int, column: Int): Int {
        return countOnDiagonal(chessBoard, row, column, 1, -1)
    }

    private fun countOnRightDiagonal(chessBoard: Array<BooleanArray>, row: Int, column: Int): Int {
        return countOnDiagonal(chessBoard, row, column, 1, 1)
    }

    private fun countOnDiagonal(chessBoard: Array<BooleanArray>, row: Int, column: Int, rowDirection: Int, columnDirection: Int): Int {
        var rowIndex = row
        var colIndex = column
        var bishopsCount = 0

        while (rowIndex in 0 until chessBoard.size && colIndex in 0 until chessBoard.size) {
            if (chessBoard[rowIndex][colIndex]) {
                ++bishopsCount
            }

            rowIndex += rowDirection
            colIndex += columnDirection
        }

        return bishopsCount
    }
}
