package com.formichelli.dailycodingproblem.day101to200.day131to140

import java.util.*
import kotlin.collections.HashMap

/*
Find the minimum number of coins required to make n cents.

You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.

For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.
*/
object Day138 {
    fun solution(cents: Int): Int {
        return solutionHelper(cents, intArrayOf(1, 5, 10, 25), HashMap())
    }

    private fun solutionHelper(cents: Int, centSizes: IntArray, memo: MutableMap<Int, Int>): Int {
        if (centSizes.isEmpty()) {
            return -1
        }

        if (centSizes.size == 1) {
            return if (cents % centSizes.first() == 0) {
                cents / centSizes.first()
            } else {
                -1
            }
        }

        if (centSizes.last() > cents) {
            return solutionHelper(cents, Arrays.copyOfRange(centSizes, 0, centSizes.lastIndex), memo)
        }

        if (cents == 0) {
            return 0
        }

        if (memo.containsKey(cents)) {
            return memo[cents]!!
        }

        var minCount = Int.MAX_VALUE

        val biggestCentSize = centSizes.last()
        val centSizesWithoutBiggest = Arrays.copyOfRange(centSizes, 0, centSizes.lastIndex)
        for (i in 0..cents / biggestCentSize) {
            val remainingCentsWithNOfBiggestSize = cents - i * biggestCentSize
            val solutionWithNOfBiggestSize = solutionHelper(remainingCentsWithNOfBiggestSize, centSizesWithoutBiggest, memo)
            if (solutionWithNOfBiggestSize == -1) {
                continue
            }

            minCount = Math.min(minCount, i + solutionWithNOfBiggestSize)
        }

        memo[cents] = minCount
        return minCount
    }
}