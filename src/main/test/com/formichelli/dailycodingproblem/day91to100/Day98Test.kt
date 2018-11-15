package com.formichelli.dailycodingproblem.day91to100

import com.formichelli.dailycodingproblem.util.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day98Test(private val result: Boolean, private val board: Array<CharArray>, private val word: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val board = arrayOf(
                    charArrayOf('A', 'B', 'C', 'E'),
                    charArrayOf('S', 'F', 'C', 'S'),
                    charArrayOf('A', 'D', 'E', 'E')
            )
            return listOf<Array<Any>>(
                    arrayOf(true, board, "ABCCED"),
                    arrayOf(true, board, "SEE"),
                    arrayOf(false, board, "ABCB"),
                    arrayOf(false, board, "ABCD"),
                    arrayOf(true, board, "ABCESCFSADEE"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Board ${Utils.prettyPrint(board)} ${if (result) "contains" else "does not contain"} $word", result, Day98.solution(board, word))
    }
}