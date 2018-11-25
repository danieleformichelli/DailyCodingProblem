package com.formichelli.dailycodingproblem.day1to100.day1to100.day91to100

/*
Given a number in the form of a list of digits, return all possible permutations.

For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].
*/
object Day96 {
    fun solution(number: List<Int>): Set<List<Int>> {
        val permutations = HashSet<List<Int>>()
        solutionHelper(number, BooleanArray(number.size), ArrayList(), permutations)
        return permutations
    }

    private fun solutionHelper(number: List<Int>, used: BooleanArray, currentPermutation: MutableList<Int>, permutations: MutableSet<List<Int>>) {
        if (currentPermutation.size == number.size) {
            permutations.add(currentPermutation.toList())
            return
        }

        number.forEachIndexed { index, digit ->
            if (!used[index]) {
                used[index] = true
                currentPermutation.add(digit)
                solutionHelper(number, used, currentPermutation, permutations)
                currentPermutation.removeAt(currentPermutation.lastIndex)
                used[index] = false
            }
        }
    }
}