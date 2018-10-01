package com.formichelli.dailycodingproblem.day_1_10

/*
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
*/
object Day2 {
    fun solution(numbers: IntArray): IntArray {
        val totalProduct = numbers.reduce { first, second -> first * second }
        return numbers.map { totalProduct / it }.toIntArray()
    }

    fun solutionWithoutDivision(numbers: IntArray): IntArray {
        val ret = IntArray(numbers.size)

        var productOfNumberBelowI = 1
        for (i in 0 until numbers.size) {
            ret[i] = productOfNumberBelowI
            productOfNumberBelowI *= numbers[i]
        }

        var productOfNumberAboveI = 1
        for (i in numbers.size - 1 downTo 0) {
            ret[i] *= productOfNumberAboveI
            productOfNumberAboveI *= numbers[i]
        }

        return ret
    }
}
