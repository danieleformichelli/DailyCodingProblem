package com.formichelli.dailycodingproblem.day31to40

/*
Suppose you are given a table of currency exchange rates, represented as a 2D array. Determine whether there is a possible arbitrage: that is, whether there is some sequence of trades you can make, starting with some amount A of any currency, so that you can end up with some amount greater than A of that currency.

There are no transaction costs and you can trade fractional quantities.
*/
object Day32 {
    fun solution(exchangeRates: Array<DoubleArray>): Boolean {
        val visitedList = BooleanArray(exchangeRates.size)
        return (0 until exchangeRates.size).any { currency ->
            solutionHelper(exchangeRates, currency, currency, visitedList, 1.0)
        }
    }

    private fun solutionHelper(exchangeRates: Array<DoubleArray>, startCurrency: Int, currentCurrency: Int, visitedList: BooleanArray, totalExchangeRate: Double): Boolean {
        visitedList[currentCurrency] = true

        for (i in 0 until exchangeRates.size) {
            val rateForIndex = totalExchangeRate * exchangeRates[currentCurrency][i]
            if (i == startCurrency) {
                if (rateForIndex < 1.0) {
                    return true
                }
            } else if (!visitedList[i] && solutionHelper(exchangeRates, startCurrency, i, visitedList, rateForIndex)) {
                return true
            }
        }

        visitedList[currentCurrency] = false
        return false
    }
}
