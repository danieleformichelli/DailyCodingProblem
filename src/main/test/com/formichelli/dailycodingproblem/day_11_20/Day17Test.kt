package com.formichelli.dailycodingproblem.day_11_20

import com.formichelli.dailycodingproblem.day_11_20.Day17
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day17Test(private val result: Int, private val fileSystem: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf(32, "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext")
            )
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Maximum path length should be $result", result, Day17.solution(fileSystem))
    }
}