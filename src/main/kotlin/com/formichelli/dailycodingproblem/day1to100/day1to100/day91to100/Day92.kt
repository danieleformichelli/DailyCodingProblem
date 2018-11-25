package com.formichelli.dailycodingproblem.day1to100.day1to100.day91to100

import java.util.*
import kotlin.collections.HashMap

/*
We're given a hashmap with a key courseId and value a list of courseIds, which represents that the prerequsite of courseId is courseIds. Return a sorted ordering of courses such that we can finish all courses.

Return null if there is no such ordering.

For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSC300'].
*/
object Day92 {
    fun solution(prerequisitesMap: Map<String, List<String>>): List<String> {
        val availableCourses = ArrayList<String>()
        val invertedPrerequisitesMap = HashMap<String, MutableList<String>>()
        val mutablePrerequisitesMap = HashMap<String, MutableList<String>>()
        prerequisitesMap.forEach {
            mutablePrerequisitesMap[it.key] = it.value.toMutableList()
            invertedPrerequisitesMap.computeIfAbsent(it.key) { ArrayList() }
            it.value.forEach { prerequisite ->
                invertedPrerequisitesMap.computeIfAbsent(prerequisite) { ArrayList() }.add(it.key)
            }

            if (it.value.isEmpty()) {
                availableCourses.add(it.key)
            }
        }

        val courseOrdering = ArrayList<String>()
        while (courseOrdering.size != prerequisitesMap.size) {
            if (availableCourses.isEmpty()) {
                // no valid ordering, return empty list
                return Collections.emptyList()
            }

            val nextCourse = availableCourses.removeAt(availableCourses.size - 1)
            courseOrdering.add(nextCourse)
            invertedPrerequisitesMap[nextCourse]!!.forEach {
                val remainingPrerequisites = mutablePrerequisitesMap[it]
                remainingPrerequisites!!.remove(nextCourse)
                if (remainingPrerequisites.isEmpty()) {
                    availableCourses.add(it)
                }
            }
        }

        return courseOrdering
    }
}
