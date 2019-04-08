package com.formichelli.dailycodingproblem.day101to200.day131to140

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day131Test(private val head: Day131.ListNodeWithRandom<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val head = Day131.ListNodeWithRandom(1)
            val second = Day131.ListNodeWithRandom(2)
            val tail = Day131.ListNodeWithRandom(3)

            head.prev = null
            head.next = second
            head.random = tail

            second.prev = head
            second.next = tail
            second.random = second

            tail.prev = second
            tail.next = null
            tail.random = head

            return listOf(arrayOf<Any>(head))
        }
    }

    @Test
    fun solution() {
        var currentOriginal: Day131.ListNodeWithRandom<Int>? = head
        var currentCloned: Day131.ListNodeWithRandom<Int>? = Day131.solution(head)
        while (currentOriginal != null && currentCloned != null) {
            Assert.assertEquals("Value of each node should be the same", currentOriginal.value, currentCloned.value)
            Assert.assertTrue("Cloned node should be a different object", currentOriginal !== currentCloned)
            Assert.assertEquals("Value of random node should be the same", currentOriginal.random?.value, currentCloned.random?.value)
            Assert.assertTrue("Cloned random node should be a different object", currentOriginal.random !== currentCloned.random)

            currentOriginal = currentOriginal.next
            currentCloned = currentCloned.next
        }
    }
}