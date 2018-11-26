package com.formichelli.dailycodingproblem.day101to200.day101to110

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day103Test(private val result: String, private val string: String, private val characters: Set<Char>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf("aeci", "figehaeci", setOf('a', 'e', 'i')))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("The shortest substring of $string containing all the characters in $characters should be $result", result, Day103.solution(string, characters))
    }
}