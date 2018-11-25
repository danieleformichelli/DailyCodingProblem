package com.formichelli.dailycodingproblem.day1to100.day51to60

import java.util.*
import kotlin.math.roundToInt

/*
Given a function that generates perfectly random numbers between 1 and k (inclusive), where k is an input, write a function that shuffles a deck of cards represented as an array using only swaps.

It should run in O(N) time.

Hint: Make sure each one of the 52! permutations of the deck is equally likely.
*/
object Day51 {
    private val rand = Random()

    // Given function to return a random between 1 and k
    private fun randK(k: Int) = rand.nextInt(k) + 1

    // Function to generate a random between 1 and k^n, given the function to return a random between 1 and k
    private fun randKN(k: Int, n: Int): Int = if (n == 1) {
        randK(k)
    } else {
        Math.pow(k.toDouble(), (n / 2).toDouble()).roundToInt() * (randKN(k, (n / 2)) - 1) + randKN(k, (n / 2))
    }

    private fun random(target: Int, k: Int): Int {
        // similar to day 45
        // determine the first power of k which is greater than target
        var n = 1
        var kn = k
        while (kn < target) {
            n *= 2
            kn *= kn
        }

        // determine which values should be discarded (similar to the >= 22 in day 45)
        val maximumAcceptedRandom = kn / target * target
        var randKn: Int
        do {
            randKn = randKN(k, n)
        } while (randKn > maximumAcceptedRandom)

        return randKn % target
    }

    private fun swap(deck: IntArray, i: Int, j: Int) {
        val tmp = deck[i]
        deck[i] = deck[j]
        deck[j] = tmp
    }

    fun solution(deck: IntArray, k: Int) {
        for (i in 0 until deck.size) {
            val newPosition = i + random(deck.size - i, k)
            swap(deck, i, newPosition)
        }
    }
}
