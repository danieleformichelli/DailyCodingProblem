package com.formichelli.dailycodingproblem.day1to100.day91to100

import java.util.*

/*
Given a number represented by a list of digits, find the next greater permutation of a number, in terms of lexicographic ordering. If there is not greater permutation possible, return the permutation with the lowest value/ordering.

For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should return [2,1,3]. The list [3,2,1] should return [1,2,3].

Can you perform the operation without allocating extra memory (disregarding the input memory)?
*/
object Day95 {
    fun solution(number: List<Int>): List<Int> {
        val nextGreaterPermutation = number.toIntArray()
        for (outerIndex in number.lastIndex downTo 0) {
            for (innerIndex in outerIndex - 1 downTo 0) {
                if (number[outerIndex] > number[innerIndex]) {
                    // first digit of next greater permutation found
                    nextGreaterPermutation[outerIndex] = number[innerIndex]
                    nextGreaterPermutation[innerIndex] = number[outerIndex]

                    // order the digits on the right to get the smallest permutation
                    Arrays.sort(nextGreaterPermutation, innerIndex + 1, number.size)
                    return nextGreaterPermutation.toList()
                }
            }
        }

        // no greater permutation found
        nextGreaterPermutation.sort()
        return nextGreaterPermutation.toList()
    }
}