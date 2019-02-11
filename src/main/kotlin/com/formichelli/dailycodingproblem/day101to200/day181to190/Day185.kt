package com.formichelli.dailycodingproblem.day101to200.day181to190

/*
Given two rectangles on a 2D graph, return the area of their intersection. If the rectangles don't intersect, return 0.

For example, given the following rectangles:

{
    "top_left": (1, 4),
    "dimensions": (3, 3) # width, height
}
and

{
    "top_left": (0, 5),
    "dimensions" (4, 3) # width, height
}
return 6.
*/
object Day185 {
    data class Rectangle(val coordinates: Pair<Int, Int>, val size: Pair<Int, Int>)

    fun solution(r1: Rectangle, r2: Rectangle): Int {
        TODO("not implemented")
    }
}