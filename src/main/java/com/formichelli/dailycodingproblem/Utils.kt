package com.formichelli.dailycodingproblem

object Utils {
    fun <T> prettyPrint(iterable: Collection<T>) = iterable.joinToString(",", "[", "]")
}