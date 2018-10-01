package com.formichelli.dailycodingproblem.day11to20

/*
There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
*/
object Day12 {
    fun solutionRecursive(stepsCount: Int): Int {
        return when (stepsCount) {
            1 -> 1
            2 -> 2
            else -> solutionRecursive(stepsCount - 1) + solutionRecursive(stepsCount - 2)
        }
    }

    fun solutionIterative(stepsCount: Int): Int {
        if (stepsCount == 1) {
            return 1
        }

        val uniqueWays = IntArray(stepsCount)
        uniqueWays[0] = 1
        uniqueWays[1] = 2
        for (i in 2 until stepsCount) {
            uniqueWays[i] = uniqueWays[i - 1] + uniqueWays[i - 2]
        }

        return uniqueWays[stepsCount - 1]
    }
}
