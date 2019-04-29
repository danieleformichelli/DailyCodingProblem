package com.formichelli.dailycodingproblem.day101to200.day161to170

import kotlin.streams.toList

/*
Given a list of words, return the shortest unique prefix of each word.

For example, given the list:
dog
cat
apple
apricot
fish

Return the list:
d
c
app
apr
f
*/
object Day162 {
    data class TrieNode(var word: String? = null, val next: MutableMap<Char, TrieNode> = HashMap())

    fun solution(words: List<String>): List<String> {
        val shortestPrefixes = HashMap<String, String>()
        val root = TrieNode()
        words.forEach { word ->
            var currentNode = root
            val currentPrefix = StringBuilder()

            for (i in 0 until word.length) {
                val char = word[i]
                currentPrefix.append(char)
                val nextNode = currentNode.next[char]
                if (nextNode == null) {
                    currentNode.next[char] = TrieNode(word)
                    shortestPrefixes[word] = currentPrefix.toString()
                    break
                } else {
                    val wordWithSamePrefix = nextNode.word
                    if (wordWithSamePrefix != null) {
                        nextNode.word = null
                        val nextChar = wordWithSamePrefix[i + 1]
                        nextNode.next[nextChar] = TrieNode(wordWithSamePrefix)
                        shortestPrefixes.remove(wordWithSamePrefix)
                        shortestPrefixes[wordWithSamePrefix] = currentPrefix.toString() + nextChar
                    }
                }
                currentNode = nextNode
            }
        }

        return words.stream().map { shortestPrefixes[it]!! }.toList()
    }
}