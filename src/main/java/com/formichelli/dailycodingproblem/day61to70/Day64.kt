package com.formichelli.dailycodingproblem.day61to70

/*
A knight's tour is a sequence of moves by a knight on a chessboard such that all squares are visited once.

Given N, write a function to return the number of knight's tours on an N by N chessboard.
*/
object Day64 {
    private val knightMoves = arrayOf(
            Pair(-2, 1),
            Pair(-1, 2),
            Pair(1, 2),
            Pair(2, 1),
            Pair(2, -1),
            Pair(1, -2),
            Pair(-1, -2),
            Pair(-2, -1)
    )

    fun solution(N: Int): Int {
        val chessBoard = Array(N) { IntArray(N) }
        val midColumnIndex = Math.ceil(N / 2.0).toInt() - 1
        val counts = Array(midColumnIndex + 1) { IntArray(midColumnIndex + 1) }
        /*
        Only these start points needs to be calculated, the other ones are the same due to symmetry
        + - - - - - +
        | * * *     |
        |   * *     |
        |     *     |
        |           |
        |           |
        + - - - - - +
         */
        for (row in 0..midColumnIndex) {
            for (column in row..midColumnIndex) {
                counts[row][column] = solutionHelper(chessBoard, row, column, 0)
                counts[column][row] = counts[row][column]
            }
        }

        // the other 4 squares have the same counts due to simmetry
        var toursCount = 4 * counts.map { it.sum() }.sum()
        return if (N % 2 == 0) {
            toursCount
        } else {
            // subtracts cells in common among the squares
            for (i in 0..midColumnIndex) {
                // items on the borders should be counted twice instead of four times
                toursCount -= counts[i][midColumnIndex] * 2
                toursCount -= counts[midColumnIndex][i] * 2
            }
            // item in the middle should be counted only once
            toursCount + counts[midColumnIndex][midColumnIndex]
        }
    }

    private fun solutionHelper(visitedAtStep: Array<IntArray>, currentRow: Int, currentColumn: Int, visitedCellsCount: Int): Int {
        if (currentRow !in 0 until visitedAtStep.size || currentColumn !in 0 until visitedAtStep[currentRow].size || visitedAtStep[currentRow][currentColumn] != 0) {
            return 0
        }
        val newVisitedCellsCount = visitedCellsCount + 1
        visitedAtStep[currentRow][currentColumn] = newVisitedCellsCount
        val toursCount = if (newVisitedCellsCount == visitedAtStep.size * visitedAtStep.size) {
            1
        } else {
            knightMoves.map {
                solutionHelper(visitedAtStep, currentRow + it.first, currentColumn + it.second, newVisitedCellsCount)
            }.sum()
        }
        visitedAtStep[currentRow][currentColumn] = 0

        return toursCount
    }
}
