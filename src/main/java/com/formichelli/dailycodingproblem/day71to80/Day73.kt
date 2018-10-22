package com.formichelli.dailycodingproblem.day71to80

import com.formichelli.dailycodingproblem.util.ListNode

/*
Given the head of a singly linked list, reverse it in-place.
*/
object Day73 {
    fun <T> solution(head: ListNode<T>): ListNode<T> {
        var currentNode = head
        var nextNode = head.next
        head.next = null
        while (nextNode != null) {
            val tmp = nextNode.next
            nextNode.next = currentNode
            currentNode = nextNode
            nextNode = tmp
        }
        return currentNode
    }
}
