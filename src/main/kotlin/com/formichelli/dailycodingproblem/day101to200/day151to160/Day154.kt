package com.formichelli.dailycodingproblem.day101to200.day151to160

import java.util.*

/*
Implement a stack API using only a heap. A stack implements the following methods:
push(item), which adds an element to the stack
pop(), which removes and returns the most recently added element (or throws an error if there is nothing on the stack)

Recall that a heap has the following operations:
push(item), which adds a new key to the heap
pop(), which removes and returns the max value of the heap
*/
object Day154 {
    class Stack<T> {
        private var id = 0
        private val heap = PriorityQueue<Pair<Int, T>>(Comparator.comparingInt { -it.first })

        fun push(value: T) {
            heap.add(Pair(++id, value))
        }

        fun pop() = heap.remove().second
    }
}