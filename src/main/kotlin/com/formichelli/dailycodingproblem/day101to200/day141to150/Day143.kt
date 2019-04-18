package com.formichelli.dailycodingproblem.day101to200.day141to150

import com.formichelli.dailycodingproblem.util.ListNode

/*
Given a pivot x, and a list lst, partition the list into three parts.

The first part contains all elements in lst that are less than x
The second part contains all elements in lst that are equal to x
The third part contains all elements in lst that are larger than x
Ordering within a part can be arbitrary.

For example, given x = 10 and lst = [9, 12, 3, 5, 14, 10, 10], one partition may be `[9, 3, 5, 10, 10, 12, 14].
*/
object Day143 {
    fun solution(numbers: ListNode<Int>, x: Int): ListNode<Int> {
        var smallerFirst: ListNode<Int>? = null
        var smallerLast: ListNode<Int>? = null
        var equalFirst: ListNode<Int>? = null
        var equalLast: ListNode<Int>? = null
        var largerFirst: ListNode<Int>? = null
        var largerLast: ListNode<Int>? = null

        var current: ListNode<Int>? = numbers
        while (current != null) {
            val currentValue = current.value
            val nextNode = current.next
            current.next = null
            when {
                currentValue < x -> {
                    current.prev = smallerLast
                    smallerLast?.next = current
                    smallerLast = current
                    if (smallerFirst == null) {
                        smallerFirst = current
                    }
                }
                currentValue > x -> {
                    current.prev = largerLast
                    largerLast?.next = current
                    largerLast = current
                    if (largerFirst == null) {
                        largerFirst = current
                    }
                }
                else -> {
                    current.prev = equalLast
                    equalLast?.next = current
                    equalLast = current
                    if (equalFirst == null) {
                        equalFirst = current
                    }
                }
            }
            current = nextNode
        }

        var resultFirst = smallerFirst
        var resultLast = smallerLast
        if (equalFirst != null) {
            if (resultFirst != null) {
                resultLast?.next = equalFirst
                equalFirst.prev = resultLast
            } else {
                resultFirst = equalFirst
            }
            resultLast = equalLast
        }
        if (largerFirst != null) {
            if (resultFirst != null) {
                resultLast?.next = largerFirst
                largerFirst.prev = resultLast
            } else {
                resultFirst = largerFirst
            }
        }

        return resultFirst!!
    }
}