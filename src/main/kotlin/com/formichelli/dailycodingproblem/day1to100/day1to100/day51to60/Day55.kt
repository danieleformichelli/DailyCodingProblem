package com.formichelli.dailycodingproblem.day1to100.day1to100.day51to60

import java.util.*
import kotlin.math.roundToInt

/*
Implement a URL shortener with the following methods:

shorten(url), which shortens the url into a six-character alphanumeric string, such as zLg6wl.
restore(short), which expands the shortened string into the original url. If no such shortened string exists, return null.
Hint: What if we enter the same URL twice?
*/
object Day55 {
    class UrlShortener(shortenedLength: Int) {
        private val shortUrlToUrl = HashMap<String, String>()
        private val alphabet = CharArray(('z' - 'a' + 1) * 2 + 10)
        private val dictionarySize = Math.pow(alphabet.size.toDouble(), shortenedLength.toDouble()).roundToInt()

        init {
            var i = 0
            for (c in 'a'..'z') {
                alphabet[i++] = c
            }
            for (c in 'A'..'Z') {
                alphabet[i++] = c
            }
            for (c in '0'..'9') {
                alphabet[i++] = c
            }
        }

        fun shorten(url: String): String {
            var shortUrl: String
            var clashCount = 0
            do {
                val shortenedUrlBuilder = StringBuilder()
                var hash = Math.abs(url.hashCode() + clashCount++) % dictionarySize
                while (hash != 0) {
                    shortenedUrlBuilder.append(alphabet[hash % alphabet.size])
                    hash /= alphabet.size
                }

                shortUrl = shortenedUrlBuilder.toString()
            } while (shortUrlToUrl[shortUrl] != null && shortUrlToUrl[shortUrl] != url)

            shortUrlToUrl[shortUrl] = url
            return shortUrl
        }

        fun restore(shortUrl: String): String? {
            return shortUrlToUrl[shortUrl]
        }
    }
}
