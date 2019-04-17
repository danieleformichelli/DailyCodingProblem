package com.formichelli.dailycodingproblem.day101to200.day141to150

import org.junit.Assert
import org.junit.Test

class Day141Test {
    @Test
    fun solution() {
        val threeStack = Day141.MultiStack(3, 5)
        threeStack.push(0, 1)
        threeStack.push(1, 2)
        threeStack.push(2, 3)
        threeStack.push(0, 4)
        threeStack.push(2, 5)


        Assert.assertEquals(4, threeStack.pop(0))
        threeStack.push(2, 10)
        Assert.assertEquals(10, threeStack.pop(2))
        Assert.assertEquals(5, threeStack.pop(2))
        Assert.assertEquals(3, threeStack.pop(2))
        Assert.assertEquals(1, threeStack.pop(0))
        Assert.assertEquals(2, threeStack.pop(1))
    }
}