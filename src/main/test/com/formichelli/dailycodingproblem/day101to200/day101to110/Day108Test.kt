package com.formichelli.dailycodingproblem.day101to200.day101to110

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day108Test(private val result: Boolean, private val A: String, private val B: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(true, "abcde", "cdeab"),
                    arrayOf(false, "abc", "acb"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$A ${if (result) "can" else "cannot"} be shifted to obtain $B", result, Day108.solution(A, B))
    }
}