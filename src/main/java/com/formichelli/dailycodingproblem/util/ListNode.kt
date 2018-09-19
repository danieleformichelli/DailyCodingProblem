package com.formichelli.dailycodingproblem.util

data class ListNode<T>(val value: T, var next: ListNode<T>? = null) {
    fun length(): Int {
        var currentLength = 1
        var p = next
        while (p != null) {
            p = p.next
            ++currentLength
        }

        return currentLength
    }
}