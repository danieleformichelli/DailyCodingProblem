package com.formichelli.dailycodingproblem.day1to100.day71to80

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day80Test(private val result: Char, private val root: TreeNode<Char>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val a = TreeNode('a')
            val b = TreeNode('b')
            val c = TreeNode('c')
            val d = TreeNode('d')
            a.left = b
            a.right = c
            b.left = d

            return listOf(
                    arrayOf('d', TreeNode('d')),
                    arrayOf('d', a))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Deepest node of $root should be $result", result, Day80.solution(root))
    }
}