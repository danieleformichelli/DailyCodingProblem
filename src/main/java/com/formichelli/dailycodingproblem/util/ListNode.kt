package com.formichelli.dailycodingproblem.util

data class ListNode<T>(val value: T, var next: ListNode<T>? = null) {
    companion object {
        fun <T> fromList(list: List<T>): ListNode<T> {
            val head = ListNode(list.first())
            var tail = head
            list.stream().skip(1).forEach {
                tail.next = ListNode(it)
                tail = tail.next!!
            }

            return head
        }
    }

    fun length(): Int {
        var currentLength = 1
        var p = next
        while (p != null) {
            p = p.next
            ++currentLength
        }

        return currentLength
    }

    fun toList(): List<T> {
        val list = ArrayList<T>()
        var p: ListNode<T>? = this
        while (p != null) {
            list.add(p.value)
            p = p.next
        }

        return list
    }
}