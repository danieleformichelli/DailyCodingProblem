package com.formichelli.dailycodingproblem.day71to80

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day76Test(private val result: Int, private val letters: Array<CharArray>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(1, arrayOf(charArrayOf('c', 'b', 'a'), charArrayOf('d', 'a', 'f'), charArrayOf('g', 'h', 'i'))),
                    arrayOf(1, arrayOf(charArrayOf('c', 'b', 'a', 'x'), charArrayOf('d', 'a', 'f', 'y'), charArrayOf('g', 'h', 'i', 'z'))),
                    arrayOf(0, arrayOf(charArrayOf('a', 'b', 'z', 'd'))),
                    arrayOf(3, arrayOf(charArrayOf('x', 'y', 'z'), charArrayOf('c', 'b', 'a'), charArrayOf('d', 'a', 'f'), charArrayOf('g', 'h', 'i'))))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$result columns must be removed to lexicographically order ${Utils.prettyPrint(letters)}", result, Day76.solution(letters))
    }
}