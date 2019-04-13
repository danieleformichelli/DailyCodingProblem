package com.formichelli.dailycodingproblem.day101to200.day131to140

import org.junit.Assert
import org.junit.Test
import kotlin.test.assertFailsWith

class Day139Test {
    @Test
    fun solution() {
        val numbers = listOf(1, 2, 3, 4, 5)
        val peekable = Day139.PeekableInterface(numbers.iterator())

        for (i in 0 until numbers.size) {
            Assert.assertEquals("At ith iteration, has next should return true", true, peekable.hasNext())
            Assert.assertEquals("At ith iteration, peek should return ${numbers[i]}", numbers[i], peekable.peek())
            Assert.assertEquals("At ith iteration, has next should return true", true, peekable.hasNext())
            Assert.assertEquals("At ith iteration, next should return ${numbers[i]}", numbers[i], peekable.next())
        }

        Assert.assertEquals("Has next should return false", false, peekable.hasNext())
        assertFailsWith(NoSuchElementException::class) {
            peekable.peek()
        }
        assertFailsWith(NoSuchElementException::class) {
            peekable.next()
        }
    }
}