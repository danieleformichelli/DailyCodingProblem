package com.formichelli.dailycodingproblem.day1to100.day21to30

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day29Test(private val encoded: String, private val decoded: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf("4A3B2C1D2A", "AAAABBBCCDAA"),
                    arrayOf("8A", "AAAAAAAA"),
                    arrayOf("1A1B1C1D1E", "ABCDE"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$decoded encoded should be $encoded", encoded, Day29.encode(decoded))
        Assert.assertEquals("$encoded decoded should be $decoded", decoded, Day29.decode(encoded))
    }
}