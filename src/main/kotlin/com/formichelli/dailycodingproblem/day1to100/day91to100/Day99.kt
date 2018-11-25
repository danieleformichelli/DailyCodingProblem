package com.formichelli.dailycodingproblem.day1to100.day91to100

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
object Day99 {
    fun solution(numbers: IntArray): Int {
        val forwardConsecutiveSequenceLength = HashMap<Int, Int>()
        val backwardConsecutiveSequenceLength = HashMap<Int, Int>()

        var longestConsecutiveSequenceLength = 0
        for (number in numbers) {
            if (forwardConsecutiveSequenceLength[number] != null) {
                // already processed
                continue
            }

            // check if we are near to a sequence
            val forwardConsecutiveSequenceLengthFromNumberPlusOne = forwardConsecutiveSequenceLength.getOrDefault(number + 1, 0)
            val backwardConsecutiveSequenceLengthFromNumberPlusOne = backwardConsecutiveSequenceLength.getOrDefault(number - 1, 0)

            forwardConsecutiveSequenceLength[number] = forwardConsecutiveSequenceLengthFromNumberPlusOne + 1
            backwardConsecutiveSequenceLength[number] = backwardConsecutiveSequenceLengthFromNumberPlusOne + 1

            val consecutiveSequenceLength = forwardConsecutiveSequenceLengthFromNumberPlusOne + backwardConsecutiveSequenceLengthFromNumberPlusOne + 1
            forwardConsecutiveSequenceLength[number + forwardConsecutiveSequenceLengthFromNumberPlusOne] = consecutiveSequenceLength
            backwardConsecutiveSequenceLength[number - forwardConsecutiveSequenceLengthFromNumberPlusOne] = consecutiveSequenceLength

            longestConsecutiveSequenceLength = Math.max(longestConsecutiveSequenceLength, consecutiveSequenceLength)
        }

        return longestConsecutiveSequenceLength
    }
}