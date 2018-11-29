package com.formichelli.dailycodingproblem.day101to200.day111to120

/*
Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here", return "here world hello"

Follow-up: given a mutable string representation, can you perform this operation in-place?
*/
object Day113 {
    fun solution(words: CharArray) {
        for (i in 0 until words.size / 2) {
            swap(words, i, words.size - i - 1)
        }

        var lastSpace = -1
        for (i in 0 until words.size) {
            if (words[i] == ' ') {
                swapWord(words, lastSpace + 1, i)
                lastSpace = i
            }
        }

        swapWord(words, lastSpace + 1, words.size)
    }

    private fun swapWord(words: CharArray, i1: Int, i2: Int) {
        for (j in 0 until (i2 - i1) / 2) {
            swap(words, i1 + j, i2 - j - 1)
        }
    }

    private fun swap(words: CharArray, i1: Int, i2: Int) {
        val tmp = words[i1]
        words[i1] = words[i2]
        words[i2] = tmp
    }
}