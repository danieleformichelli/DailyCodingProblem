package com.formichelli.dailycodingproblem.day101to200.day151to160

import kotlin.random.Random

/*
You are given n numbers as well as n probabilities that sum up to 1. Write a function to generate one of the numbers with its corresponding probability.

For example, given the numbers [1, 2, 3, 4] and probabilities [0.1, 0.5, 0.2, 0.2], your function should return 1 10% of the time, 2 50% of the time, and 3 and 4 20% of the time.

You can generate random numbers between 0 and 1 uniformly.
*/
object Day152 {
    fun solution(numbers: List<Int>, probabilities: List<Double>): Int {
        val rand = Random.nextDouble()

        var probabilitySum = 0.0
        numbers.forEachIndexed { index, number ->
            probabilitySum += probabilities[index]
            if (probabilitySum >= rand) {
                return number
            }
        }

        throw IllegalArgumentException()
    }
}