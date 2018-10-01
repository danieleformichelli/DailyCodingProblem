package com.formichelli.dailycodingproblem.day31to40

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day35Test(private val result: CharArray, private val chars: CharArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(charArrayOf('R', 'R', 'R', 'G', 'G', 'B', 'B'), charArrayOf('G', 'B', 'R', 'R', 'B', 'R', 'G')),
                    arrayOf(charArrayOf('R', 'R', 'R', 'G', 'G', 'G', 'B'), charArrayOf('G', 'R', 'R', 'G', 'R', 'B', 'G')))
        }
    }

    @Test
    fun solution() {
        Day35.solution(chars)
        Assert.assertArrayEquals("Segregating ${Utils.prettyPrint(chars)} should give ${Utils.prettyPrint(result)}", result, chars)
    }
}