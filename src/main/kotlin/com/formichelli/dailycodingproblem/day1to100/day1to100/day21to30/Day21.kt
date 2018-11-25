package com.formichelli.dailycodingproblem.day1to100.day1to100.day21to30

/*
Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
*/
object Day21 {
    fun solution(timeIntervals: Array<Pair<Int, Int>>): Int {
        val sortedTimeIntervals = timeIntervals.toMutableList().sortedBy { it.first }
        // each interval needs at lest one room
        val intervalOverlaps = IntArray(sortedTimeIntervals.size) { 1 }
        for (i in 0 until sortedTimeIntervals.size) {
            // for each interval, check which intervals it overlaps
            val intervalEndTime = sortedTimeIntervals[i].second
            for (j in i + 1 until sortedTimeIntervals.size) {
                if (intervalEndTime > sortedTimeIntervals[j].first) {
                    // interval i overlaps interval j
                    ++intervalOverlaps[j]
                }
            }
        }
        return intervalOverlaps.max() ?: 0
    }
}
