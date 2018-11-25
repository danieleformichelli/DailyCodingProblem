package com.formichelli.dailycodingproblem.day31to40

import com.formichelli.dailycodingproblem.util.Utils

/*
The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.
*/
object Day31 {
    fun solution(stringA: String, stringB: String): Int {
        return solutionHelper(stringA, 0, stringB, 0, stringA.length)
    }

    private fun solutionHelper(stringA: String, aIndex: Int, stringB: String, bIndex: Int, editedStringALength: Int): Int {
        return when {
            aIndex == stringA.length -> stringB.length - editedStringALength
            bIndex == stringB.length -> editedStringALength - stringB.length
            stringA[aIndex] == stringB[bIndex] -> solutionHelper(stringA, aIndex + 1, stringB, bIndex + 1, editedStringALength)
            else -> {
                val minCostWithInsertion = 1 + solutionHelper(stringA, aIndex, stringB, bIndex + 1, editedStringALength + 1)
                val minCostWithDeletion = 1 + solutionHelper(stringA, aIndex + 1, stringB, bIndex, editedStringALength - 1)
                val minCostWithSubstitution = 1 + solutionHelper(stringA, aIndex + 1, stringB, bIndex + 1, editedStringALength)
                Utils.minOf(minCostWithInsertion, minCostWithDeletion, minCostWithSubstitution)
            }
        }
    }
}
