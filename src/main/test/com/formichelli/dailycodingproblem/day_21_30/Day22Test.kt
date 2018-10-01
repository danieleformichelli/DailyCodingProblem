package com.formichelli.dailycodingproblem.day_21_30

import com.formichelli.dailycodingproblem.day_21_30.Day22
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day22Test(private val result: List<String>, private val dictionary: Set<String>, private val sentence: String) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(arrayOf(listOf("the", "quick", "brown", "fox"), setOf("quick", "brown", "the", "fox"), "thequickbrownfox"),
                    arrayOf(listOf("bedbath", "and", "beyond"), setOf("bed", "baths", "bedbath", "and", "beyond"), "bedbathandbeyond"),
                    arrayOf(listOf("bed", "baths", "and", "beyond"), setOf("bed", "baths", "bedbath", "and", "beyond"), "bedbathsandbeyond"))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("$sentence is composed of $result", result, Day22.solution(dictionary, sentence))
    }
}