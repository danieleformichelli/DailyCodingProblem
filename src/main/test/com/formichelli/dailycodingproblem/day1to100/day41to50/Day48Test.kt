package com.formichelli.dailycodingproblem.day1to100.day41to50

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day48Test(private val result: TreeNode<Char>, private val preOrder: List<Char>, private val inOrder: List<Char>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            val tree1 = TreeNode('a')
            tree1.left = TreeNode('b')
            tree1.left?.left = TreeNode('d')
            tree1.left?.right = TreeNode('e')
            tree1.right = TreeNode('c')
            tree1.right?.left = TreeNode('f')
            tree1.right?.right = TreeNode('g')

            val tree2 = TreeNode('a')
            tree2.left = TreeNode('b')
            tree2.left?.right = TreeNode('e')
            tree2.right = TreeNode('c')
            tree2.right?.left = TreeNode('f')
            tree2.right?.right = TreeNode('g')

            val tree3 = TreeNode('a')
            tree3.left = TreeNode('b')
            tree3.left?.left = TreeNode('d')
            tree3.right = TreeNode('c')
            tree3.right?.left = TreeNode('f')
            tree3.right?.right = TreeNode('g')

            val tree4 = TreeNode('a')
            tree4.left = TreeNode('b')
            tree4.left?.left = TreeNode('d')
            tree4.left?.right = TreeNode('e')
            tree4.right = TreeNode('c')
            tree4.right?.left = TreeNode('f')

            val tree5 = TreeNode('a')
            tree5.left = TreeNode('b')
            tree5.left?.left = TreeNode('d')
            tree5.left?.right = TreeNode('e')
            tree5.right = TreeNode('c')
            tree5.right?.right = TreeNode('g')

            return listOf(
                    arrayOf(tree1, listOf('a', 'b', 'd', 'e', 'c', 'f', 'g'), listOf('d', 'b', 'e', 'a', 'f', 'c', 'g')),
                    arrayOf(tree2, listOf('a', 'b', 'e', 'c', 'f', 'g'), listOf('b', 'e', 'a', 'f', 'c', 'g')),
                    arrayOf(tree3, listOf('a', 'b', 'd', 'c', 'f', 'g'), listOf('d', 'b', 'a', 'f', 'c', 'g')),
                    arrayOf(tree4, listOf('a', 'b', 'd', 'e', 'c', 'f'), listOf('d', 'b', 'e', 'a', 'f', 'c')),
                    arrayOf(tree5, listOf('a', 'b', 'd', 'e', 'c', 'g'), listOf('d', 'b', 'e', 'a', 'c', 'g')))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("PreOrder $preOrder and InOrder $inOrder should map to $result", result, Day48.solution(preOrder, inOrder))
    }
}