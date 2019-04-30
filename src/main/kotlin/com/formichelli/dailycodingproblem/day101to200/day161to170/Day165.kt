package com.formichelli.dailycodingproblem.day101to200.day161to170

/*
Given an array of integers, return a new array where each element in the new array is the number of smaller elements to the right of that element in the original input array.

For example, given the array [3, 4, 9, 6, 1], return [1, 1, 2, 1, 0], since:
There is 1 smaller element to the right of 3
There is 1 smaller element to the right of 4
There are 2 smaller elements to the right of 9
There is 1 smaller element to the right of 6
There are no smaller elements to the right of 1
*/
object Day165 {
    fun solution(numbers: IntArray): IntArray {
        val result = IntArray(numbers.size)
        val numbersFromRight = ArrayList<Int>()
        numbersFromRight.add(numbers.last())
        for (i in numbers.lastIndex - 1 downTo 0) {
            val number = numbers[i]
            // assuming no duplicates
            val insertionIndex = -numbersFromRight.binarySearch(number) - 1
            numbersFromRight.add(insertionIndex, number)
            result[i] = insertionIndex
        }

        return result
    }
}