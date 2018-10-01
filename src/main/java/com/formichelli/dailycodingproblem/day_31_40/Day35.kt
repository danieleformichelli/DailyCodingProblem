package com.formichelli.dailycodingproblem.day_31_40

/*
Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
*/
object Day35 {
    fun solution(charArray: CharArray): CharArray {
        var rCount = 0
        var gCount = 0
        var bCount = 0

        for (i in 0 until charArray.size) {
            when (charArray[i]) {
                'R' -> {
                    // swap with first B, then with first G
                    swap(charArray, i, rCount + gCount)
                    swap(charArray, rCount + gCount, rCount)

                    ++rCount
                }
                'G' -> {
                    // swap with first B
                    swap(charArray, i, rCount + gCount)
                    ++gCount
                }
                'B' -> ++bCount
            }
        }

        return charArray
    }

    private fun swap(charArray: CharArray, indexA: Int, indexB: Int) {
        val tmp = charArray[indexA]
        charArray[indexA] = charArray[indexB]
        charArray[indexB] = tmp
    }
}
