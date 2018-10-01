package com.formichelli.dailycodingproblem.day_1_10

import java.util.*
import java.util.concurrent.TimeUnit

/*
Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
*/
object Day10 {
    class Scheduler : Thread() {
        companion object {
            const val NO_SCHEDULED_FUNCTIONS = Long.MAX_VALUE
        }

        private val scheduledFunctions: TreeMap<Long, () -> Unit> = TreeMap()
        private var isStopped = false
        private var nextExecutionTime = NO_SCHEDULED_FUNCTIONS
        private val lock = Object()

        fun schedule(n: Int, f: () -> Unit) {
            synchronized(lock) {
                val executionTime = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(n.toLong())
                scheduledFunctions[executionTime] = f
                if (executionTime < nextExecutionTime) {
                    nextExecutionTime = executionTime
                }
                lock.notify()
                // interrupt to wakeup in case it is sleeping
                this.interrupt()
            }
        }

        fun stopScheduler() {
            isStopped = true
            this.interrupt()
        }

        override fun run() {
            synchronized(lock) {
                while (!isStopped || nextExecutionTime != NO_SCHEDULED_FUNCTIONS) {
                    try {
                        if (nextExecutionTime == NO_SCHEDULED_FUNCTIONS) {
                            lock.wait()
                        } else {
                            val sleepTime = TimeUnit.NANOSECONDS.toMillis(nextExecutionTime - System.nanoTime())

                            if (sleepTime > 0) {
                                sleep(sleepTime)
                            } else {
                                val f = scheduledFunctions.pollFirstEntry().value
                                f()
                                nextExecutionTime = if (scheduledFunctions.size > 0) scheduledFunctions.firstKey() else NO_SCHEDULED_FUNCTIONS
                            }
                        }
                    } catch (ignored: InterruptedException) {
                    }
                }
            }
        }
    }
}
