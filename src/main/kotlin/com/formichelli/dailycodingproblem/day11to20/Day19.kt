package com.formichelli.dailycodingproblem.day11to20

/*
A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.
*/
object Day19 {
    fun solution(costMatrix: Array<IntArray>): Int {
        return recursiveSolution(costMatrix, 0, 0, -1, Int.MAX_VALUE)
    }

    private fun recursiveSolution(costMatrix: Array<IntArray>, currentHouseIndex: Int, cumulativeCost: Int, lastColor: Int, currentMinimumCost: Int): Int {
        // we have build all the houses
        if (currentHouseIndex == costMatrix.size)
            return cumulativeCost

        // avoid to explore combination that we already know are more expensive
        if (cumulativeCost > currentMinimumCost)
            return Int.MAX_VALUE

        // explore all the possible costs from this node, and calculate the minimum
        var minimumCostForTree = Int.MAX_VALUE
        val houseCostPerColor = costMatrix[currentHouseIndex]
        for (color in 0 until houseCostPerColor.size) {
            if (color == lastColor)
                continue

            minimumCostForTree = Math.min(minimumCostForTree, recursiveSolution(costMatrix, currentHouseIndex + 1, cumulativeCost + houseCostPerColor[color], color, currentMinimumCost))
        }

        // return the minimum among the minimum cost for this tree and the absolute minimum we have found so far
        return Math.min(minimumCostForTree, currentMinimumCost)
    }
}
