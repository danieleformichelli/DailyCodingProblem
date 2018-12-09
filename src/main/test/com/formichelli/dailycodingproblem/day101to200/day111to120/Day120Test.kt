package com.formichelli.dailycodingproblem.day101to200.day111to120

import org.junit.Assert
import org.junit.Test

class Day120Test {
    @Test
    fun solution() {
        val oddInstance = Day120.Doubleton.getInstance()
        val evenInstance = Day120.Doubleton.getInstance()

        for (i in 1..100) {
            if (i % 2 == 1) {
                Assert.assertEquals("Odd invocation should return odd instance", oddInstance, Day120.Doubleton.getInstance())
            } else {
                Assert.assertEquals("Even invocation should return even instance", evenInstance, Day120.Doubleton.getInstance())
            }
        }
    }
}