package com.formichelli.dailycodingproblem.day101to200.day131to140

/*
Implement a bit array.

A bit array is a space efficient array that holds a value of 1 or 0 at each index.

init(size): initialize the array with size
set(i, val): updates index at i with val where val is either 1 or 0.
get(i): gets the value at index i.
*/
object Day137 {
    class BitArray(val size: Int) {
        val array = LongArray(size / Long.SIZE_BITS)

        fun set(i: Int, set: Boolean) {
            checkBounds(i)
            val (index, mask) = indexAndMask(i)
            if (set) {
                array[index] = array[index].or(mask)
            } else {
                array[index] = array[index].and(mask.inv())
            }
        }

        fun get(i: Int): Boolean {
            checkBounds(i)
            val (index, mask) = indexAndMask(i)
            return array[index].and(mask) != 0L
        }

        private fun checkBounds(i: Int) {
            if (i < 0 || i > size) {
                throw IndexOutOfBoundsException(i)
            }
        }

        private fun indexAndMask(i: Int): Pair<Int, Long> {
            val index = i / Int.SIZE_BITS
            val offsetAtIndex = i % Int.SIZE_BITS
            val mask = 1L.shl(offsetAtIndex)
            return Pair(index, mask)
        }
    }
}