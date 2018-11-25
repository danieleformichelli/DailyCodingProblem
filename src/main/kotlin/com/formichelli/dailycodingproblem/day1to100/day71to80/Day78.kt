package com.formichelli.dailycodingproblem.day1to100.day71to80

import com.formichelli.dailycodingproblem.util.ListNode
import java.util.*

/*
Given k sorted singly linked lists, write a function to merge all the lists into one sorted singly linked list.
*/
object Day78 {
    fun <T : Comparable<T>> solution(lists: List<ListNode<T>>): ListNode<T>? {
        val currentListsElement = LinkedList(lists)
        var head: ListNode<T>? = null
        var tail: ListNode<T>? = null
        while (!currentListsElement.isEmpty()) {
            var nextItem = currentListsElement.first()
            var nextIndex = 0
            currentListsElement.forEachIndexed { index, value ->
                if (value.value < nextItem.value) {
                    nextItem = value
                    nextIndex = index
                }
            }

            if (head != null) {
                tail?.next = nextItem
                tail = tail?.next
            } else {
                head = nextItem
                tail = head
            }

            currentListsElement[nextIndex] = currentListsElement[nextIndex].next
            if (currentListsElement[nextIndex] == null) {
                currentListsElement.removeAt(nextIndex)
            }
        }

        return head
    }
}
