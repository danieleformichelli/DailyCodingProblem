package com.formichelli.dailycodingproblem.day101to200.day121to130

import com.formichelli.dailycodingproblem.util.ListNode

/*
Let's represent an integer in a linked list format by having each node represent a digit in the number. The nodes make up the number in reversed order.

For example, the following linked list:

1 -> 2 -> 3 -> 4 -> 5
is the number 54321.

Given two linked lists in this format, return their sum in the same linked list format.

For example, given

9 -> 9
5 -> 2
return 124 (99 + 25) as:

4 -> 2 -> 1
*/
object Day127 {
    fun solution(a: ListNode<Int>, b: ListNode<Int>): ListNode<Int> {
        var result: ListNode<Int>? = null
        var currentNode: ListNode<Int>? = null
        var carry = 0
        var currentA: ListNode<Int>? = a
        var currentB: ListNode<Int>? = b

        while (currentA != null || currentB != null) {
            val sum = (currentA?.value ?: 0) + (currentB?.value ?: 0) + carry
            carry = sum / 10
            val nextNode = ListNode(sum % 10, null, currentNode)
            if (currentNode != null) {
                currentNode.next = nextNode
            } else {
                result = nextNode
            }

            currentA = currentA?.next
            currentB = currentB?.next
            currentNode = nextNode
        }

        if (carry != 0) {
            val carryNode = ListNode(carry, null, currentNode)
            currentNode!!.next = carryNode
        }

        return result!!
    }
}