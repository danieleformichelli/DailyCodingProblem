package com.formichelli.dailycodingproblem.day101to200.day131to140

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFailsWith

class Day137Test {
    private lateinit var bitArray: Day137.BitArray

    @Before
    fun setUp() {
        bitArray = Day137.BitArray(1000000)
    }

    @Test
    fun testSetAndGet() {
        bitArray.set(123, true)
        Assert.assertEquals("Element 123 has been set to true", true, bitArray.get(123))
        bitArray.set(123, false)
        Assert.assertEquals("Element 123 has been set to false", false, bitArray.get(123))
        Assert.assertEquals("Element 0 has never been set", false, bitArray.get(0))
    }

    @Test
    fun testOutOfBound() {
        assertFailsWith(IndexOutOfBoundsException::class) {
            bitArray.get(-1)
        }

        assertFailsWith(IndexOutOfBoundsException::class) {
            bitArray.get(bitArray.size)
        }

        assertFailsWith(IndexOutOfBoundsException::class) {
            bitArray.set(-1, false)
        }

        assertFailsWith(IndexOutOfBoundsException::class) {
            bitArray.set(bitArray.size, true)
        }
    }
}