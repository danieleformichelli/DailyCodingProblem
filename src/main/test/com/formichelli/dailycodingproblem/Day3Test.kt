package com.formichelli.dailycodingproblem

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
            return listOf(
                    arrayOf<Any?>(TreeNode("root", TreeNode("left", TreeNode("left.left")), TreeNode("right"))),
                    arrayOf<Any?>(null)
            )
        }
    }

    @Test
    fun serializeDeserialize() {
        Assert.assertEquals("Deserialized tree should be equal to original tree", root, Day3.deserializeTree(Day3.serializeTree(root)))
    }
}