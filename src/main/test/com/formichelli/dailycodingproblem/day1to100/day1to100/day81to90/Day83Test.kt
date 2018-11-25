package com.formichelli.dailycodingproblem.day1to100.day1to100.day81to90

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day83Test(private val result: TreeNode<Char>, private val root: TreeNode<Char>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val a = TreeNode('a')
            val b = TreeNode('b')
            val c = TreeNode('c')
            val d = TreeNode('d')
            val e = TreeNode('e')
            val f = TreeNode('f')
            a.left = b
            a.right = c
            b.left = d
            b.right = e
            c.left = f

            val result = TreeNode('a')
            result.left = TreeNode('c')
            result.right = TreeNode('b')
            result.left?.right = TreeNode('f')
            result.right?.left = TreeNode('e')
            result.right?.right = TreeNode('d')

            return listOf<Array<Any>>(arrayOf(result, a))
        }
    }

    @Test
    fun solution() {
        Day83.solution(root)
        Assert.assertEquals("Inverted tree should be $result", result, root)
    }
}