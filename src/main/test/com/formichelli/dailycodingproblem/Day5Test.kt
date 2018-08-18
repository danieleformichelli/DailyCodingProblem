package com.formichelli.dailycodingproblem

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day5Test(private val a: Int, private val b: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(1, 2),
                    arrayOf<Any>(2, 3),
                    arrayOf<Any>(3, 4),
                    arrayOf<Any>(-13, 203)
            )
        }
    }

    @Test
    fun car() {
        val pair = Day5.cons(a, b)
        Assert.assertEquals(String.format("car should return %d", a), a, Day5.car(pair))
    }

    @Test
    fun cdr() {
        val pair = Day5.cons(a, b)
        Assert.assertEquals(String.format("cdr should return %d", b), b, Day5.cdr(pair))
    }
}