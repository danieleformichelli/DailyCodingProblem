package com.formichelli.dailycodingproblem.util

data class TrieNode(var word: String? = null, val next: MutableMap<Char, TrieNode> = HashMap()) {
    fun getNodeAt(word: String): TrieNode? {
        var currentNode: TrieNode? = this
        for (char in word) {
            currentNode = currentNode?.next?.get(char)
            if (currentNode == null) {
                return null
            }
        }

        return currentNode
    }
}