package com.formichelli.dailycodingproblem

/*
Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

Follow-up: Can you do this in O(N) time and constant space?
*/
object Day9 {
    fun solution(numbers: IntArray): Int {
        var max = 0

        numbers.forEachIndexed { i, number ->
            if (number > 0) {
                val shouldFlipPrevious = i > 0 && numbers[i - 1] > 0
                val shouldFlipFollowing = i < numbers.size - 1 && numbers[i + 1] > 0

                flipAdjacents(numbers, i, shouldFlipPrevious, shouldFlipFollowing)

                val maxChoosingNumber = number + solution(numbers)
                if (maxChoosingNumber > max) {
                    max = maxChoosingNumber
                }

                flipAdjacents(numbers, i, shouldFlipPrevious, shouldFlipFollowing)
            }
        }

        return max
    }

    private fun flipAdjacents(numbers: IntArray, index: Int, shouldFlipPrevious: Boolean, shouldFlipFollowing: Boolean) {
        if (shouldFlipPrevious) {
            numbers[index - 1] = -numbers[index - 1]
        }
        numbers[index] = -numbers[index]
        if (shouldFlipFollowing) {
            numbers[index + 1] = -numbers[index + 1]
        }
    }
}
