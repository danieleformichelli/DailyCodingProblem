package com.formichelli.dailycodingproblem.day1to100.day1to100.day61to70

import java.util.*

/*
Assume you have access to a function toss_biased() which returns 0 or 1 with a probability that's not 50-50 (but also not 0-100 or 100-0). You do not know the bias of the coin.

Write a function to simulate an unbiased coin toss.
*/
object Day66 {
    private val rand = Random()
    private fun biasedToss(biasThreshold: Double) = rand.nextDouble() > biasThreshold

    fun solution(biasThreshold: Double): Boolean {
        while (true) {
            // toss with opposite bias until we get the same result twice
            val tossResult = biasedToss(biasThreshold)
            if (biasedToss(biasThreshold) != tossResult) {
                return tossResult
            }
        }
    }
}
