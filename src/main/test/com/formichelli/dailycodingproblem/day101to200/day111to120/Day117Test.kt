package com.formichelli.dailycodingproblem.day101to200.day111to120

import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day117Test(private val result: Int, private val root: TreeNode<Int>) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            val root1 = TreeNode(11)
            root1.left = TreeNode(20)
            root1.left?.left = TreeNode(1)
            root1.right = TreeNode(30)
            root1.right?.left = TreeNode(4)
            root1.right?.right = TreeNode(5)
            root1.right?.right?.right = TreeNode(16)
            root1.right?.right?.right?.left = TreeNode(17)

            val root2 = TreeNode(10)
            root2.left = TreeNode(2)
            root2.left?.left = TreeNode(2)
            root2.right = TreeNode(3)
            root2.right?.left = TreeNode(1)
            root2.right?.right = TreeNode(3)
            root2.right?.right?.right = TreeNode(6)
            root2.right?.right?.right?.left = TreeNode(7)

            return listOf<Array<Any?>>(
                    arrayOf(2, root1),
                    arrayOf(1, root2))
        }
    }

    @Test
    fun solution() {
        Assert.assertEquals("The level with the smallest sum should be $result", result, Day117.solution(root))
    }
}