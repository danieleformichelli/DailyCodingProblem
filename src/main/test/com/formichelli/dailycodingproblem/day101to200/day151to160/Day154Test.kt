package com.formichelli.dailycodingproblem.day101to200.day151to160

import org.junit.Assert
import org.junit.Test

class Day154Test {
    @Test
    fun solution() {
        val stack = Day154.Stack<Int>()
        for (i in 1..5) {
            stack.push(i)
        }

        for (i in 5 downTo 1) {
            Assert.assertEquals("Pop should return $i", i, stack.pop())
        }
    }
}