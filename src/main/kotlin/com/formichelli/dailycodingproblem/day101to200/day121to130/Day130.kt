package com.formichelli.dailycodingproblem.day101to200.day121to130

/*
Given an array of numbers representing the stock prices of a company in chronological order and an integer k, return the maximum profit you can make from k buys and sells. You must buy the stock before you can sell it, and you must sell the stock before you can buy it again.

For example, given k = 2 and the array [5, 2, 4, 0, 1], you should return 3.
*/
object Day130 {
    fun solution(prices: IntArray, k: Int): Int {
        // maxProfit[i] = max profit on day i doing n transactions
        var maxProfit = IntArray(prices.size)

        for (transactions in 1..k) {
            val maxProfitNextTransaction = IntArray(prices.size)

            var maxProfitBeforeTodayOneShareAndOneTransactionLeft = Integer.MIN_VALUE

            for (j in 1 until prices.size) {
                val maxProfitNotUsingJ = maxProfitNextTransaction[j - 1]

                maxProfitBeforeTodayOneShareAndOneTransactionLeft = Math.max(maxProfitBeforeTodayOneShareAndOneTransactionLeft, maxProfit[j - 1] - prices[j - 1])
                val maxProfitUsingJ = maxProfitBeforeTodayOneShareAndOneTransactionLeft + prices[j]
                maxProfitNextTransaction[j] = Math.max(maxProfitNotUsingJ, maxProfitUsingJ)
            }

            maxProfit = maxProfitNextTransaction
        }

        return maxProfit[prices.lastIndex]
    }
}