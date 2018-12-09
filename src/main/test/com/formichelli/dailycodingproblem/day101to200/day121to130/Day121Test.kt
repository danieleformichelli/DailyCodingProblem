package com.formichelli.dailycodingproblem.day101to200.day121to130

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day121Test(private val result: Boolean, private val string: String, private val k: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(true, "waterrfetawx", 2),
                    arrayOf(true, "waterrfetawx", 3),
                    arrayOf(false, "waterrfetawx", 1))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$string can be made palindrome by removing at most $k elements", result, Day121.solution(string, k))
    }
}