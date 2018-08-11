package com.formichelli.dailycodingproblem.util

object Utils {
    fun <T> prettyPrint(iterable: Collection<T>) = iterable.joinToString(",", "[", "]")
    fun prettyPrint(intArray: IntArray) = prettyPrint(intArray.toList())
}