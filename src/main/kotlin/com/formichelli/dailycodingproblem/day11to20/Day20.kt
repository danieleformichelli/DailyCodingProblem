package com.formichelli.dailycodingproblem.day11to20

import com.formichelli.dailycodingproblem.util.ListNode

/*
Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
*/
object Day20 {
    // This solution assumes we can modify the lists
    fun solution(listA: ListNode<Int>, listB: ListNode<Int>): ListNode<Int>? {
        // if the 2 lists intersect, the intersection point will be at the same distance from the end

        // O(M)
        val listALength = listA.length()
        // O(N)
        val listBLength = listB.length()

        // move the pointers to be at the same distance from the end
        // O(M-N)
        var listAPointer: ListNode<Int>? = listA
        var listBPointer: ListNode<Int>? = listB
        if (listALength > listBLength) {
            for (i in 0 until listALength - listBLength) {
                listAPointer = listAPointer?.next
            }
        } else {
            for (i in 0 until listBLength - listALength) {
                listBPointer = listBPointer?.next
            }
        }

        // O(N-M)
        // move the pointers together and compare the nodes
        while (true) {
            if (listAPointer == listBPointer) {
                return listAPointer
            }

            listAPointer = listAPointer?.next
            listBPointer = listBPointer?.next
        }
    }
}
