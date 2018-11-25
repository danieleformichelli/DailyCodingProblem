package com.formichelli.dailycodingproblem.day1to100.day1to100.day21to30

/*
Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. There should be at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k. Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 4 extra spaces distributed evenly
*/
object Day28 {
    fun solution(words: List<String>, lineLength: Int): List<String> {
        val lines = mutableListOf<String>()

        var currentLineIndexStart = 0
        var currentLineLength = 0
        words.forEachIndexed { index, word ->
            currentLineLength += word.length + if (currentLineLength != 0) 1 else 0

            if (currentLineLength > lineLength) {
                lines.add(justifyLine(words, currentLineIndexStart, index - 1, lineLength))
                currentLineIndexStart = index
                currentLineLength = word.length
            } else if (currentLineLength == lineLength) {
                lines.add(justifyLine(words, currentLineIndexStart, index, lineLength))
                currentLineIndexStart = index + 1
                currentLineLength = 0
            }
        }

        if (currentLineLength != 0) {
            lines.add(justifyLine(words, currentLineIndexStart, words.lastIndex, lineLength))
        }

        return lines
    }

    private fun justifyLine(words: List<String>, fromIndex: Int, toIndex: Int, lineLength: Int): String {
        val wordsCount = toIndex - fromIndex + 1
        if (wordsCount == 1) {
            return words[fromIndex].padEnd(lineLength, ' ')
        }

        var wordsTotalSize = 0
        for (i in fromIndex..toIndex) {
            wordsTotalSize += words[i].length
        }


        val totalSpacesCount = lineLength - wordsTotalSize
        val baseSpacingSize = totalSpacesCount / (wordsCount - 1)
        val spareSpaces = totalSpacesCount - (wordsCount - 1) * baseSpacingSize
        val baseSpacing = " ".repeat(baseSpacingSize)

        val lineBuilder = StringBuilder(words[fromIndex])
        for (i in 1 until wordsCount) {
            lineBuilder.append(baseSpacing)
            if (i <= spareSpaces) {
                lineBuilder.append(' ')
            }
            lineBuilder.append(words[fromIndex + i])
        }

        return lineBuilder.toString()
    }
}
