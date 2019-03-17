package com.formichelli.dailycodingproblem.day101to200.day111to120

import java.util.*

/*
Given a string and a set of delimiters, reverse the words in the string while maintaining the relative order of the delimiters. For example, given "hello/world:here", return "here/world:hello"

Follow-up: Does your solution work for the following cases: "hello/world:here/", "hello//world:here"
*/
object Day114 {
    fun solution(string: String, delimiters: Set<Char>): String {
        var currentIndex = 0
        val splitString = Stack<String>()
        val delimitersList = ArrayList<Char>()
        for (i in 0 until string.length) {
            val charAtI = string[i]
            if (delimiters.contains(charAtI)) {
                delimitersList.add(charAtI)
                if (currentIndex != i) {
                    splitString.push(string.substring(currentIndex, i))
                } else {
                    splitString.add("")
                }
                currentIndex = i + 1
            }
        }
        splitString.push(string.substring(currentIndex))

        val stringBuilder = StringBuilder()
        for (i in 0 until delimitersList.size) {
            stringBuilder.append(splitString.pop())
            stringBuilder.append(delimitersList[i])
        }
        stringBuilder.append(splitString.pop())
        return stringBuilder.toString()
    }
}