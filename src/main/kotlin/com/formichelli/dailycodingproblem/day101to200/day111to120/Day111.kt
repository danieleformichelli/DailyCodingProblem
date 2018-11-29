package com.formichelli.dailycodingproblem.day101to200.day111to120

/*
Given a word W and a string S, find all starting indices in S which are anagrams of W.

For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.
*/
object Day111 {
    fun solution(W: String, S: String): List<Int> {
        val wCharsCount = HashMap<Char, Int>()
        val sCharsCount = HashMap<Char, Int>()

        W.forEach {
            wCharsCount[it] = wCharsCount.getOrDefault(it, 0) + 1
        }

        val anagrams = mutableListOf<Int>()
        var anagramStart = 0
        for (i in 0 until S.length) {
            val char = S[i]
            sCharsCount[char] = sCharsCount.getOrDefault(char, 0) + 1

            val compare = Integer.compare(sCharsCount[char]!!, wCharsCount.getOrDefault(char, 0))
            if (compare > 0) {
                // too many occurrencies of char, not an anagram
                sCharsCount.clear()
                anagramStart = i + 1
            } else if (compare == 0) {
                // correct number of occurrencies of char, could be an anagram
                if (i - anagramStart + 1 == W.length) {
                    // it is an anagram, start to check from next letter after anagramStart
                    anagrams.add(anagramStart)
                    sCharsCount[S[anagramStart]] = sCharsCount.getOrDefault(S[anagramStart], 0) - 1
                    ++anagramStart
                }
            } else {
                // not enough occurrencies of char, still not an anagram
            }
        }

        return anagrams
    }
}