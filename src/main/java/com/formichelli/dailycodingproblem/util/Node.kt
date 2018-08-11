package com.formichelli.dailycodingproblem.util

data class Node<T>(val value: T, val left: Node<T>? = null, val right: Node<T>? = null)