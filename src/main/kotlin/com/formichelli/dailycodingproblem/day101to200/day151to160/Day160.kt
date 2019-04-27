package com.formichelli.dailycodingproblem.day101to200.day151to160

/*
Given a tree where each edge has a weight, compute the length of the longest path in the tree.

For example, given the following tree:

   a
  /|\
 b c d
    / \
   e   f
  / \
 g   h
and the weights: a-b: 3, a-c: 5, a-d: 8, d-e: 2, d-f: 4, e-g: 1, e-h: 1, the longest path would be c -> a -> d -> f, with a length of 17.

The path does not have to pass through the root, and each node can have any amount of children.
*/
object Day160 {
    fun solution(graph: Array<List<Pair<Int, Int>>>): Int {
        val memo = HashMap<Int, MutableMap<Int, Int>>()
        return (0 until graph.size).maxBy {
            val (longest, secondLongest) = solutionHelper(graph, it, memo, null)
            return longest + secondLongest
        }!!
    }

    private fun solutionHelper(graph: Array<List<Pair<Int, Int>>>, index: Int, memo: MutableMap<Int, MutableMap<Int, Int>>, cantPassThrough: Int?): Pair<Int, Int> {
        val adjacencyList = graph[index]
        var longest = 0
        var secondLongest = 0
        for (i in 0 until adjacencyList.size) {
            val (nextNode, nextNodeWeight) = adjacencyList[i]
            if (nextNode == cantPassThrough) {
                continue
            }

            val longestPathThroughNext = memo.computeIfAbsent(index) { HashMap() }.computeIfAbsent(nextNode) { nextNodeWeight + solutionHelper(graph, nextNode, memo, index).first }

            when {
                longestPathThroughNext > longest -> {
                    secondLongest = longest
                    longest = longestPathThroughNext
                }
                longestPathThroughNext > secondLongest -> {
                    secondLongest = longestPathThroughNext
                }
            }
        }

        return Pair(longest, secondLongest)
    }
}