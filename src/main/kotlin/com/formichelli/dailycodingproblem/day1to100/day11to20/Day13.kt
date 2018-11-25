package com.formichelli.dailycodingproblem.day1to100.day11to20

/*
Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
*/
object Day13 {
    fun solution(k: Int, s: String): String {
        var longest = ""
        for (i in 0 until s.length) {
            val longestAtIndex = longestAtIndex(s, i, k)
            if (longestAtIndex.length > longest.length)
                longest = longestAtIndex
        }

        return longest
    }

    private fun longestAtIndex(s: String, i: Int, k: Int): String {
        val charSet = mutableSetOf<Char>()
        for (j in i until s.length) {
            charSet.add(s[j])
            if (charSet.size > k)
                return s.substring(i, j)
        }

        return s.substring(i)
    }
}
