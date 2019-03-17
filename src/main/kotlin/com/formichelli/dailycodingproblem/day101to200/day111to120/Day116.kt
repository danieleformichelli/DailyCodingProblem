package com.formichelli.dailycodingproblem.day101to200.day111to120

import com.formichelli.dailycodingproblem.util.TreeNode
import java.util.*

/*
Generate a finite, but an arbitrarily large binary tree quickly in O(1).

That is, generate() should return a tree whose size is unbounded but finite.
*/
object Day116 {
    fun solution(): TreeNode<Int> {
        return Day116.LazyTreeNode()
    }

    class LazyTreeNode : TreeNode<Int>(Random().nextInt()) {
        var leftGenerated = false
        var rightGenerated = false

        override var left: TreeNode<Int>? = null
            get() {
                if (!leftGenerated) {
                    left = if (Random().nextBoolean()) LazyTreeNode() else null
                }

                return super.left
            }
            set(value) {
                leftGenerated = true
                field = value
                value?.parent = this
            }

        override var right: TreeNode<Int>? = null
            get() {
                if (!rightGenerated) {
                    right = if (Random().nextBoolean()) LazyTreeNode() else null
                }

                return super.right
            }
            set(value) {
                rightGenerated = true
                field = value
                value?.parent = this
            }
    }
}