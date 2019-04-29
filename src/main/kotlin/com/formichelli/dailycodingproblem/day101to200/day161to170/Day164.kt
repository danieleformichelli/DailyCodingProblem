package com.formichelli.dailycodingproblem.day101to200.day161to170

/*
You are given an array of length n + 1 whose elements belong to the set {1, 2, ..., n}. By the pigeonhole principle, there must be a duplicate. Find it in linear time and space.
*/
object Day164 {
    fun solution(numbers: List<Int>): Int {
        val found = BooleanArray(numbers.size)
        numbers.forEach {
            if (found[it]) {
                return it
            }
            found[it] = true
        }

        throw IllegalArgumentException("No duplicates found")
    }
}