package com.formichelli.dailycodingproblem.day101to200.day151to160

/*
Given a list of elements, find the majority element, which appears more than half the time (> floor(len(lst) / 2.0)).

You can assume that such element exists.

For example, given [1, 2, 1, 1, 3, 4, 0], return 1.
*/
object Day155 {
    fun <T> solution(elements: List<T>): T? {
        var candidate = elements[0]
        var candidateStart = 0
        var candidateCount = 1

        // If there is no majority element so far, we can ignore the previous part as the majority will be found later
        for (i in 1 until elements.size) {
            if (elements[i] == candidate) {
                ++candidateCount
            } else if (i - candidateStart + 1 >= 2 * candidateCount) {
                candidate = elements[i]
                candidateCount = 1
                candidateStart = i
            }
        }

        // verify that the majority element in the last part of the array is also the majority element of the whole array
        return if (elements.count { it == candidate } > elements.size / 2) {
            candidate
        } else {
            null
        }
    }
}