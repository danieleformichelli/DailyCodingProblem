package com.formichelli.dailycodingproblem.day51to60

import java.util.*

/*
Implement a queue using two stacks. Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods: enqueue, which inserts an element into the queue, and dequeue, which removes it.
*/
object Day53 {
    class Queue<T> {
        private val pushStack = Stack<T>()
        private val popStack = Stack<T>()

        fun enqueue(item: T) {
            while (!popStack.isEmpty()) {
                pushStack.push(popStack.pop())
            }

            pushStack.push(item)
        }

        fun dequeue(): T? {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop())
            }

            return popStack.pop()
        }
    }
}
