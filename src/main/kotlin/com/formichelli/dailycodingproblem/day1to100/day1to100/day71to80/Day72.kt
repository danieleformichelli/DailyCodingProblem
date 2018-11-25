package com.formichelli.dailycodingproblem.day1to100.day1to100.day71to80

/*
In a directed graph, each node is assigned an uppercase letter. We define a path's value as the number of most frequently-occurring letter along that path. For example, if a path in the graph goes through "ABACA", the value of the path is 3, since there are 3 occurrences of 'A' on the path.

Given a graph with n nodes and m directed edges, return the largest value path of the graph. If the largest value is infinite, then return null.

The graph is represented with a string and an edge list. The i-th character represents the uppercase letter of the i-th node. Each tuple in the edge list (i, j) means there is a directed edge from the i-th node to the j-th node. Self-edges are possible, as well as multi-edges.

For example, the following input graph:

ABACA
[(0, 1),
 (0, 2),
 (2, 3),
 (3, 4)]
Would have maximum value 3 using the path of vertices [0, 2, 3, 4], (A, A, C, A).

The following input graph:

A
[(0, 0)]
Should return null, since we have an infinite loop.
*/
object Day72 {
    fun solution(nodeLetters: String, edgesList: List<Pair<Int, Int>>): Int {
        var maxValuePath = 0
        val visitedLetters = BooleanArray(nodeLetters.length)
        val lettersCount = HashMap<Char, Int>()
        val edgesMap = HashMap<Int, MutableSet<Int>>()
        edgesList.forEach { edge ->
            edgesMap.computeIfAbsent(edge.first) { HashSet() }.add(edge.second)
        }

        for (index in 0 until visitedLetters.size) {
            val valuePath = solutionHelper(nodeLetters, visitedLetters, edgesMap, index, lettersCount)
            if (valuePath == -1) {
                return -1
            } else if (valuePath > maxValuePath) {
                maxValuePath = valuePath
            }
        }

        return maxValuePath
    }

    private fun solutionHelper(nodeLetters: String, visitedLetters: BooleanArray, edgesMap: HashMap<Int, MutableSet<Int>>, index: Int, lettersCount: HashMap<Char, Int>): Int {
        if (visitedLetters[index]) {
            return -1
        }

        visitedLetters[index] = true
        val letter = nodeLetters[index]
        val letterCount = lettersCount.getOrDefault(letter, 0)
        lettersCount[letter] = letterCount + 1

        var maxValuePath = 0
        val edges = edgesMap[index].orEmpty()
        if (edges.isEmpty()) {
            // calculate valuePath
            maxValuePath = lettersCount.values.stream().mapToInt { it }.max().orElse(0)
        } else {
            edges.forEach {
                val valuePath = solutionHelper(nodeLetters, visitedLetters, edgesMap, it, lettersCount)
                if (valuePath == -1) {
                    return -1
                } else if (valuePath > maxValuePath) {
                    maxValuePath = valuePath
                }
            }
        }

        visitedLetters[index] = false
        lettersCount[letter] = letterCount

        return maxValuePath
    }
}
