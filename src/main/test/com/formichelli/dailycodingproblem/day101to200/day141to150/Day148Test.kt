package com.formichelli.dailycodingproblem.day101to200.day141to150

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day148Test(private val n: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(2),
                    arrayOf<Any>(3),
                    arrayOf<Any>(4),
                    arrayOf<Any>(5),
                    arrayOf<Any>(10))
        }
    }

    @Test
    fun solution() {
        val codes = Day148.solution(n)
        for (i in 1 until codes.size) {
            // check adjacent elements differ by 1 bit
            val codesXor = codes[i].xor(codes[i - 1])
            Assert.assertEquals(0, codesXor.and(codesXor - 1))
        }
        for (i in 0 until 1.shl(n)) {
            // check all numbers are present
            Assert.assertTrue(codes.contains(i))
        }
    }
}