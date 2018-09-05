package com.formichelli.dailycodingproblem

/*
Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
*/
object Day11 {
    class SearchNode(private val value: Char) {
        companion object {
            const val ALPHABET_SIZE = 'z' - 'a' + 2
            const val STRING_END = 0.toChar()
        }

        // one children for each letter plus string end
        private val children = Array<SearchNode?>(ALPHABET_SIZE) { null }

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

        fun getPrefixSet(queryString: String): Set<String> {
            return getPrefixSet(queryString, 0)
        }

        private fun getPrefixSet(queryString: String, index: Int): Set<String> {
            val charAtIndex = queryString[index]
            val indexOfChar = charAtIndex - 'a'
            return if (children[indexOfChar] != null) {
                if (index < queryString.length - 1) {
                    children[indexOfChar]!!.getPrefixSet(queryString, index + 1)
                } else {
                    children[indexOfChar]!!.getStringSet(queryString)
                }
            } else {
                setOf()
            }
        }

        private fun getStringSet(prefix: String, stringSet: MutableSet<String> = mutableSetOf()): Set<String> {
            children.filterNotNull().forEach {
                if (it.value == STRING_END) {
                    stringSet.add(prefix)
                } else {
                    it.getStringSet(prefix + it.value, stringSet)
                }
            }

            return stringSet
        }
    }

    fun solution(query: String, querySet: Set<String>): Set<String> {
        val searchRoot = SearchNode(0.toChar())
        for (queryString in querySet) {
            searchRoot.add(queryString)
        }

        return searchRoot.getPrefixSet(query)
    }
}
