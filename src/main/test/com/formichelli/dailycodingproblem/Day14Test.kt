package com.formichelli.dailycodingproblem

import org.junit.Assert
import org.junit.Test

class Day14Test {
    @Test
    fun solution() {
        Assert.assertEquals("Approximated value should be equals to pi up to 3 decimal digits", Math.PI, Day14.solution(), 0.001)
    }
}