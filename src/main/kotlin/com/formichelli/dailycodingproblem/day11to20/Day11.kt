package com.formichelli.dailycodingproblem.day11to20

import com.formichelli.dailycodingproblem.util.SearchNode

/*
Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
*/
object Day11 {
    private fun getPrefixSet(searchNode: SearchNode, queryString: String): Set<String> {
        return getPrefixSet(searchNode, queryString, 0)
    }

    private fun getPrefixSet(searchNode: SearchNode, queryString: String, index: Int): Set<String> {
        val charAtIndex = queryString[index]
        val indexOfChar = charAtIndex - 'a'
        val childAtIndex = searchNode.children[indexOfChar]
        return if (childAtIndex != null) {
            if (index < queryString.length - 1) {
                getPrefixSet(childAtIndex, queryString, index + 1)
            } else {
                getStringSet(childAtIndex, queryString)
            }
        } else {
            setOf()
        }
    }

    private fun getStringSet(searchNode: SearchNode, prefix: String, stringSet: MutableSet<String> = mutableSetOf()): Set<String> {
        searchNode.children.filterNotNull().forEach {
            if (it.value == SearchNode.STRING_END) {
                stringSet.add(prefix)
            } else {
                getStringSet(it, prefix + it.value, stringSet)
            }
        }

        return stringSet
    }

    fun solution(query: String, querySet: Set<String>): Set<String> {
        return getPrefixSet(SearchNode(querySet), query)
    }
}
