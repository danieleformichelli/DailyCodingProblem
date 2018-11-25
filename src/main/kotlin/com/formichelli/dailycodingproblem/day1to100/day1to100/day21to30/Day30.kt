package com.formichelli.dailycodingproblem.day1to100.day1to100.day21to30

/*
You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
*/
object Day30 {
    fun solution(elevationMap: IntArray): Int {
        // O(N)
        val maxElevation = elevationMap.max() ?: return 0

        var maxFromLeft = elevationMap.first()
        var maxFromRight = elevationMap.last()
        var maxElevationFromLeftIndex = 0
        var maxElevationFromRightIndex = 0
        var trappedWater = 0

        // O(N)
        // measure the water trapped from left side until the highest wall
        for (i in 0 until elevationMap.size) {
            if (elevationMap[i] == maxElevation) {
                maxElevationFromLeftIndex = i
                break
            } else if (elevationMap[i] > maxFromLeft) {
                maxFromLeft = elevationMap[i]
            } else {
                trappedWater += maxFromLeft - elevationMap[i]
            }
        }

        // O(N)
        // measure the water trapped from right side until the highest wall
        for (i in elevationMap.size - 1 downTo 0) {
            if (elevationMap[i] == maxElevation) {
                maxElevationFromRightIndex = i
                break
            } else if (elevationMap[i] > maxFromRight) {
                maxFromRight = elevationMap[i]
            } else {
                trappedWater += maxFromRight - elevationMap[i]
            }
        }

        // O(N)
        // measure the water trapped between the highest walls (if there is more than one
        for (i in maxElevationFromLeftIndex + 1 until maxElevationFromRightIndex) {
            trappedWater += maxElevation - elevationMap[i]
        }

        return trappedWater
    }
}
