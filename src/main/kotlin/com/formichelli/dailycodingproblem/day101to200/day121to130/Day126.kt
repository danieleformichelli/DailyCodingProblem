package com.formichelli.dailycodingproblem.day101to200.day121to130

import com.formichelli.dailycodingproblem.util.ListNode

/*
Write a function that rotates a list by k elements. For example, [1, 2, 3, 4, 5, 6] rotated by two becomes [3, 4, 5, 6, 1, 2]. Try solving this without creating a copy of the list. How many swap or move operations do you need?
*/
object Day126 {
    fun solution(head: ListNode<Int>, k: Int): ListNode<Int> {
        var lastNode = head
        var listSize = 1
        while (lastNode.next != null) {
            lastNode = lastNode.next!!
            ++listSize
        }

        return when {
            k > listSize -> throw IllegalArgumentException("List is shorter than rotation size")
            k == listSize -> head
            else -> {
                var lastAfterRotation = head
                for (i in 1 until k) {
                    lastAfterRotation = lastAfterRotation.next!!
                }

                val firstAfterRotation = lastAfterRotation.next
                lastAfterRotation.next = null
                lastNode.next = head
                firstAfterRotation!!
            }
        }
    }
}