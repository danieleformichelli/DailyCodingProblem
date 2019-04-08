package com.formichelli.dailycodingproblem.day101to200.day131to140

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFailsWith

class Day134Test {
    private lateinit var originalArray: Day134.SparseArray

    @Before
    fun setUp() {
        originalArray = Day134.SparseArray(intArrayOf(0, 0, 0, 0, 0, 10, 2, 0, 0, 0, 0, 0, 0, 0, 0, 3))
    }

    @Test
    fun testGet() {
        Assert.assertEquals("First element is 0", 0, originalArray.get(0))
        Assert.assertEquals("Sixth element is 10", 10, originalArray.get(5))
        Assert.assertEquals("Seventh element is 2", 2, originalArray.get(6))
        Assert.assertEquals("Sixteenth element is 3", 3, originalArray.get(15))
    }

    @Test
    fun testSet() {
        originalArray.set(0, 1234)
        Assert.assertEquals("First element has been set to 1234", 1234, originalArray.get(0))
    }

    @Test
    fun testOutOfBound() {
        assertFailsWith(IndexOutOfBoundsException::class) {
            originalArray.get(-1)
        }

        assertFailsWith(IndexOutOfBoundsException::class) {
            originalArray.get(16)
        }

        assertFailsWith(IndexOutOfBoundsException::class) {
            originalArray.set(-1, 0)
        }

        assertFailsWith(IndexOutOfBoundsException::class) {
            originalArray.set(16, 0)
        }
    }
}