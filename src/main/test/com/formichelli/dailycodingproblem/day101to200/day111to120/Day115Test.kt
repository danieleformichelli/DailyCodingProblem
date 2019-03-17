package com.formichelli.dailycodingproblem.day101to200.day111to120

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day115Test(private val result: Boolean, private val s: TreeNode<Int>, private val t: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            val root = TreeNode(1)
            root.left = TreeNode(2)
            root.right = TreeNode(3)
            root.right?.left = TreeNode(4)
            root.right?.right = TreeNode(5)
            root.right?.right?.right = TreeNode(6)
            root.right?.right?.right?.left = TreeNode(7)

            val anotherRoot = TreeNode(3)
            anotherRoot.left = TreeNode(4)
            anotherRoot.right = TreeNode(5)
            anotherRoot.right?.right = TreeNode(6)
            anotherRoot.right?.right?.left = TreeNode(7)
            anotherRoot.right?.right?.right = TreeNode(8)

            return listOf<Array<Any?>>(
                    arrayOf(true, root, root),
                    arrayOf(true, root, root.right),
                    arrayOf(false, root, anotherRoot))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("t ${if (result) "is" else "is not"} a subtree of s", result, Day115.solution(s, t))
    }
}