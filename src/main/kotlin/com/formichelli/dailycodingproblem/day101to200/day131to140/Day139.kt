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
    class PeekableInterface<T>(val iterator: Iterator<T>) {
        fun peek(): T {
            TODO("not implemented")
        }

        fun next(): T {
            TODO("not implemented")
        }

        fun hasNext(): T {
            TODO("not implemented")
        }
    }
}