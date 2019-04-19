package com.formichelli.dailycodingproblem.day101to200.day141to150

/*
Given a list, sort it using this method: reverse(lst, i, j), which reverts lst from i to j.
*/
object Day147 {
    fun solution(numbers: MutableList<Int>) {
        for (i in 0 until numbers.size) {
            for (j in i + 1 until numbers.size) {
                if (numbers[i] > numbers[j]) {
                    reverse(numbers, i, j)
                }
            }
        }
    }

    private fun reverse(numbers: MutableList<Int>, i: Int, j: Int) {
        for (k in 0 until (j - i + 1) / 2) {
            val tmp = numbers[j - k]
            numbers[j - k] = numbers[i + k]
            numbers[i + k] = tmp
        }
    }
}