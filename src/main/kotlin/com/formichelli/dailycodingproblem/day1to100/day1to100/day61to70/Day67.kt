package com.formichelli.dailycodingproblem.day1to100.day1to100.day61to70

import java.util.*
import kotlin.collections.set

/*
Implement an LFU (Least Frequently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:

set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least frequently used item. If there is a tie, then the least recently used key should be removed.
get(key): gets the value at key. If no such key exists, return null.
Each operation should run in O(1) time.
*/
object Day67 {
    class LFUCache<T>(private val maxSize: Int) {
        private val values = HashMap<String, T>()
        private val counts = HashMap<String, Int>()
        private val levels = HashMap<Int, MutableList<String>>()
        var minCount = 0

        fun set(key: String, value: T) {
            if (values.containsKey(key)) {
                // already exists, update value and frequency
                values[key] = value
                get(key)
                return
            }

            if (values.size == maxSize) {
                // cache is full, remove first of last level
                val firstInLevel = levels[minCount]!!.removeAt(0)
                values.remove(firstInLevel)
                counts.remove(firstInLevel)
            }

            // att to level with frequency 1
            values[key] = value
            counts[key] = 1
            minCount = 1
            levels.computeIfAbsent(1) { LinkedList() }.add(key)
        }

        fun get(key: String): T? {
            // increase count for item
            val count = counts[key] ?: return null
            counts[key] = count + 1

            // move to the next level
            val level = levels[count]!!
            level.remove(key)
            if (count == minCount && level.isEmpty()) {
                ++minCount
            }
            levels.computeIfAbsent(count + 1) { LinkedList() }.add(key)

            return values[key]
        }
    }
}
