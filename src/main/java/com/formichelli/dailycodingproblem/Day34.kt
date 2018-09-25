package com.formichelli.dailycodingproblem

/*
Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word. If there is more than one palindrome of minimum length that can be made, return the lexicographically earliest one (the first one alphabetically).

For example, given the string "race", you should return "ecarace", since we can add three letters to it (which is the smallest amount to make a palindrome). There are seven other palindromes that can be made from "race" by adding three letters, but "ecarace" comes first alphabetically.

As another example, given the string "google", you should return "elgoogle".
*/
object Day34 {
    fun solution(string: String): String {
        return solutionHelper(string, 0, string.length - 1)
    }

    private fun solutionHelper(string: String, fromIndex: Int, toIndex: Int): String = when {
        toIndex < fromIndex -> ""
        toIndex == fromIndex -> string[toIndex].toString()
        string[fromIndex] == string[toIndex] -> string[fromIndex] + solutionHelper(string, fromIndex + 1, toIndex - 1) + string[toIndex]
        else -> {
            val palindromeFromLeft = string[toIndex] + solutionHelper(string, fromIndex, toIndex - 1) + string[toIndex]
            val palindromeFromRight = string[fromIndex] + solutionHelper(string, fromIndex + 1, toIndex) + string[fromIndex]

            if (palindromeFromLeft.length < palindromeFromRight.length) {
                palindromeFromLeft
            } else if (palindromeFromRight.length < palindromeFromLeft.length) {
                palindromeFromRight
            } else {
                if (palindromeFromLeft < palindromeFromRight) palindromeFromLeft else palindromeFromRight
            }
        }
    }
}