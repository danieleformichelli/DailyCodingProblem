package com.formichelli.dailycodingproblem.day101to200.day131to140

/*
Given the head to a singly linked list, where each node also has a “random” pointer that points to anywhere in the linked list, deep clone the list.
*/
object Day131 {

    data class ListNodeWithRandom<T>(val value: T, var next: ListNodeWithRandom<T>? = null, var prev: ListNodeWithRandom<T>? = null, var random: ListNodeWithRandom<T>? = null) {
        override fun hashCode(): Int {
            return (value?.hashCode() ?: 0) + (next?.value?.hashCode() ?: 0) + (prev?.value?.hashCode()
                    ?: 0) + (random?.value?.hashCode() ?: 0)
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ListNodeWithRandom<*>

            if (value != other.value) return false
            if (next?.value != other.next?.value) return false
            if (prev?.value != other.prev?.value) return false
            if (random?.value != other.random?.value) return false

            return true
        }
    }

    fun <T> solution(head: ListNodeWithRandom<T>): ListNodeWithRandom<T>? {
        var clonedHead: ListNodeWithRandom<T>? = null
        var clonedTail: ListNodeWithRandom<T>? = null
        val oldToNew = HashMap<ListNodeWithRandom<T>, ListNodeWithRandom<T>>()

        var current: ListNodeWithRandom<T>? = head
        while (current != null) {
            val newNode = ListNodeWithRandom(current.value, clonedTail, null, current.random)
            oldToNew[current] = newNode

            if (clonedHead == null) {
                clonedHead = newNode
            }
            clonedTail = newNode
            current = current.next
        }

        current = clonedHead
        while (current != null) {
            current.random = oldToNew[current.random]
            current = current.next
        }

        return clonedHead
    }
}