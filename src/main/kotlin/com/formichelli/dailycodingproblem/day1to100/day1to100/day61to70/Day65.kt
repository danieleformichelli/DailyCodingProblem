package com.formichelli.dailycodingproblem.day1to100.day1to100.day61to70

/*
Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.

For example, given the following matrix:

[[1,  2,  3,  4,  5],
 [6,  7,  8,  9,  10],
 [11, 12, 13, 14, 15],
 [16, 17, 18, 19, 20]]
You should print out the following:

1
2
3
4
5
10
15
20
19
18
17
16
11
6
7
8
9
14
13
12
*/
object Day65 {
    fun solution(matrix: Array<IntArray>): List<Int> {
        val returnList = mutableListOf<Int>(matrix[0][0])
        var currentRow = 0
        var currentColumn = 0
        val numberOfTurnsToComplete = Math.min(matrix.size, matrix[currentRow].size) * 2
        for (turns in 0 until numberOfTurnsToComplete) {
            val lapCounts = (turns + 1) / 4
            when (turns % 4) {
                0 -> {
                    // move right
                    while (currentColumn < matrix[currentRow].size - lapCounts - 1) {
                        returnList.add(matrix[currentRow][++currentColumn])
                    }
                }
                1 -> {
                    // move down
                    while (currentRow < matrix.size - lapCounts - 1) {
                        returnList.add(matrix[++currentRow][currentColumn])
                    }
                }
                2 -> {
                    // move left
                    while (currentColumn > lapCounts) {
                        returnList.add(matrix[currentRow][--currentColumn])
                    }
                }
                3 -> {
                    // move up
                    while (currentRow > lapCounts) {
                        returnList.add(matrix[--currentRow][currentColumn])
                    }
                }
            }
        }

        return returnList
    }
}
