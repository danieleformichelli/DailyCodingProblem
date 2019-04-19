package com.formichelli.dailycodingproblem.day101to200.day151to160

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day151Test(private val result: Array<CharArray>, private val image: Array<CharArray>, private val pixel: Pair<Int, Int>, private val color: Char) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val image = arrayOf(
                    charArrayOf('B', 'B', 'W'),
                    charArrayOf('W', 'W', 'W'),
                    charArrayOf('W', 'W', 'W'),
                    charArrayOf('B', 'B', 'B'))

            val result = arrayOf(
                    charArrayOf('B', 'B', 'G'),
                    charArrayOf('G', 'G', 'G'),
                    charArrayOf('G', 'G', 'G'),
                    charArrayOf('B', 'B', 'B'))

            return listOf(
                    arrayOf<Any>(result, image, Pair(2, 2), 'G'))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Image ${Utils.prettyPrint(image)} filled with $color at $pixel is ${Utils.prettyPrint(result)}", result, Day151.solution(image, pixel, color))
    }
}