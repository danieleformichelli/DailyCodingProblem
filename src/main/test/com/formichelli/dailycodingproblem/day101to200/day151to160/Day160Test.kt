package com.formichelli.dailycodingproblem.day101to200.day151to160

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day160Test(private val result: Int, private val graph: Array<List<Pair<Int, Int>>>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val graph = Array<MutableList<Pair<Int, Int>>>(8) { ArrayList() }

            /*
               a
              /|\
             b c d
                / \
               e   f
              / \
             g   h
             a-b: 3, a-c: 5, a-d: 8, d-e: 2, d-f: 4, e-g: 1, e-h: 1
             */
            // a
            graph[0].add(Pair(1, 3))
            graph[0].add(Pair(2, 5))
            graph[0].add(Pair(3, 8))

            // d
            graph[3].add(Pair(4, 2))
            graph[3].add(Pair(5, 4))

            // e
            graph[4].add(Pair(6, 1))
            graph[4].add(Pair(7, 1))

            return listOf(arrayOf<Any>(17, graph))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("The length of the longest path of the graph is $result", result, Day160.solution(graph))
    }
}