package com.formichelli.dailycodingproblem.day1to100.day51to60

/*
Given an undirected graph represented as an adjacency matrix and an integer k, write a function to determine whether each vertex in the graph can be colored such that no two adjacent vertices share the same color using at most k colors.
*/
object Day56 {
    fun solution(graph: Array<BooleanArray>, k: Int): Boolean {
        return solutionHelper(graph, IntArray(graph.size), 0, k)
    }

    private fun solutionHelper(graph: Array<BooleanArray>, vertexColor: IntArray, currentVertex: Int, colorsCount: Int): Boolean {
        if (currentVertex == graph.size) {
            return true
        }

        for (color in 1..colorsCount) {
            var canUseColor = true
            graph[currentVertex].forEachIndexed { index, isAdjacent ->
                if (isAdjacent && vertexColor[index] == color) {
                    canUseColor = false
                }
            }

            if (canUseColor) {
                vertexColor[currentVertex] = color
                if (solutionHelper(graph, vertexColor, currentVertex + 1, colorsCount)) {
                    return true
                }
                vertexColor[currentVertex] = 0
            }
        }

        return false
    }
}
