package com.formichelli.dailycodingproblem.day41to50

/*
Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
*/
object Day42 {
    fun solution(numbers: List<Int>, k: Int): List<Int>? {
        // sort descending for early discarding
        val sortedNumbers = numbers.sortedWith(Comparator.reverseOrder<Int>())
        return solutionHelper(sortedNumbers, k, BooleanArray(numbers.size), mutableListOf(), 0)
    }

    private fun solutionHelper(numbers: List<Int>, targetSum: Int, usedNumbers: BooleanArray, currentList: MutableList<Int>, currentSum: Int): List<Int>? {
        numbers.forEachIndexed { index, number ->
            if (!usedNumbers[index]) {
                val sumUsingElement = currentSum + number
                when {
                    sumUsingElement == targetSum -> {
                        currentList.add(number)
                        return currentList
                    }
                    sumUsingElement < targetSum -> {
                        currentList.add(number)
                        usedNumbers[index] = true
                        val resultUsingElement = solutionHelper(numbers, targetSum, usedNumbers, currentList, sumUsingElement)
                        if (resultUsingElement != null) {
                            return resultUsingElement
                        } else {
                            currentList.remove(currentList.size - 1)
                            usedNumbers[index] = false
                        }
                    }
                    sumUsingElement > targetSum -> {
                        usedNumbers[index] = true
                    }
                }
            }
        }

        return null
    }
}
