package com.formichelli.dailycodingproblem.day101to200.day141to150

/*
Given an array of numbers and an index i, return the index of the nearest larger number of the number at index i, where distance is measured in array indices.

For example, given [4, 1, 3, 5, 6] and index 0, you should return 3.

If two distances to larger numbers are the equal, then return any one of them. If the array at i doesn't have a nearest larger integer, then return null.

Follow-up: If you can preprocess the array, can you do this in constant time?
*/
object Day144 {
    fun solution(numbers: IntArray, i: Int): Int? {
        val resultArray = preprocess(numbers)
        return resultArray[i]
    }

    private fun preprocess(numbers: IntArray): Array<Int?> {
        val result = Array<Int?>(numbers.size) { null }
        for (i in 0 until numbers.size) {
            result[i] = findNearestBigger(numbers, i)
        }

        return result
    }

    private fun findNearestBigger(numbers: IntArray, i: Int): Int? {
        var j = 1
        do {
            val lowerIndex = i - j
            val upperIndex = i + j
            if (lowerIndex >= 0 && numbers[lowerIndex] > numbers[i]) {
                return lowerIndex
            } else if (upperIndex < numbers.size && numbers[upperIndex] > numbers[i]) {
                return upperIndex
            }

            ++j
        } while (lowerIndex >= 0 || upperIndex < numbers.size)

        return null
    }
}