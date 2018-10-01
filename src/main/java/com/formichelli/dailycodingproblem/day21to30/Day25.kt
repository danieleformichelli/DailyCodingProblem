package com.formichelli.dailycodingproblem.day21to30

/*
Implement regular expression matching with the following special characters:

. (period) which matches any single character
* (asterisk) which matches zero or more of the preceding element
That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.

For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.

Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.
*/
object Day25 {
    fun solution(regex: String, string: String): Boolean {
        return solutionHelper(regex, 0, string, 0)
    }

    private fun solutionHelper(regex: String, regexIndex: Int, string: String, stringIndex: Int): Boolean {
        return if (stringIndex == string.length) {
            if (regexIndex == regex.length) {
                // it is a match if end of string and regex reached together
                true
            } else {
                if (regex[regexIndex] == '*') {
                    // it is a match if end of string and all the remainin regex is asterisks
                    solutionHelper(regex, regexIndex + 1, string, stringIndex)
                } else {
                    false
                }
            }
        } else if (regexIndex == regex.length) {
            false
        } else when (regex[regexIndex]) {
            '.' -> solutionHelper(regex, regexIndex + 1, string, stringIndex + 1)
            string[stringIndex] -> solutionHelper(regex, regexIndex + 1, string, stringIndex + 1)
            '*' -> solutionHelper(regex, regexIndex + 1, string, stringIndex + 1) || solutionHelper(regex, regexIndex, string, stringIndex + 1) || solutionHelper(regex, regexIndex + 1, string, stringIndex)
            else -> false
        }
    }
}
