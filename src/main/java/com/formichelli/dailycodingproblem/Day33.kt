package com.formichelli.dailycodingproblem

import java.util.*
import kotlin.collections.ArrayList

/*
Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2
*/
object Day33 {
    fun solution(numbersStream: List<Int>): List<Double> {
        val higherThanMedianFromLowerToHigher = PriorityQueue<Int>()
        val lowerThanMedianFromHigherToLower = PriorityQueue<Int>(Comparator.comparingInt { -it })
        val medians = ArrayList<Double>(numbersStream.size)
        numbersStream.forEach {
            if (medians.isEmpty() || it > medians.last()) {
                higherThanMedianFromLowerToHigher.add(it)
            } else {
                lowerThanMedianFromHigherToLower.add(it)
            }

            val runningMedian = when (higherThanMedianFromLowerToHigher.size - lowerThanMedianFromHigherToLower.size) {
                2 -> {
                    lowerThanMedianFromHigherToLower.add(higherThanMedianFromLowerToHigher.poll())
                    (higherThanMedianFromLowerToHigher.peek() + lowerThanMedianFromHigherToLower.peek()) / 2.0
                }
                1 -> higherThanMedianFromLowerToHigher.peek().toDouble()
                0 -> (higherThanMedianFromLowerToHigher.peek() + lowerThanMedianFromHigherToLower.peek()) / 2.0
                -1 -> lowerThanMedianFromHigherToLower.peek().toDouble()
                -2 -> {
                    higherThanMedianFromLowerToHigher.add(lowerThanMedianFromHigherToLower.poll())
                    (higherThanMedianFromLowerToHigher.peek() + lowerThanMedianFromHigherToLower.peek()) / 2.0
                }
                else -> throw RuntimeException("This can never happen")
            }
            medians.add(runningMedian)
        }

        return medians
    }
}
