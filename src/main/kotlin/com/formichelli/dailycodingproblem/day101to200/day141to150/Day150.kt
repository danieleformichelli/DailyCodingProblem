package com.formichelli.dailycodingproblem.day101to200.day141to150

import com.formichelli.dailycodingproblem.util.ListNode

/*
Given a list of points, a central point, and an integer k, find the nearest k points from the central point.

For example, given the list of points [(0, 0), (5, 4), (3, 1)], the central point (1, 2), and k = 2, return [(0, 0), (3, 1)].
*/
object Day150 {
    fun solution(points: List<Pair<Int, Int>>, center: Pair<Int, Int>, k: Int): List<Pair<Int, Int>> {
        var nearest: ListNode<Pair<Int, Int>>? = null
        var kFarthest: ListNode<Pair<Int, Int>>? = null
        val distances = HashMap<Pair<Int, Int>, Int>()

        for (point in points) {
            val distance = point.distance(center)

            if (kFarthest != null) {
                // not in the first k so far, discard it
                if (distances[kFarthest.value]!! < distance) {
                    continue
                }
            }

            distances[point] = distance

            val node = ListNode(point)
            if (nearest != null) {
                // insert in order
                var prev: ListNode<Pair<Int, Int>>? = null
                var current = nearest
                while (current != null && distances[current.value]!! < distance) {
                    prev = current
                    current = current.next
                }

                prev?.next = node
                node.prev = prev
                node.next = current
                current?.prev = node
                if (prev == null) {
                    nearest = node
                }

                if (kFarthest != null) {
                    distances.remove(kFarthest.value)
                    kFarthest.prev?.next = null
                    kFarthest = kFarthest.prev
                } else if (distances.size == k) {
                    kFarthest = node
                }
            } else {
                nearest = node
                if (k == 1) {
                    kFarthest = node
                }
            }
        }

        return nearest!!.toList()
    }

    fun Pair<Int, Int>.distance(other: Pair<Int, Int>) = (first - other.first) * (first - other.first) + (second - other.second) * (second - other.second)
}