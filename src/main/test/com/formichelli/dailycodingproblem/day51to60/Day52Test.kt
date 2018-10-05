package com.formichelli.dailycodingproblem.day51to60

import org.junit.Assert
import org.junit.Test

class Day52Test {
    @Test
    fun solution() {
        val cacheSize = 10
        val cache = Day52.LRUCache(cacheSize)

        for (i in 1..10) {
            cache.set(i, i)
        }

        for (i in 1..10) {
            Assert.assertEquals("Get of $i should return $i", i, cache.get(i))
        }

        val nextCacheElement = cacheSize + 1
        Assert.assertEquals("Get of $nextCacheElement should return null", null, cache.get(nextCacheElement))

        cache.set(nextCacheElement, nextCacheElement)
        Assert.assertEquals("Get of $nextCacheElement should return $nextCacheElement", nextCacheElement, cache.get(nextCacheElement))

        Assert.assertEquals("Get of 1 should return null", null, cache.get(1))
    }
}