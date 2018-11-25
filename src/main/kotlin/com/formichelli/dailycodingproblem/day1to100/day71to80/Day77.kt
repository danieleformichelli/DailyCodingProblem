package com.formichelli.dailycodingproblem.day71to80

import java.util.*

/*
Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.

The input list is not necessarily ordered in any way.

For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].
*/
object Day77 {
    fun solution(intervals: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        if (intervals.isEmpty()) {
            return Collections.emptyList()
        }

        val treeSet = TreeSet<Pair<Int, Int>>(Comparator.comparingInt { it.first })
        intervals.forEach { treeSet.add(it) }

        val mergedIntervals = ArrayList<Pair<Int, Int>>()
        mergedIntervals.add(treeSet.first())
        treeSet.stream().skip(1).forEach { nextInterval ->
            val lastInterval = mergedIntervals.last()
            if (nextInterval.first <= lastInterval.second) {
                if (nextInterval.second > lastInterval.second) {
                    mergedIntervals.remove(lastInterval)
                    mergedIntervals.add(Pair(lastInterval.first, nextInterval.second))
                }
            } else {
                mergedIntervals.add(nextInterval)
            }
        }

        return mergedIntervals
    }
}
