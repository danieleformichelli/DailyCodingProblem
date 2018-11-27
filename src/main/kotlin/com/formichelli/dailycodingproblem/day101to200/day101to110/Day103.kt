package com.formichelli.dailycodingproblem.day101to200.day101to110

/*
Given a string and a set of characters, return the shortest substring containing all the characters in the set.

For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".

If there is no substring containing all the characters in the set, return null.
*/
object Day103 {
    fun solution(string: String, characters: Set<Char>): String? {
        var startIndex = -1
        val charCount = HashMap<Char, Int>()

        var shortestString: String? = null
        for (i in 0 until string.length) {
            val charAtIndex = string[i]
            if (characters.contains(charAtIndex)) {
                charCount[charAtIndex] = charCount.getOrDefault(charAtIndex, 0) + 1

                if (startIndex == -1) {
                    startIndex = i
                } else {
                    // we have found another instance of a character, shorten the string from the beginning as much as possible possible
                    var charAtStartIndex = string[startIndex]
                    while (true) {
                        if (characters.contains(charAtStartIndex)) {
                            val charAtStartIndexCount = charCount[charAtStartIndex]!!
                            if (charAtStartIndexCount > 1) {
                                // if it is a char of the charset and we have more than one occurrence in the current substring, we can discard the first instance
                                charCount[charAtStartIndex] = charAtStartIndexCount - 1
                            } else {
                                // if it is a char of the charset and we have only one occurrence, we cannot discard it
                                break
                            }
                        }

                        // if it is not a char of the charset, we can discard it

                        ++startIndex
                        charAtStartIndex = string[startIndex]
                    }
                }
            }

            if (characters.all { charCount[it] ?: 0 > 0 }) {
                // all the characters of the charset appear at least once
                if (shortestString == null || shortestString.length > i + 1 - startIndex) {
                    shortestString = string.substring(startIndex, i + 1)
                }
            }
        }

        return shortestString
    }
}