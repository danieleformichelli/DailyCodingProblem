package com.formichelli.dailycodingproblem.day_1_10

import com.formichelli.dailycodingproblem.day_1_10.Day3
import com.formichelli.dailycodingproblem.util.TreeNode
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class Day3Test(private val root: TreeNode<String>?) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any?>> {
            val rootNode = TreeNode("root")
            val leftNode = TreeNode("left")
            val rightNode = TreeNode("right")
            val leftLeftNode = TreeNode("left.left")
            rootNode.left = leftNode
            rootNode.right = rightNode
            leftNode.left = leftLeftNode

            return listOf(
                    arrayOf<Any?>(rootNode),
                    arrayOf<Any?>(null)
            )
        }
    }

    @Test
    fun serializeDeserialize() {
        Assert.assertEquals("Deserialized tree should be equal to original tree", root, Day3.deserializeTree(Day3.serializeTree(root)))
    }
}