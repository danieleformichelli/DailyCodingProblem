package com.formichelli.dailycodingproblem.day101to200.day151to160

/*
Given a string, return the first recurring character in it, or null if there is no recurring character.

For example, given the string "acbbac", return "b". Given the string "abcdef", return null.
*/
object Day159 {
    fun solution(string: String): Char? {
        val chars = HashSet<Char>()
        string.forEach {
            if (!chars.add(it)) {
                return it
            }
        }
        return null
    }
}