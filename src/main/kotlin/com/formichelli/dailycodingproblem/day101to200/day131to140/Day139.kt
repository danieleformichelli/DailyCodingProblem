package com.formichelli.dailycodingproblem.day101to200.day131to140

/*
Given an iterator with methods next() and hasNext(), create a wrapper iterator, PeekableInterface, which also implements peek(). peek shows the next element that would be returned on next().

Here is the interface:

class PeekableInterface(object):
    def __init__(self, iterator):
        pass

    def peek(self):
        pass

    def next(self):
        pass

    def hasNext(self):
        pass
*/
object Day139 {
    class PeekableInterface<T>(private val iterator: Iterator<T>) {
        private var peeked: T? = null

        fun peek(): T {
            if (peeked == null) {
                peeked = next()
            }

            return peeked!!
        }

        fun next(): T {
            if (peeked != null) {
                val peekedValue = peeked!!
                peeked = null
                return peekedValue
            }

            return iterator.next()
        }

        fun hasNext(): Boolean {
            return peeked != null || iterator.hasNext()
        }
    }
}