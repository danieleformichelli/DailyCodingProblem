package com.formichelli.dailycodingproblem.day101to200.day141to150

import com.formichelli.dailycodingproblem.util.ListNode

/*
Given the head of a singly linked list, swap every two nodes and return its head.

For example, given 1 -> 2 -> 3 -> 4, return 2 -> 1 -> 4 -> 3.
*/
object Day145 {
    fun <T> solution(list: ListNode<T>): ListNode<T> {
        return solutionHelper(list)!!
    }

    private fun <T> solutionHelper(list: ListNode<T>?): ListNode<T>? {
        if (list == null) {
            return null
        }

        if (list.next == null) {
            return list
        }

        val remaining = solutionHelper(list.next)

        val first = list.next
        val second = list

        first?.next = second
        second.prev = first

        second.next = remaining
        remaining?.prev = second

        return first
    }
}