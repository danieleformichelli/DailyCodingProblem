package com.formichelli.dailycodingproblem.day101to200.day161to170

import com.formichelli.dailycodingproblem.util.TrieNode

/*
Given a list of words, find all pairs of unique indices such that the concatenation of the two words is a palindrome.

For example, given the list ["code", "edoc", "da", "d"], return [(0, 1), (1, 0), (2, 3)].
*/
object Day167 {
    fun solution(words: List<String>): Set<Pair<Int, Int>> {
        val root = TrieNode()
        for (word in words) {
            var lastNode: TrieNode = root
            for (char in word.reversed()) {
                lastNode = lastNode.next.computeIfAbsent(char) { TrieNode() }
            }

            lastNode.word = word
        }

        val wordToIndex = HashMap<String, Int>()
        words.forEachIndexed { index, word -> wordToIndex[word] = index }

        val result = HashSet<Pair<Int, Int>>()
        for (word in words) {
            // search reverse of word
            val nodeAtWord = root.getNodeAt(word)
            if (word != word.reversed() && nodeAtWord?.word != null) {
                result.add(Pair(wordToIndex[word]!!, wordToIndex[nodeAtWord.word!!]!!))
            }

            // search reverse of word plus one other
            nodeAtWord?.next?.values?.forEach {
                val wordWithOneMore = it.word
                if (wordWithOneMore != null) {
                    result.add(Pair(wordToIndex[word]!!, wordToIndex[wordWithOneMore]!!))
                }
            }

            // search reverse of word minus last
            val wordWithoutLast = word.substring(0, word.lastIndex)
            val wordWithoutLastReversed = wordWithoutLast.reversed()
            val nodeAtWordWithoutLast = root.getNodeAt(wordWithoutLast)
            if (word != wordWithoutLastReversed && nodeAtWordWithoutLast?.word != null) {
                result.add(Pair(wordToIndex[word]!!, wordToIndex[nodeAtWordWithoutLast.word!!]!!))
            }
        }
        return result
    }
}