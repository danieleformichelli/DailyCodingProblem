package com.formichelli.dailycodingproblem.day101to200.day131to140

import java.util.*

/*
Given an N by M matrix consisting only of 1's and 0's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

[[1, 0, 0, 0],
 [1, 0, 1, 1],
 [1, 0, 1, 1],
 [0, 1, 0, 0]]
Return 4.
*/
object Day136 {
    fun solution(matrix: Array<IntArray>): Int {
        val histogram = IntArray(matrix[0].size)

        var maxOnesSize = 0
        for (r in 0 until matrix.size) {
            for (c in 0 until matrix[r].size) {
                if (matrix[r][c] != 0) {
                    histogram[c] += 1
                } else {
                    histogram[c] = 0
                }
            }

            maxOnesSize = Math.max(maxOnesSize, maxHistogram(histogram))
        }

        return maxOnesSize
    }

    private fun maxHistogram(histogram: IntArray): Int {
        val stack = Stack<Int>()
        var maxArea = 0

        var i = 0
        while (i < histogram.size || !stack.empty()) {
            if (i < histogram.size && (stack.empty() || histogram[stack.peek()] <= histogram[i])) {
                // find local maximum
                stack.push(i++)
            } else {
                val localMax = stack.pop()
                val maxHistValue = histogram[localMax]
                // at given index we calculate the area as the sum from the local max to the number of columns with sum greater than or equal to it
                val currentArea = if (stack.empty()) {
                    maxHistValue * i
                } else {
                    maxHistValue * (i - stack.peek() - 1)
                }

                maxArea = Math.max(maxArea, currentArea)
            }
        }

        return maxArea
    }
}