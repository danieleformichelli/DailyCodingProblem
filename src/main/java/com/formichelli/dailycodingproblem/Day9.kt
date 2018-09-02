package com.formichelli.dailycodingproblem

/*
Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
*/
object Day9 {
    fun solution(numbers: IntArray): Int {
        return maxOfNonAdjacent(numbers, 0, 0)
    }

    private fun maxOfNonAdjacent(numbers: IntArray, i: Int, currentSum: Int): Int {
        if (i == numbers.size)
            return currentSum

        val number = numbers[i]
        val shouldFlipFollowing = i < numbers.size - 1 && numbers[i + 1] > 0
        if (shouldFlipFollowing) {
            numbers[i + 1] = -numbers[i + 1]
        }
        val maxIncludingNumber = if (number > 0) maxOfNonAdjacent(numbers, i + 1, currentSum + number) else 0
        if (shouldFlipFollowing) {
            numbers[i + 1] = -numbers[i + 1]
        }

        val maxExcludingNumber = maxOfNonAdjacent(numbers, i + 1, currentSum)

        return Math.max(maxIncludingNumber, maxExcludingNumber)
    }
}
