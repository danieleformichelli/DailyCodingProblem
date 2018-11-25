package com.formichelli.dailycodingproblem.day1to100.day41to50

/*
We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.

Given an array, count the number of inversions it has. Do this faster than O(N^2) time.

You may assume each element in the array is distinct.

For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
*/
object Day44 {
    fun solution(numbers: IntArray): Int {
        return sortAndCount(numbers, 0, numbers.size - 1)
    }

    private fun sortAndCount(numbers: IntArray, from: Int, to: Int): Int {
        if (from == to) {
            return 0
        }

        val middleElement = from + (to - from) / 2
        val countLeft = sortAndCount(numbers, from, middleElement)
        val countRight = sortAndCount(numbers, middleElement + 1, to)
        val mergeCount = mergeAndCount(numbers, from, to)
        return countLeft + countRight + mergeCount
    }

    private fun mergeAndCount(numbers: IntArray, from: Int, to: Int): Int {
        val merged = IntArray(to - from + 1)
        var leftIndex = from
        val middleElement = from + (to - from) / 2
        var rightIndex = middleElement + 1
        var inversionsCount = 0
        for (i in 0 until merged.size) {
            merged[i] = when {
                rightIndex > to -> {
                    numbers[leftIndex++]
                }
                leftIndex > middleElement -> {
                    numbers[rightIndex++]
                }
                numbers[leftIndex] < numbers[rightIndex] -> numbers[leftIndex++]
                numbers[leftIndex] > numbers[rightIndex] -> {
                    // each element left in the left side is an inversion
                    inversionsCount += middleElement - leftIndex + 1
                    numbers[rightIndex++]
                }
                else -> {
                    throw IllegalArgumentException("Elements must be distinct")
                }
            }
        }

        System.arraycopy(merged, 0, numbers, from, merged.size)
        return inversionsCount
    }
}
