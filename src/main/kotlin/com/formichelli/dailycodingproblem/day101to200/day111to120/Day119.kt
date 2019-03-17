package com.formichelli.dailycodingproblem.day101to200.day111to120

import java.util.*

/*
Given a set of closed intervals, find the smallest set of numbers that covers all the intervals. If there are multiple smallest sets, return any of them.

For example, given the intervals [0, 3], [2, 6], [3, 4], [6, 9], one set of numbers that covers all these intervals is {3, 6}.
*/
object Day119 {
    fun solution(intervals: Set<Pair<Int, Int>>): Set<Int> {
        // 0 1 2 3 4 5 6 7 8 9
        // - - - -
        //     - - - - -
        //       - -
        //             - - - -
        // Sort by start, and select start of last interval. Discard all the others containing such number and continue
        // Select 6, discard [2, 6] and [6, 9]
        // 0 1 2 3 4 5 6 7 8 9
        // - - - -
        //       - -
        // Select 3, discard [0, 3] and [3, 4]
        // Done
        val resultSet = HashSet<Int>()

        val sortedIntervals = ArrayList<Pair<Int, Int>>()
        sortedIntervals.addAll(intervals)
        sortedIntervals.sortBy { it.first }

        while (!sortedIntervals.isEmpty()) {
            val lastInterval = sortedIntervals.removeAt(sortedIntervals.lastIndex)
            val selectedItem = lastInterval.first
            resultSet.add(selectedItem)
            sortedIntervals.removeIf { it.second >= selectedItem }
        }

        return resultSet
    }
}