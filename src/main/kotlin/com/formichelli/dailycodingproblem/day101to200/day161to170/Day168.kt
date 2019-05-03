package com.formichelli.dailycodingproblem.day101to200.day161to170

/*
Given an N by N matrix, rotate it by 90 degrees clockwise.

For example, given the following matrix:

[[1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]]
you should return:

[[7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]]
Follow-up: What if you couldn't use any extra space?
*/
object Day168 {
    fun <T> solution(matrix: Array<Array<T>>): Array<Array<T>> {
        for (i in 0 until matrix.size / 2) {
            // rotate layer by layer starting from external one
            for (j in i until matrix.lastIndex - i) {
                val topLeft = Pair(i, j)
                val topRight = Pair(j, matrix.lastIndex - i)
                val bottomRight = Pair(matrix.lastIndex - i, matrix.lastIndex - j)
                val bottomLeft = Pair(matrix.lastIndex - j, i)

                val tmp = matrix[topLeft.first][topLeft.second]
                matrix[topLeft.first][topLeft.second] = matrix[bottomLeft.first][bottomLeft.second]
                matrix[bottomLeft.first][bottomLeft.second] = matrix[bottomRight.first][bottomRight.second]
                matrix[bottomRight.first][bottomRight.second] = matrix[topRight.first][topRight.second]
                matrix[topRight.first][topRight.second] = tmp
            }
        }

        return matrix
    }
}