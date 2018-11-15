package com.formichelli.dailycodingproblem.day91to100

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

data class Test97Input(val getOrSet: Boolean, val key: Int, val value: Int?, val time: Int)

@RunWith(Parameterized::class)
class Day97Test(private val result: List<Int?>, private val inputs: List<Test97Input>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(
                            listOf(1, 2, null, 1, 2), listOf(
                            Test97Input(false, 1, 1, 0),
                            Test97Input(false, 1, 2, 2),
                            Test97Input(true, 1, 1, 1),
                            Test97Input(true, 1, 1, 3),
                            Test97Input(false, 1, 1, 5),
                            Test97Input(true, 1, null, -1),
                            Test97Input(true, 1, 1, 10),
                            Test97Input(false, 1, 1, 0),
                            Test97Input(false, 1, 2, 0),
                            Test97Input(true, 1, 2, 0)
                    )))
        }
    }

    @Test
    fun solution() {
        val timeMap = Day97.TimeMap<Int, Int>()
        var resultsIndex = 0
        inputs.forEach {
            if (it.getOrSet) {
                Assert.assertEquals("get(${it.key}, ${it.time}) should return ${it.value}", result[resultsIndex++], timeMap.get(it.key, it.time))
            } else {
                timeMap.set(it.key, it.value!!, it.time)
            }
        }
    }
}