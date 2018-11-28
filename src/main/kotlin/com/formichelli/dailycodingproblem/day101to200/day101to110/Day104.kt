package com.formichelli.dailycodingproblem.day101to200.day101to110

import com.formichelli.dailycodingproblem.util.ListNode

/*
Determine whether a doubly linked list is a palindrome. What if it’s singly linked?

For example, 1 -> 4 -> 3 -> 4 -> 1 returns true while 1 -> 4 returns false.
*/
object Day104 {
    fun solution(list: ListNode<Int>): Boolean {
        // assume singly linked
        return solutionHelper(list, list) != null
    }

    private fun solutionHelper(currentNode: ListNode<Int>?, head: ListNode<Int>): ListNode<Int>? {
        if (currentNode == null) {
            return head
        }


        val nodeToCompareWith = solutionHelper(currentNode.next, head)
        return if (currentNode.value == nodeToCompareWith?.value) {
            if (nodeToCompareWith.next == null) {
                // completed, return non null to notify success
                return ListNode(Int.MAX_VALUE)
            } else {
                nodeToCompareWith.next
            }
        } else {
            null
        }
    }
}