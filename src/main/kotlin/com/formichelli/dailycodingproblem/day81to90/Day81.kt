package com.formichelli.dailycodingproblem.day81to90

import java.util.*

/*
Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent. You can assume each valid number in the mapping is a single digit.

For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].
*/
object Day81 {
    fun solution(number: String, mapping: Map<String, List<String>>): List<String> {
        val possibleWords = LinkedList<StringBuilder>()
        mapping[number[0].toString()]!!.forEach {
            possibleWords.add(StringBuilder(it))
        }

        for (digit in number.substring(1)) {
            val currentWordsCount = possibleWords.size
            val mappingsForDigit = mapping[digit.toString()]!!
            for (currentWordIndex in 1..currentWordsCount) {
                val word = possibleWords.removeAt(0)
                for (mappingForDigit in mappingsForDigit) {
                    possibleWords.add(StringBuilder(word).append(mappingForDigit))
                }
            }
        }

        return possibleWords.map { it.toString() }
    }
}
