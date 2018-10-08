package com.formichelli.dailycodingproblem.day51to60

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day55Test(private val urls: List<String>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf<Array<Any>>(
                    arrayOf(listOf("12345231", "12345231", "123")))
        }
    }

    @Test
    fun solution() {
        val urlShortener = Day55.UrlShortener(6)
        val shortenerResult = mutableListOf<String>()
        for (url in urls) {
            shortenerResult.add(urlShortener.shorten(url))
        }

        urls.forEachIndexed { index, url ->
            Assert.assertEquals("Short url ${shortenerResult[index]} should map to $url", url, urlShortener.restore(shortenerResult[index]))
        }
    }
}