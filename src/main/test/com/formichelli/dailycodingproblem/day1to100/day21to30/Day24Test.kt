package com.formichelli.dailycodingproblem.day1to100.day21to30

import org.junit.Assert
import org.junit.Test

class Day24Test {
    @Test
    fun solution() {
        /*
           0
         1   2
        3 4 5 6
               7
         */
        val nodes = (0..7).map { Day24.LockedTreeNode(it) }
        nodes[0].left = nodes[1]
        nodes[0].right = nodes[2]
        nodes[1].left = nodes[3]
        nodes[1].right = nodes[4]
        nodes[2].left = nodes[5]
        nodes[2].right = nodes[6]
        nodes[6].right = nodes[7]

        Assert.assertEquals("Node 1 can be locked", true, nodes[0].lock())
        Assert.assertEquals("Node 1 is locked", true, nodes[0].isLocked())

        Assert.assertEquals("Node 7 can be locked", true, nodes[7].lock())
        Assert.assertEquals("Node 7 is locked", true, nodes[7].isLocked())

        Assert.assertEquals("Node 6 cannot be locked", false, nodes[6].lock())
        Assert.assertEquals("Node 6 is locked", false, nodes[6].isLocked())
        Assert.assertEquals("Node 6 cannot be unlocked", false, nodes[6].unlock())

        Assert.assertEquals("Node 1 cannot be locked", false, nodes[0].lock())
        Assert.assertEquals("Node 1 is not locked", true, nodes[0].isLocked())
        Assert.assertEquals("Node 1 cannot be unlocked", false, nodes[0].unlock())
        Assert.assertEquals("Node 1 is not locked", true, nodes[0].isLocked())

        Assert.assertEquals("Node 7 can be unlocked", true, nodes[7].unlock())
        Assert.assertEquals("Node 7 is not locked", false, nodes[7].isLocked())
        Assert.assertEquals("Node 1 can be unlocked", true, nodes[0].unlock())
        Assert.assertEquals("Node 1 is not locked", false, nodes[0].isLocked())
    }
}