package com.formichelli.dailycodingproblem.day1to100.day1to100.day41to50

/*
Implement a stack that has the following methods:

push(val), which pushes an element onto the stack
pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
Each method should run in constant time.
*/
object Day43 {
    data class MaxStackNode(val value: Int, val maxSoFar: Int, val parent: MaxStackNode?)

    class MaxStack {
        private var head: MaxStackNode? = null

        fun push(value: Int) {
            head = MaxStackNode(value, Math.max(value, head?.maxSoFar
                    ?: 0), head)
        }

        fun pop(): Int {
            val topValue = head?.value ?: throw IllegalStateException("Calling pop on an empty stack")
            head = head?.parent
            return topValue
        }

        fun max(): Int {
            return head?.maxSoFar ?: throw IllegalStateException("Calling max on an empty stack")
        }
    }
}
