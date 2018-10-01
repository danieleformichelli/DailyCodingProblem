package com.formichelli.dailycodingproblem.day_21_30

import com.formichelli.dailycodingproblem.util.Utils

/*
You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
*/
object Day23 {
    fun solution(board: Array<BooleanArray>, start: Pair<Int, Int>, end: Pair<Int, Int>): Int {
        val (r, c) = start
        if (r == end.first && c == end.second) {
            return 0
        }
        if (isWall(board, r, c))
            return Int.MAX_VALUE

        // mark visited cells so we don't pass again from them (shortest path cannot include twice the same cell)
        board[r][c] = true

        val minFromNextStep = Utils.minOf(solution(board, Pair(r - 1, c), end), solution(board, Pair(r + 1, c), end), solution(board, Pair(r, c - 1), end), solution(board, Pair(r, c + 1), end))

        // unmark visited cells to clean up state for recursive calls
        board[r][c] = false

        return if (minFromNextStep != Int.MAX_VALUE) minFromNextStep + 1 else Int.MAX_VALUE
    }

    private fun isWall(board: Array<BooleanArray>, r: Int, c: Int) = when {
        r < 0 || c < 0 -> true
        r >= board.size || c >= board[r].size -> true
        else -> board[r][c]
    }
}
