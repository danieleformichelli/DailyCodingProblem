package com.formichelli.dailycodingproblem.day101to200.day161to170

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertFailsWith

@RunWith(Parameterized::class)
class Day166Test(private val result: Array<Int>, private val numbers: Array<Array<Int>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(arrayOf(1, 2, 3, 4, 5, 6), arrayOf(arrayOf(1, 2), arrayOf(3), arrayOf(), arrayOf(4, 5, 6))))
        }
    }

    @Test
    fun solution() {
        val iterator = Day166.Iterator2D(numbers)
        for (i in 0 until result.size) {
            Assert.assertEquals("hasNext() is true", true, iterator.hasNext())
            Assert.assertEquals("hasNext() is true", true, iterator.hasNext())
            Assert.assertEquals("next() is ${result[i]}", result[i], iterator.next())
        }
        Assert.assertEquals("hasNext() is true", false, iterator.hasNext())
        assertFailsWith(NoSuchElementException::class) {
            iterator.next()
        }
    }
}