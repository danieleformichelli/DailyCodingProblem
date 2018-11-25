package com.formichelli.dailycodingproblem.day1to100.day11to20

import java.util.*
import java.util.stream.IntStream

/*
Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
*/
object Day15 {
    fun solution(elements: IntStream): Int {
        var i = 1
        var element = 0
        val random = Random()
        elements.forEach {
            if (random.nextInt(i) == i - 1) {
                element = it
            }
            ++i
        }

        return element
    }
}
