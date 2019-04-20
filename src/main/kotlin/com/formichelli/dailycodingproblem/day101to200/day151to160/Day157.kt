package com.formichelli.dailycodingproblem.day101to200.day151to160

/*
Given a string, determine whether any permutation of it is a palindrome.

For example, carrace should return true, since it can be rearranged to form racecar, which is a palindrome. daily should return false, since there's no rearrangement that can form a palindrome.
*/
object Day157 {
    fun solution(string: String): Boolean {
        val oddChars = HashSet<Char>()
        string.forEach {
            if (oddChars.contains(it)) {
                oddChars.remove(it)
            } else {
                oddChars.add(it)
            }
        }

        return oddChars.size < 2
    }
}