package com.formichelli.dailycodingproblem.util

class SearchNode private constructor(val value: Char) {
    constructor(querySet: Set<String>) : this(0.toChar()) {
        querySet.forEach { add(it) }
    }

    companion object {
        const val ALPHABET_SIZE = 'z' - 'a' + 2
        const val STRING_END = 0.toChar()
    }

    // one children for each letter plus string end
    val children = Array<SearchNode?>(ALPHABET_SIZE) { null }

    fun add(queryString: String) {
        add(queryString, 0)
    }

    private fun add(queryString: String, index: Int) {
        if (index == queryString.length) {
            children[ALPHABET_SIZE - 1] = SearchNode(STRING_END)
            return
        }

        val charAtIndex = queryString[index]
        val indexOfChar = charAtIndex - 'a'
        if (children[indexOfChar] == null) {
            children[indexOfChar] = SearchNode(charAtIndex)
        }

        children[indexOfChar]?.add(queryString, index + 1)
    }
}