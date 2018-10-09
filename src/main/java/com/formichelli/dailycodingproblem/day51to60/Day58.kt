package com.formichelli.dailycodingproblem.day51to60

/*
An sorted array of integers was rotated an unknown number of times.

Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.

For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

You can assume all the integers in the array are unique.
*/
object Day58 {
    fun solution(numbers: IntArray, element: Int): Int {
        return solutionHelper(numbers, element, 0, numbers.size - 1)
    }

    private fun solutionHelper(numbers: IntArray, element: Int, fromIndex: Int, toIndex: Int): Int {
        if (fromIndex > toIndex) {
            return -1
        }

        val middleElementIndex = (toIndex + fromIndex) / 2
        val firstElement = numbers[fromIndex]
        val middleElement = numbers[middleElementIndex]
        val lastElement = numbers[toIndex]
        return when {
            element == firstElement -> fromIndex
            element == middleElement -> middleElementIndex
            element == lastElement -> toIndex
            element in (firstElement + 1)..(middleElement - 1) -> {
                // element is between firstElement and middleElement
                solutionHelper(numbers, element, fromIndex + 1, middleElementIndex - 1)
            }
            element in (middleElement + 1)..(lastElement - 1) -> {
                // element is between firstElement and middleElement
                solutionHelper(numbers, element, middleElementIndex + 1, toIndex - 1)
            }
            else -> {
                // can be in both halves
                var index = solutionHelper(numbers, element, fromIndex + 1, middleElementIndex - 1)
                if (index == -1) {
                    index = solutionHelper(numbers, element, middleElementIndex + 1, toIndex - 1)
                }

                return index

            }
        }
    }
}
