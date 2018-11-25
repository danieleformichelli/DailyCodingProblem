package com.formichelli.dailycodingproblem.day1to100.day1to100.day41to50

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day50Test(private val result: Int, private val expression: TreeNode<Char>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val tree1 = TreeNode('*')
            tree1.left = TreeNode('+')
            tree1.left?.left = TreeNode('3')
            tree1.left?.right = TreeNode('2')
            tree1.right = TreeNode('+')
            tree1.right?.left = TreeNode('4')
            tree1.right?.right = TreeNode('5')

            return listOf(
                    arrayOf(45, tree1))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("Result of expression $expression should be $result", result, Day50.solution(expression))
    }
}