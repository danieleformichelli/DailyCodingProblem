package com.formichelli.dailycodingproblem.day101to200.day121to130

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day124Test(private val result: Boolean, private val n: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(3, 100))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Flipping $n coins it will remain only one coin after about $result rounds", result, Day124.solution(n))
    }
}