package com.formichelli.dailycodingproblem.util

object Utils {
    fun prettyPrint(intArray: IntArray) = intArray.toList().toString()
    fun prettyPrint(intMatrix: Array<IntArray>) = intMatrix.map { prettyPrint(it) }.joinToString("\n")
    fun prettyPrint(charArray: CharArray) = charArray.toList().toString()
    fun minOf(vararg numbers: Int) = numbers.min() ?: Int.MAX_VALUE
}