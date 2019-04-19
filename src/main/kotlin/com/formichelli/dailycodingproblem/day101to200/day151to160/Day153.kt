package com.formichelli.dailycodingproblem.day101to200.day151to160

/*
Find an efficient algorithm to find the smallest distance (measured in number of words) between any two given words in a string.

For example, given words "hello", and "world" and a text content of "dog cat hello cat dog dog hello cat world", return 1 because there's only one word "cat" in between the two words.
*/
object Day153 {
    fun solution(text: String, word1: String, word2: String): Int {
        val words = text.split(" ").toList()
        val word1Positions = ArrayList<Int>()
        val word2Positions = ArrayList<Int>()
        words.forEachIndexed { index, word ->
            when (word) {
                word1 -> word1Positions.add(index)
                word2 -> word2Positions.add(index)
            }
        }

        var minDistance = Int.MAX_VALUE
        var index1 = 0
        var index2 = 0
        while (index1 < word1Positions.size && index2 < word2Positions.size) {
            val word1Position = word1Positions[index1]
            val word2Position = word2Positions[index2]
            val distance = Math.abs(word1Position - word2Position)
            minDistance = Math.min(minDistance, distance)
            if (word1Position < word2Position) {
                ++index1
            } else {
                ++index2
            }
        }

        return minDistance - 1
    }
}