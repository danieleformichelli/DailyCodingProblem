package com.formichelli.dailycodingproblem.day1to100.day1to100.day61to70

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day63Test(private val result: Boolean, private val characters: Array<CharArray>, private val targetWord: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val characters = arrayOf(
                    charArrayOf('F', 'A', 'C', 'I'),
                    charArrayOf('O', 'B', 'Q', 'P'),
                    charArrayOf('A', 'N', 'O', 'B'),
                    charArrayOf('M', 'A', 'S', 'S'))
            return listOf<Array<Any>>(
                    arrayOf(true, characters, "FACI"),
                    arrayOf(true, characters, "FAC"),
                    arrayOf(true, characters, "ACI"),
                    arrayOf(true, characters, "MASS"),
                    arrayOf(true, characters, "IPBS"),
                    arrayOf(true, characters, "FOAM"),
                    arrayOf(false, characters, "MASSA"),
                    arrayOf(false, characters, "ACID"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$targetWord ${if (result) "should" else "should not"} be found in matrix", result, Day63.solution(characters, targetWord))
    }
}