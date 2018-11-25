package com.formichelli.dailycodingproblem.day1to100.day41to50

import java.util.*

/*
Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.

Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. However, the first one is lexicographically smaller.
*/
object Day41 {
    fun solution(flights: List<Pair<String, String>>, startAirport: String): List<String>? {
        val flightsMap = TreeMap<String, MutableSet<String>>()
        flights.forEach {
            flightsMap.computeIfAbsent(it.first) { _ -> TreeSet() }.add(it.second)
        }

        val itinerary = ArrayList<String>()
        solutionHelper(flightsMap, startAirport, itinerary)
        return itinerary
    }

    private fun solutionHelper(flightsMap: TreeMap<String, MutableSet<String>>, currentAirport: String, currentItinerary: MutableList<String>): List<String>? {
        currentItinerary.add(currentAirport)

        if (flightsMap.all { it.value.isEmpty() }) {
            // no flights left
            return currentItinerary
        }

        val flightsFromCurrent = flightsMap[currentAirport]
        flightsFromCurrent?.toSet()?.forEach {
            flightsFromCurrent.remove(it)
            val solution = solutionHelper(flightsMap, it, currentItinerary)
            if (solution != null) {
                return solution
            }
            flightsFromCurrent.add(it)
        }

        currentItinerary.removeAt(currentItinerary.size - 1)
        return null
    }
}
