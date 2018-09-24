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
    fun MutableList<Int>.addSorted(newValue: Int) {
        this.forEachIndexed { index, value ->
            if (newValue < value) {
                this.add(index, newValue)
                return
            }
        }

        this.add(newValue)
    }

    fun solution(numbersStream: List<Int>): List<Double> {
        val numbers = LinkedList<Int>()
        val medians = ArrayList<Double>(numbersStream.size)
        numbersStream.forEach {
            numbers.addSorted(it)
            medians.add(computeMedian(numbers))
        }

        return medians
    }

    private fun computeMedian(sortedNumbers: List<Int>) = if (sortedNumbers.size % 2 != 0) {
        // middle element
        sortedNumbers[sortedNumbers.size / 2].toDouble()
    } else {
        // average of the 2 middle elements
        (sortedNumbers[sortedNumbers.size / 2] + sortedNumbers[sortedNumbers.size / 2 - 1]) / 2.0
    }
}
