package com.formichelli.dailycodingproblem.day101to200.day141to150

import org.junit.Assert
import org.junit.Test

class Day144Test {
    @Test
    fun solution() {
        val numbers = intArrayOf(4, 1, 3, 5, 6)
        Assert.assertEquals(3, Day144.solution(numbers, 0))
        Assert.assertEquals(0, Day144.solution(numbers, 1))
        Assert.assertEquals(3, Day144.solution(numbers, 2))
        Assert.assertEquals(4, Day144.solution(numbers, 3))
        Assert.assertEquals(null, Day144.solution(numbers, 4))
    }
}