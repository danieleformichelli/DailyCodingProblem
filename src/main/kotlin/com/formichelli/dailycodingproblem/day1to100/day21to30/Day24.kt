package com.formichelli.dailycodingproblem.day1to100.day21to30

import com.formichelli.dailycodingproblem.util.TreeNode

/*
Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

is_locked, which returns whether the node is locked
lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
You may augment the node to add parent pointers or any other property you would like. You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.
*/
object Day24 {
    class LockedTreeNode<T>(value: T) : TreeNode<T>(value) {
        private var parent: LockedTreeNode<T>? = null

        override var left: TreeNode<T>?
            get() = super.left
            set(value) {
                super.left = value
                (value as LockedTreeNode<T>?)?.parent = this
            }

        override var right: TreeNode<T>?
            get() = super.right
            set(value) {
                super.right = value
                (value as LockedTreeNode<T>?)?.parent = this
            }

        var lockCount = 0

        // when a node is locked, increases its lockCount and the lockCount of all its ancestors
        fun lock(): Boolean {
            return if (lockCount == 0) {
                lockChain()
                true
            } else {
                false
            }
        }

        // when a node is unlocked, decreases its lockCount and the lockCount of all its ancestors
        private fun lockChain() {
            ++lockCount
            parent?.lockChain()
        }

        fun unlock(): Boolean {
            return if (isLocked() && lockCount == 1) {
                unlockChain()
                true
            } else {
                false
            }
        }

        private fun unlockChain() {
            --lockCount
            parent?.unlockChain()
        }

        // when a node is locked, it increases its lockCount and the lockCount of all its ancestors. Hence a node is locked if its lockCount is greater than the sum of the lockCounts of its children
        fun isLocked() = lockCount == ((left as LockedTreeNode<T>?)?.lockCount
                ?: 0) + ((right as LockedTreeNode<T>?)?.lockCount ?: 0) + 1
    }
}
