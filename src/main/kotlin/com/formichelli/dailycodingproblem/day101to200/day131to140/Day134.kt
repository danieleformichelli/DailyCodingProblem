package com.formichelli.dailycodingproblem.day101to200.day131to140

import java.util.*

/*
You have a large array with most of the elements as zero.

Use a more space-efficient data structure, SparseArray, that implements the same interface:

init(arr, size): initialize with the original large array and size.
set(i, val): updates index at i with val.
get(i): gets the value at index i.
*/
object Day134 {
    class SparseArray(largeArray: IntArray) {
        private val size: Int = largeArray.size
        private val arrayValues = HashMap<Int, Int>()

        init {
            largeArray.forEachIndexed { index, value ->
                if (value != 0) {
                    arrayValues[index] = value
                }
            }
        }

        fun set(i: Int, value: Int) {
            checkIndex(i)

            if (value != 0) {
                arrayValues[i] = value
            } else {
                arrayValues.remove(i)
            }
        }

        fun get(i: Int): Int {
            checkIndex(i)

            return arrayValues.getOrDefault(i, 0)
        }

        private fun checkIndex(i: Int) {
            if (i < 0 || i >= size) {
                throw IndexOutOfBoundsException(i)
            }
        }
    }
}