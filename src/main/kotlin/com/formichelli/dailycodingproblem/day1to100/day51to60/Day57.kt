package com.formichelli.dailycodingproblem.day1to100.day51to60

/*
Given a string s and an integer k, break up the string into multiple texts such that each text has a length of k or less. You must break it up so that words don't break across lines. If there's no way to break the text up, then return null.

You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.

For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.
*/
object Day57 {
    fun solution(inputString: String, k: Int): List<String>? {
        val returnList = mutableListOf<String>()
        var currentWordIndex = 0
        var currentLineIndex = 0
        while (true) {
            var nextSpaceIndex = inputString.indexOf(' ', currentWordIndex)
            if (nextSpaceIndex == -1) {
                nextSpaceIndex = inputString.length
            }

            when {
                nextSpaceIndex - currentLineIndex > k -> {
                    if (currentLineIndex != currentWordIndex && currentWordIndex - currentLineIndex - 1 <= k) {
                        val line = inputString.substring(currentLineIndex, currentWordIndex - 1)
                        returnList.add(line)
                        currentLineIndex = currentWordIndex
                    } else {
                        // single word too long to fit in one line
                        return null
                    }
                }
            }

            if (nextSpaceIndex == inputString.length) {
                returnList.add(inputString.substring(currentLineIndex, inputString.length))
                break
            } else {
                currentWordIndex = nextSpaceIndex + 1
            }
        }

        return returnList
    }
}
