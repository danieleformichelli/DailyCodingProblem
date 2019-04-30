package com.formichelli.dailycodingproblem.day101to200.day161to170

/*
Implement a 2D iterator class. It will be initialized with an array of arrays, and should implement the following methods:

next(): returns the next element in the array of arrays. If there are no more elements, raise an exception.
has_next(): returns whether or not the iterator still has elements left.
For example, given the input [[1, 2], [3], [], [4, 5, 6]], calling next() repeatedly should output 1, 2, 3, 4, 5, 6.
*/
object Day166 {
    class Iterator2D<T>(val values: Array<Array<T>>) {
        private val outerIterator = values.iterator()
        private var innerIterator = outerIterator.next().iterator()

        fun next(): T {
            while (!innerIterator.hasNext()) {
                innerIterator = outerIterator.next().iterator()
            }

            return innerIterator.next()
        }

        fun hasNext(): Boolean {
            while (!innerIterator.hasNext()) {
                if (outerIterator.hasNext()) {
                    innerIterator = outerIterator.next().iterator()
                } else {
                    return false
                }
            }

            return true
        }
    }
}