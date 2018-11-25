package com.formichelli.dailycodingproblem.day1to100.day1to100.day21to30

import com.formichelli.dailycodingproblem.util.ListNode

/*
Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.
*/
object Day26 {
    fun solution(head: ListNode<Int>, k: Int): ListNode<Int> {
        var p: ListNode<Int>? = head
        var q: ListNode<Int>? = head

        for (i in 0..k) {
            if (p == null) {
                if (i == k) {
                    // k == list length
                    return head.next!!
                } else {
                    throw IllegalArgumentException("k ($k) must be smaller than list size")
                }
            } else {
                p = p.next
            }
        }

        while (p != null) {
            p = p.next
            q = q?.next
        }

        q?.next = q?.next?.next
        return head
    }
}
