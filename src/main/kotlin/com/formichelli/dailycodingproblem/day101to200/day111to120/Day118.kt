package com.formichelli.dailycodingproblem.day101to200.day111to120

/*
Given a sorted list of integers, square the elements and give the output in sorted order.

For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
*/
object Day118 {
    fun solution(numbers: List<Int>): List<Int> {
        val squared = ArrayList<Int>()

        var positiveIndex = 0
        while (positiveIndex < numbers.size && numbers[positiveIndex] < 0) {
            positiveIndex++
        }
        var negativeIndex = positiveIndex - 1

        while (negativeIndex >= 0 || positiveIndex < numbers.size) {
            val nextSquaredIndex = when {
                negativeIndex < 0 -> positiveIndex++
                positiveIndex >= numbers.size -> negativeIndex--
                numbers[positiveIndex] < -numbers[negativeIndex] -> positiveIndex++
                else -> negativeIndex--
            }

            squared.add(numbers[nextSquaredIndex] * numbers[nextSquaredIndex])
        }

        return squared
    }
}