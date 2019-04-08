package com.formichelli.dailycodingproblem.day101to200.day131to140

/*
Design and implement a HitCounter class that keeps track of requests (or hits). It should support the following operations:

record(timestamp): records a hit that happened at timestamp
total(): returns the total number of hits recorded
range(lower, upper): returns the number of hits that occurred between timestamps lower and upper (inclusive)
Follow-up: What if our system has limited memory?
*/
object Day132 {
    class HitCounter {
        var hits = ArrayList<Int>()

        fun record(timestamp: Int) {
            hits.add(timestamp)
        }

        fun total() = hits.size

        fun range(lower: Int, upper: Int): Int {
            var lowerIndex = hits.binarySearch(lower)
            if (lowerIndex < 0) {
                // if not found, binarySearch returns -insertionIndex -1, we need to start counting from insertionIndex
                lowerIndex = -lowerIndex - 1
            }
            var upperIndex = hits.binarySearch(upper)
            if (upperIndex < 0) {
                // if not found, binarySearch returns -(insertionIndex+1), we need to stop counting at insertionIndex-1
                upperIndex = (-upperIndex) - 2
            }

            return upperIndex - lowerIndex + 1
        }
    }
}