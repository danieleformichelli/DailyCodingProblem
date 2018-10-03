package com.formichelli.dailycodingproblem.day41to50

/*
Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
*/
object Day49 {
    fun solution(numbers: IntArray): Int {
        val maxSumFromIndex = IntArray(numbers.size)
        maxSumFromIndex[numbers.size - 1] = if (numbers[numbers.size - 1] > 0) numbers[numbers.size - 1] else 0

        // O(N)
        for (i in numbers.size - 2 downTo 0) {
            // O(1)
            maxSumFromIndex[i] = if (maxSumFromIndex[i + 1] + numbers[i] > 0) {
                maxSumFromIndex[i + 1] + numbers[i]
            } else {
                0
            }
        }

        return maxSumFromIndex.max()!!
    }
}
