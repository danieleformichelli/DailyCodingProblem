package com.formichelli.dailycodingproblem.day1to100.day1to100.day81to90

/*
Given a matrix of 1s and 0s, return the number of "islands" in the matrix. A 1 represents land and 0 represents water, so an island is a group of 1s that are neighboring and their perimiter is surrounded by water.

For example, this matrix has 4 islands.

1 0 0 0 0
0 0 1 1 0
0 1 1 0 0
0 0 0 0 0
1 1 0 0 1
1 1 0 0 1
*/
object Day84 {
    fun solution(matrix: Array<BooleanArray>): Int {
        val islands = Array(matrix.size) { BooleanArray(matrix[0].size) }

        var islandCount = 0
        for (row in 0 until matrix.size) {
            for (col in 0 until matrix[row].size) {
                if (matrix[row][col] && !islands[row][col]) {
                    // we are on land and it has not been marked as island yet
                    ++islandCount

                    // mark the island so that it is not counted again
                    markIsland(matrix, islands, row, col)
                }
            }
        }

        return islandCount
    }

    private fun markIsland(matrix: Array<BooleanArray>, islands: Array<BooleanArray>, row: Int, col: Int) {
        if (row in 0 until matrix.size && col in 0 until matrix[row].size && matrix[row][col]) {
            islands[row][col] = true

            // clear rest of island
            markIsland(matrix, islands, row, col + 1)
            markIsland(matrix, islands, row + 1, col - 1)
            markIsland(matrix, islands, row + 1, col)
            markIsland(matrix, islands, row + 1, col + 1)
        }
    }
}