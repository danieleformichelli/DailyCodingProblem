package com.formichelli.dailycodingproblem.day_1_10

/*
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
*/
object Day4 {
    fun solution(numbers: IntArray): Int {
        var i = 0
        while (i < numbers.size) {
            // ignore negative numbers and numbers bigger than the array size
            val number = numbers[i]
            if (number < 1 || number > numbers.size) {
                ++i
                continue
            }

            if (number != numbers[number - 1]) {
                // at each step, switch the number with the one in its own position (e.g. if you find 3, swap it with the 3rd cell)
                numbers[i] = numbers[number - 1]
                numbers[number - 1] = number
            } else {
                ++i
            }
        }

        numbers.forEachIndexed { index, number ->
            if (number != index + 1) {
                return index + 1
            }
        }

        return numbers.size
    }
}
