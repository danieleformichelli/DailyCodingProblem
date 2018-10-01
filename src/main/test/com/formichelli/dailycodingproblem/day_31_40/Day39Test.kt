package com.formichelli.dailycodingproblem.day_31_40

import com.formichelli.dailycodingproblem.day_31_40.Day39
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day39Test(private val liveCellsEnd: Set<Pair<Int, Int>>, private val liveCellsStart: Set<Pair<Int, Int>>, private val steps: Int) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(setOf<Pair<Int, Int>>(), setOf<Pair<Int, Int>>(), 1),
                    arrayOf(setOf(Pair(1, 1), Pair(1, 2), Pair(2, 1), Pair(2, 2)), setOf(Pair(1, 1), Pair(1, 2), Pair(2, 1)), 1),
                    arrayOf(setOf(Pair(1, 1), Pair(1, 2), Pair(2, 1), Pair(2, 2)), setOf(Pair(1, 1), Pair(1, 2), Pair(2, 1)), 2),
                    arrayOf(setOf(Pair(2, 1), Pair(2, 3), Pair(3, 2), Pair(3, 3), Pair(4, 2)), setOf(Pair(1, 2), Pair(2, 3), Pair(3, 1), Pair(3, 2), Pair(3, 3)), 1),
                    arrayOf(setOf(Pair(2, 3), Pair(3, 1), Pair(3, 3), Pair(4, 2), Pair(4, 3)), setOf(Pair(1, 2), Pair(2, 3), Pair(3, 1), Pair(3, 2), Pair(3, 3)), 2),
                    arrayOf(setOf(Pair(2, 2), Pair(3, 3), Pair(3, 4), Pair(4, 2), Pair(4, 3)), setOf(Pair(1, 2), Pair(2, 3), Pair(3, 1), Pair(3, 2), Pair(3, 3)), 3),
                    arrayOf(setOf(Pair(-1, 2), Pair(-1, 3), Pair(0, 1), Pair(0, 2), Pair(0, 3), Pair(0, 4), Pair(1, 1), Pair(1, 2), Pair(1, 4), Pair(1, 5), Pair(2, 3), Pair(2, 4)), setOf(Pair(0, 1), Pair(0, 2), Pair(0, 3), Pair(0, 4), Pair(1, 0), Pair(1, 4), Pair(2, 4), Pair(3, 0), Pair(3, 3)), 1)
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Board $liveCellsStart should become $liveCellsEnd after $steps steps", liveCellsEnd, Day39.solution(liveCellsStart, steps))
    }
}