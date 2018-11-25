package com.formichelli.dailycodingproblem.day1to100.day1to100.day81to90

/*
Using a read7() method that returns 7 characters from a file, implement readN(n) which reads n characters.

For example, given a file with the content “Hello world”, three read7() returns “Hello w”, “orld” and then “”.
*/
object Day82 {
    class FileReader7(private val fileContent: String) {
        private var currentIndex = 0
        fun read7(): String {
            if (currentIndex >= fileContent.length) {
                return ""
            }

            val nextIndex = Math.min(currentIndex + 7, fileContent.length)
            val ret = fileContent.substring(currentIndex, nextIndex)
            currentIndex = nextIndex
            return ret
        }
    }

    class FileReader(private val fileReader: FileReader7) {
        private var buffer = StringBuffer()
        fun readN(n: Int): String {
            while (buffer.length < n) {
                val read = fileReader.read7()
                if (read.isEmpty()) {
                    break
                }

                buffer.append(read)
            }

            val lastIndexToReturn = Math.min(n, buffer.length)
            val ret = buffer.substring(0, lastIndexToReturn)
            buffer.delete(0, lastIndexToReturn)
            return ret
        }
    }
}
