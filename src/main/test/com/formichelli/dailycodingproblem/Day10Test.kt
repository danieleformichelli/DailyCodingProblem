package com.formichelli.dailycodingproblem

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day10Test(private val delays: IntArray) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                    arrayOf<Any>(intArrayOf(2, 4, 6, 2, 50, 5000))
            )
        }
    }

    @Test
    fun solution() {
        val scheduler = Day10.Scheduler()
        scheduler.start()
        for (delay in delays) {
            val functionTime = System.currentTimeMillis() + delay
            scheduler.schedule(delay) {
                val executionTime = System.currentTimeMillis()
                val functionTimeDifference = Math.abs(functionTime - executionTime)
                Assert.assertTrue("Function time execution difference should be less than 100ms: $functionTimeDifference ms", functionTimeDifference < 100)
            }
        }
        scheduler.stopScheduler()
        scheduler.join()
    }
}