package com.formichelli.dailycodingproblem

import com.formichelli.dailycodingproblem.util.SearchNode

/*
Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
*/
object Day22 {
    fun solution(dictionary: Set<String>, inputString: String): List<String> {
        val dictionaryTree = SearchNode(dictionary)
        return solutionHelper(dictionaryTree, dictionaryTree, inputString, 0, mutableListOf(), "")
    }

    private fun solutionHelper(dictionaryTree: SearchNode, currentDictionaryNode: SearchNode, inputString: String, index: Int, sentence: MutableList<String>, currentWord: String): List<String> {
        if (index == inputString.length) {
            // end of the sentence, check if we are at the end of the word
            return if (currentDictionaryNode.isLastOfWord()) {
                sentence.add(currentWord.toString())
                sentence
            } else {
                emptyList()
            }
        }

        if (currentDictionaryNode.isLastOfWord()) {
            // found a word, check if selecting this word we can complete the sentence
            sentence.add(currentWord.toString())
            val result = solutionHelper(dictionaryTree, dictionaryTree, inputString, index, sentence, "")
            if (!result.isEmpty()) {
                // found a sentence, return it
                return result
            } else {
                // not found a sentence, discard this word
                sentence.removeAt(sentence.size - 1)
            }
        }

        val nextCharNode = currentDictionaryNode.getChildren(inputString[index]) ?: return emptyList()
        return solutionHelper(dictionaryTree, nextCharNode, inputString, index + 1, sentence, currentWord + nextCharNode.value)
    }
}
